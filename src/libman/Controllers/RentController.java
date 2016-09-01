package libman.Controllers;

import libman.dao.RentDAOImpl;
import libman.models.Rent;

public class RentController {
	private RentDAOImpl rd = new RentDAOImpl();
	
	public void inputRent(Rent rent) {
		if(rent != null) {
			rd.inputRent(rent);
		}
	}
	
	public void updateRent(Rent rent) {
		if(rent != null) {
			rd.editRent(rent);
		}
	}
}
