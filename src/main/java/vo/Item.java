package vo;

public class Item {
	
	private String itemcode;
	private String itemname;
	private String receiving_price;
	private String forwarding_price;
	private String item_sortation;
	public Item(String itemcode, String itemname, String receiving_price, String forwarding_price,
			String item_sortation) {
		
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.receiving_price = receiving_price;
		this.forwarding_price = forwarding_price;
		this.item_sortation = item_sortation;
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
	public String getReceiving_price() {
		return receiving_price;
	}
	public void setReceiving_price(String receiving_price) {
		this.receiving_price = receiving_price;
	}
	public String getForwarding_price() {
		return forwarding_price;
	}
	public void setForwarding_price(String forwarding_price) {
		this.forwarding_price = forwarding_price;
	}
	public String getItem_sortation() {
		return item_sortation;
	}
	public void setItem_sortation(String item_sortation) {
		this.item_sortation = item_sortation;
	}
	
	



	

	
	
	
		
}
