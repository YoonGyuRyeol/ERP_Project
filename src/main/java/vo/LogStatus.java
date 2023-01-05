package vo;

public class LogStatus {
	
	private String waringcode;
	private String itemcode;
	private String itemname;
	private String clientname;
	private String warename;
	private String holdingday;
	private int acount;
	private int changeacount;
	private String log_like;
	
	public LogStatus(String waringcode, String itemcode, String itemname, String clientname, String warename, 
			String holdingday, int acount, int changeacount, String log_like) {
		super();
		this.waringcode = waringcode;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.clientname = clientname;
		this.warename = warename;
		this.holdingday = holdingday;
		this.acount = acount;
		this.changeacount = changeacount;
		this.log_like = log_like;
	}

	public String getWaringcode() {
		return waringcode;
	}

	public void setWaringcode(String waringcode) {
		this.waringcode = waringcode;
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

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	public int getChangeacount() {
		return changeacount;
	}

	public void setChangeacount(int changeacount) {
		this.changeacount = changeacount;
	}

	public String getLog_like() {
		return log_like;
	}

	public void setLog_like(String log_like) {
		this.log_like = log_like;
	}

	
	
	
		
}
