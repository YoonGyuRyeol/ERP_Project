package vo;

public class po {
	
	private String placecode;
	private String warename;
	private String orderday;
	private String delivery_day;
	private String sv;
	private String total_amount;
	private String ecode;
	private String name;
	private String progress_status;
	private String ordercode;
	public po(String placecode, String warename, String orderday, String delivery_day, String sv,
			String total_amount, String ecode, String name, String progress_status, String ordercode) {
		super();
		this.placecode = placecode;
		
		this.warename = warename;
		this.orderday = orderday;
		this.delivery_day = delivery_day;
		this.sv = sv;
		this.total_amount = total_amount;
		this.ecode = ecode;
		this.name = name;
		this.progress_status = progress_status;
		this.ordercode = ordercode;
	}
	public String getPlacecode() {
		return placecode;
	}
	public void setPlacecode(String placecode) {
		this.placecode = placecode;
	}
	
	public String getWarename() {
		return warename;
	}
	public void setWarename(String warename) {
		this.warename = warename;
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
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	
	
	
	
	



	

	
	
	
		
}
