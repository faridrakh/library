package libman.models;

public class Rent {
	private Integer libid;
	private Integer barcode;
	private String checkoutdate;
	private String duedate;
	private String returndate;
	
	public Integer getLibid(){
		return libid;
	}
	
	public void setLibid(Integer libid){
		this.libid = libid;
	}
	
	public Integer getBarcode(){
		return barcode;
	}
	
	public void setBarcode(Integer barcode){
		this.barcode = barcode;
	}

	public String getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getReturndate() {
		return returndate;
	}

	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
}
