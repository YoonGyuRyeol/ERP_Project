package vo;

public class Order {
	
	private String ordercode;
	private String clientname;
	private String itemname;
	private String orderday;
	private String delivery_day;
	private String forwarding_price;
	private int count;
	private String sv;
	private String total_amount;
	private String ecode;
	private String name;
	private String progress_status;
	public Order(String ordercode, String clientname, String itemname, String orderday, String delivery_day,
			String forwarding_price, int count, String sv, String total_amount, String ecode, String name,
			String progress_status) {
		super();
		this.ordercode = ordercode;
		this.clientname = clientname;
		this.itemname = itemname;
		this.orderday = orderday;
		this.delivery_day = delivery_day;
		this.forwarding_price = forwarding_price;
		this.count = count;
		this.sv = sv;
		this.total_amount = total_amount;
		this.ecode = ecode;
		this.name = name;
		this.progress_status = progress_status;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getOrderday() {
		return orderday;
	}
	public void setOrderday(String orderday) {
		this.orderday = orderday;
	}
	public String getDelivery_day() {
		return delivery_day;
	}
	public void setDelivery_day(String delivery_day) {
		this.delivery_day = delivery_day;
	}
	public String getForwarding_price() {
		return forwarding_price;
	}
	public void setForwarding_price(String forwarding_price) {
		this.forwarding_price = forwarding_price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSv() {
		return sv;
	}
	public void setSv(String sv) {
		this.sv = sv;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProgress_status() {
		return progress_status;
	}
	public void setProgress_status(String progress_status) {
		this.progress_status = progress_status;
	}
	
	
	
	
	
	
	
	



	

	
	
	
		
}
