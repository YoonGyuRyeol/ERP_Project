package vo;

public class pos {
	
	private String placecode;
	private String itemcode;
	private String itemname;
	private String clientname;
	private int count;
	public pos(String placecode, String itemcode, String itemname, String clientname, int count) {
		super();
		this.placecode = placecode;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.clientname = clientname;
		this.count = count;
	}
	public String getPlacecode() {
		return placecode;
	}
	public void setPlacecode(String placecode) {
		this.placecode = placecode;
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
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
	
	



	

	
	
	
		
}
