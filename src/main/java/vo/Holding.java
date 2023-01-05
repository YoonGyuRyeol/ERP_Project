package vo;

public class Holding {
	
	private String itemcode;
	private String itemname;
	private String warename;
	private String holdingday;
	private String receiving_price;
	private int acount;
	public Holding(String itemcode, String itemname, String warename, String holdingday, String receiving_price,
			int acount) {
		super();
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.warename = warename;
		this.holdingday = holdingday;
		this.receiving_price = receiving_price;
		this.acount = acount;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getWarename() {
		return warename;
	}
	public void setWarename(String warename) {
		this.warename = warename;
	}
	public String getHoldingday() {
		return holdingday;
	}
	public void setHoldingday(String holdingday) {
		this.holdingday = holdingday;
	}
	public String getReceiving_price() {
		return receiving_price;
	}
	public void setReceiving_price(String receiving_price) {
		this.receiving_price = receiving_price;
	}
	public int getAcount() {
		return acount;
	}
	public void setAcount(int acount) {
		this.acount = acount;
	}
	
	
	



	

	
	
	
		
}
