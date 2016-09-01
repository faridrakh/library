package libman.dao;

import java.util.ArrayList;

import libman.models.Rent;

public interface RentDAO {
	
	public Integer inputRent(Rent rent);
	public Integer editRent(Rent rent);
	public Integer deleteRent(Integer id, Integer id2);
	public ArrayList<Rent> findAllURent();
	public ArrayList<Rent> findAllCRent();
	public Rent findById(Integer id);
	
}
