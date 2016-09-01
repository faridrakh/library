package libman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libman.DBConnector;
import libman.models.Media;

public class MediaDAOImpl implements MediaDAO {
	private DBConnector connect = new DBConnector();
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	private String query;
	private Integer i;
	private ArrayList<Media> allmed = new ArrayList<Media>(); 

	@Override
	public Integer saveMedia(Media media) {
		try {
			query = "INSERT INTO media (barcode, title, author, year, publisher, type, description)" +
					" VALUES (?,?,?,?,?,?,?)";
			ps = connect.connect().prepareStatement(query);
			ps.setInt(1, media.getBarcode());
			ps.setString(2, media.getTitle());
			ps.setString(3, media.getAuthor());
			ps.setInt(4, media.getYear());
			ps.setString(5, media.getPublisher());
			ps.setString(6, media.getType());
			ps.setString(7, media.getDescription());
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Integer updateMedia(Media media) {
		try {
			query = "UPDATE media SET title = ?," + " author = ?," + " year = ?," + " publisher = ?," +
					" type = ?," + " description = ?" + " WHERE barcode = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setString(1, media.getTitle());
			ps.setString(2, media.getAuthor());
			ps.setInt(3, media.getYear());
			ps.setString(4, media.getPublisher());
			ps.setString(5, media.getType());
			ps.setString(6, media.getDescription());
			ps.setInt(7, media.getBarcode());
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public Integer deleteMedia(Integer id) {
		try {
			query = "DELETE FROM media WHERE barcode = ?";
			ps = connect.connect().prepareStatement(query);
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public ArrayList<Media> findAllMedia() {
		try {
			query = "SELECT * FROM media";
			st = connect.connect().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Media media = new Media();
				media.setBarcode(rs.getInt(1));
				media.setTitle(rs.getString(2));
				media.setAuthor(rs.getString(3));
				media.setYear(rs.getInt(4));
				media.setPublisher(rs.getString(5));
				media.setType(rs.getString(6));
				media.setDescription(rs.getString(7));
				allmed.add(media);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allmed;
	}

	@Override
	public Media findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Media findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
