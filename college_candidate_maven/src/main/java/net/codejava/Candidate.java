package net.codejava;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Candidate {
	
	private Long primaryKey;
	private String firstName;
	private String additionalName;
	private String lastName;
	private String emailAddress;
	private int phone;
	private String position;
	private String school;
	private String status;
	private String other;
	
	protected Candidate() {
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}
	
		public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getAdditionalName() {
		return additionalName;
	}
	
	
	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	public int getPhone() {
		return phone;
	}
	
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	public String getPosition() {
		return position;
	}
	
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	public String getSchool() {
		return school;
	}
	
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public String getOther() {
		return other;
	}
	
	
	public void setOther(String other) {
		this.other = other;
	}
	
	
//    public Long getId() {
//        return primaryKey;
//    }
//	
//	public void setId(Long id) {
//		this.id = id;
//	}
}

