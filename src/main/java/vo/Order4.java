package vo;

public class Order4 {
	
	private String itemname;
	private String clientname;
	private String sum;
	private String count;
	private String sv;
	private String total_amount;
	private String tax;
	private String date;
	private int mm;
	private int dd;

	public Order4(String itemname, String clientname, String sum, String count,
			String sv, String total_amount, String tax, String date, int mm, int dd) {
		super();
		this.itemname = itemname;
		this.clientname = clientname;
		this.sum = sum;
		this.count = count;
		this.sv = sv;
		this.total_amount = total_amount;
		this.tax = tax;
		this.date = date;
		this.mm = mm;
		this.dd = dd;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
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

	public int getMm() {
		return mm;
	}

	public void setMm(int mm) {
		this.mm = mm;
	}

	public int getDd() {
		return dd;
	}

	public void setDd(int dd) {
		this.dd = dd;
	}


}
