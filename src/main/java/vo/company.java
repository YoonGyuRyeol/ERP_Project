package vo;

public class company {
	
	private String ccode;
	private String cname;
	private String representative;
	private String type_of_business;
	private String business_number;
	private String contact;
	private String representative_contact;
	private String address;
	private String representative_email;

	
	public company(String ccode, String cname, String representative, String type_of_business, 
			String business_number, String contact, String representative_contact, String address, String representative_email) {

		this.ccode = ccode;
		this.cname = cname;
		this.representative = representative;
		this.type_of_business = type_of_business;
		this.business_number = business_number;
		this.contact = contact;
		this.representative_contact = representative_contact;
		this.address = address;
		this.representative_email = representative_email;
		
	}


	public String getCcode() {
		return ccode;
	}


	public void setCcode(String clientcode) {
		this.ccode = clientcode;
	}
	
	public String getCname() {
		return cname;
	}


	public void setCname(String clientname) {
		this.cname = clientname;
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


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getRepresentative_contact() {
		return representative_contact;
	}


	public void setRepresentative_contact(String representative_contact) {
		this.representative_contact = representative_contact;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRepresentative_email() {
		return representative_email;
	}


	public void setRepresentative_email(String representative_email) {
		this.representative_email = representative_email;
	}



	


	
	
	
		
}
