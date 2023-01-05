package vo;

public class employee {
	
	
	private String ecode;
	private String name;
	private String department;
	private String position;
	public employee(String ecode, String name, String department, String position) {
		super();
		this.ecode = ecode;
		this.name = name;
		this.department = department;
		this.position = position;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	
	


	
	
	
		
}
