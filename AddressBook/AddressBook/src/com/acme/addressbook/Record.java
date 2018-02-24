package com.acme.addressbook;

@SuppressWarnings("rawtypes")
public class Record implements Comparable {

	private String name;
	private String email;
	private String phoneNo;

	public Record(String name, String email, String phoneNo) {
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public int compareTo(Object other) {
		// TODO implement this
		if( other instanceof Record == false)
			throw new IllegalArgumentException("Invalid argument : " + other.getClass().getName());
		return name.compareTo(((Record)other).name);
	}
	
	@Override
	public int hashCode(){ 
		return this.phoneNo.hashCode(); 
	}

	@Override
	public boolean equals(Object others) {
		Record r = (Record)others;
		System.out.println("asdf");
		if(this.email.equals(r.getEmail()) || this.phoneNo.equals(r.getPhoneNo())) {
			return true;
		}
		
		return false;
		
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{\n");
		sb.append("    name = ").append(name).append("\n");
		sb.append("    email = ").append(email).append("\n");
		sb.append("    phoneNo = ").append(phoneNo).append("\n");
		sb.append("}\n");

		return sb.toString();
	}
}
