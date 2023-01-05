package vo;

public class BomS {
	private String productcode;
	private String productname;
	private String itemcode;
	private String itemname;
	private int materials;
	private String bom_code;
	public BomS(String productcode, String productname, String itemcode, String itemname, int materials,
			String bom_code) {
		
		this.productcode = productcode;
		this.productname = productname;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.materials = materials;
		this.bom_code = bom_code;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
