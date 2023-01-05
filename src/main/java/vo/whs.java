package vo;

public class whs {
	
	private String waringcode;
	private String itemcode;
	private String itemname;
	private int count;
	private int uncount;
	private int refundcount;
	private int temporary_count;
	private int warecount;
	private int defective_count;
	public whs(String waringcode, String itemcode, String itemname, int count, int uncount, int refundcount,
			int temporary_count, int warecount, int defective_count) {
		super();
		this.waringcode = waringcode;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.count = count;
		this.uncount = uncount;
		this.refundcount = refundcount;
		this.temporary_count = temporary_count;
		this.warecount = warecount;
		this.defective_count = defective_count;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUncount() {
		return uncount;
	}
	public void setUncount(int uncount) {
		this.uncount = uncount;
	}
	public int getRefundcount() {
		return refundcount;
	}
	public void setRefundcount(int refundcount) {
		this.refundcount = refundcount;
	}
	public int getTemporary_count() {
		return temporary_count;
	}
	public void setTemporary_count(int temporary_count) {
		this.temporary_count = temporary_count;
	}
	public int getWarecount() {
		return warecount;
	}
	public void setWarecount(int warecount) {
		this.warecount = warecount;
	}
	public int getDefective_count() {
		return defective_count;
	}
	public void setDefective_count(int defective_count) {
		this.defective_count = defective_count;
	}
	
	
	
	
	
	
	
	
	
	



	

	
	
	
		
}
