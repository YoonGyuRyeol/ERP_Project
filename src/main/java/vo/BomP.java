package vo;

public class BomP {
	
	private String itemcode;
	private String itemname;
	private int materials;
	private String bom_code;
	public BomP(String itemcode, String itemname, int materials, String bom_code) {
		
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.materials = materials;
		this.bom_code = bom_code;
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
	public int getMaterials() {
		return materials;
	}
	public void setMaterials(int materials) {
		this.materials = materials;
	}
	public String getBom_code() {
		return bom_code;
	}
	public void setBom_code(String bom_code) {
		this.bom_code = bom_code;
	}
	
	
	
	



	

	
	
	
		
}
