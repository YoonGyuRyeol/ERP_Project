package dto;

public class ErpDTO {
	int item_code;
	String item_name;
	String receiving_unit_price;
	String release_unit_price;
	String Item_kind;
	String business_number;
	String owener_contact;
	String address;
	String owener_email;
	
	public int getItem_code() {
		return item_code;
	}
	public void setItem_code(int item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getReceiving_unit_price() {
		return receiving_unit_price;
	}
	public void setReceiving_unit_price(String receiving_unit_price) {
		this.receiving_unit_price = receiving_unit_price;
	}
	public String getRelease_unit_price() {
		return release_unit_price;
	}
	public void setRelease_unit_price(String release_unit_price) {
		this.release_unit_price = release_unit_price;
	}
	public String getItem_kind() {
		return Item_kind;
	}
	public void setItem_kind(String item_kind) {
		Item_kind = item_kind;
	}
	public String getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}
	public String getOwener_contact() {
		return owener_contact;
	}
	public void setOwener_contact(String owener_contact) {
		this.owener_contact = owener_contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwener_email() {
		return owener_email;
	}
	public void setOwener_email(String owener_email) {
		this.owener_email = owener_email;
	}
	
}
