package libman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libman.DBConnector;
import libman.models.Rent;

public class RentDAOImpl implements RentDAO {
	private DBConnector connect = new DBConnector();
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private String query;
	private Integer i;
	private ArrayList<Rent> allrent = new ArrayList<Rent>();
	
	@Override
	public Integer inputRent(Rent rent) {
		try {
			query = "INSERT INTO rent (library_number, barcode, checkoutdate, duedate)" +
					" VALUES (?,?,?,?)";
			ps = connect.connect().prepareStatement(query);
			ps.setInt(1, rent.getLibid());
			ps.setInt(2, rent.getBarcode());
			ps.setString(3, rent.getCheckoutdate());
			ps.setString(4, rent.getDuedate());
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Integer editRent(Rent rent) {
		try {
			query = "UPDATE rent SET returndate = ?" + " WHERE library_number = ? and barcode = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setString(1, rent.getReturndate());
			ps.setInt(2, rent.getLibid());
			ps.setInt(3, rent.getBarcode());
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Integer deleteRent(Integer id, Integer id2) {
		try {
			query = "DELETE FROM rent WHERE library_number = ? AND barcode = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, id2);
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public ArrayList<Rent> findAllURent() {
		try {
			query = "SELECT * FROM rent WHERE returndate IS NULL";
			st = connect.connect().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setLibid(rs.getInt(1));
				rent.setBarcode(rs.getInt(2));
				rent.setCheckoutdate(rs.getString(3));
				rent.setDuedate(rs.getString(4));
				rent.setReturndate(rs.getString(5));
				allrent.add(rent);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allrent;
	}

	@Override
	public Rent findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rent> findAllCRent() {
		try {
			query = "SELECT * FROM rent WHERE returndate IS NOT NULL";
			st = connect.connect().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setLibid(rs.getInt(1));
				rent.setBarcode(rs.getInt(2));
				rent.setCheckoutdate(rs.getString(3));
				rent.setDuedate(rs.getString(4));
				rent.setReturndate(rs.getString(5));
				allrent.add(rent);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allrent;
	}

}
