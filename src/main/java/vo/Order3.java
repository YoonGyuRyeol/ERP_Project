package vo;

public class Order3 {
	
	private String clientcode;
	private String clientname;
	private String representative;
	private String type_of_business;
	private String business_number;
	private String address;
	private String itemname;
	private String delivery_day;
	private String forwarding_price;
	private int count;
	private String sv;
	private String total_amount;
	private String tax;
	private String date;
	private int mm;
	private int dd;

	public Order3(String clientcode, String clientname, String representative, String type_of_business, 
			String business_number, String address, String itemname, String delivery_day,
			String forwarding_price, int count, String sv, String total_amount, String tax, String date, int mm, int dd) {
		super();
		this.clientcode = clientcode;
		this.clientname = clientname;
		this.representative = representative;
		this.type_of_business = type_of_business;
		this.business_number = business_number;
		this.address = address;
		this.itemname = itemname;
		this.delivery_day = delivery_day;
		this.forwarding_price = forwarding_price;
		this.count = count;
		this.sv = sv;
		this.total_amount = total_amount;
		this.tax = tax;
		this.date = date;
		this.mm = mm;
		this.dd = dd;
	}

	public String getClientcode() {
		return clientcode;
	}

	public void setClientcode(String clientcode) {
		this.clientcode = clientcode;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getType_of_business() {
		return type_of_business;
	}

	public void setType_of_business(String type_of_business) {
		this.type_of_business = type_of_business;
	}

	public String getBusiness_number() {
		return business_number;
	}

	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
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
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getmm() {
		return mm;
	}

	public void setmm(int mm) {
		this.mm = mm;
	}

	public int getdd() {
		return dd;
	}

	public void setDD(int dd) {
		this.dd = dd;
	}
	
		
}
