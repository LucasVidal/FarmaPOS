package model;

public class Provider {

	private String name;
	private String contact;
	private String telephone;
	
	
	public Provider(String name, String contact, String telephone) {
		super();
		this.name = name;
		this.contact = contact;
		this.telephone = telephone;
	}


	public Provider(String name) {
		this(name,"","");
	}
	
}
