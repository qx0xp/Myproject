package org.mymy.model;

public class RestDTO {
	private int no;
	private String firstName;
	private String lastName;
	
	// 생성자
	public RestDTO(int no, String firstName, String lastName) {
		this.no=no;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "RestDTO [no=" + no + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
