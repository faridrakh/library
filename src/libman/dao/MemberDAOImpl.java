package libman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libman.DBConnector;
import libman.models.Member;

public class MemberDAOImpl implements MemberDAO {
	private DBConnector connect = new DBConnector();
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private String query;
	private Integer i;
	private ArrayList<Member> allmem = new ArrayList<Member>(); 
	
	
	@Override
	public Integer saveMember(Member member) {
		// TODO Auto-generated method stub
		try {
			query = "INSERT INTO member(library_number, fname, lname, dob, address, phone, username, password, member_exp)"
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			ps = connect.connect().prepareStatement(query);
		    ps.setInt(1, member.getLibId());
		    ps.setString(2, member.getFName());
		    ps.setString(3, member.getLName());
		    ps.setString(4, member.getDob());
		    ps.setString(5, member.getAddress());
		    ps.setString(6, member.getPhone());
		    ps.setString(7, member.getUsername());
		    ps.setString(8, member.getPassword());
		    ps.setString(9, member.getMem_exp());
		    
		    i = ps.executeUpdate();
		    ps.close();
		    
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Integer updateMember(Member member) {
		try{
			query = "UPDATE member SET fname = ?," + "lname = ?," + "dob = ?," + "address = ?," + "phone = ?," 
					+ "username = ?," + "password = ?," + "member_exp = ?" + " WHERE library_number = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setString(1, member.getFName());
			ps.setString(2, member.getLName());
			ps.setString(3, member.getDob());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getPhone());
			ps.setString(6, member.getUsername());
			ps.setString(7, member.getPassword());
			ps.setString(8, member.getMem_exp());
			ps.setInt(9, member.getLibId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Integer deleteMember(Integer id) {
		try {
			query = "DELETE FROM member WHERE library_number = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setInt(1, id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public Member findById(Integer id) {
		
		
		return null;
	}

	@Override
	public Member findByName(String fname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> findAllMember() {
		try {
			query = "SELECT * FROM member";
			st = connect.connect().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Member member = new Member();
				member.setLibId(rs.getInt(1));
				member.setFName(rs.getString(2));
				member.setLName(rs.getString(3));
				member.setDob(rs.getString(4));
				member.setAddress(rs.getString(5));
				member.setPhone(rs.getString(6));
				member.setUsername(rs.getString(7));
				member.setPassword(rs.getString(8));
				member.setMem_exp(rs.getString(9));
				allmem.add(member);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allmem;
	}


}
