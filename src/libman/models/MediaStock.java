package libman.models;

public class MediaStock {
	private Integer stockid;
	private Integer barcode;
	
	public Integer getStock(){
		return stockid;
	}
	
	public void setStock(Integer stock){
		this.stockid = stock;
	}
	
	public Integer getBarcode(){
		return barcode;
	}
	
	public void setBarcode(Integer barcode){
		this.barcode = barcode;
	}
}
