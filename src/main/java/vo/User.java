package vo;

public class User {
	
	private String id;
	private String passwd;
	private int grade;
	private String ecode;
	private String name;
	private String position;

	
	public User(String id, String passwd, int grade, String ecode, String name, String position) {

		this.id = id;
		this.passwd = passwd;
		this.grade = grade;
		this.ecode = ecode;
		this.setPosition(position);
		this.setName(name);
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}



	
	
	
		
}
