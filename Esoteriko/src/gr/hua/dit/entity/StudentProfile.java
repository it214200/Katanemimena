package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "current_semester")
    private String currentSemester;
	
    @Column(name = "status_studies")
    private String status;
    
    @Column(name = "is_active")
    private String active;
    
    @Column(name = "registered_from")
    private String registeredFrom;
    
    @Column(name = "mothers_name")
    private String mName;
    
    @Column(name = "fathers_name")
    private String fName;
    
    @Column(name = "birth_date")
    private String birthDate;
    
    @Column(name = "phone")
    private String phone;
       
    public StudentProfile() {
    	
    }
    
	public StudentProfile(String currentSemester, String status, String active,
			String registeredFrom, String mName, String fName, String birthDate, String phone) {
		this.currentSemester = currentSemester;
		this.status = status;
		this.active = active;
		this.registeredFrom = registeredFrom;
		this.mName = mName;
		this.fName = fName;
		this.birthDate = birthDate;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentSemester() {
		return currentSemester;
	}

	public void setCurrentSemester(String currentSemester) {
		this.currentSemester = currentSemester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getRegisteredFrom() {
		return registeredFrom;
	}

	public void setRegisteredFrom(String registeredFrom) {
		this.registeredFrom = registeredFrom;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StudentProfile [id=" + id + ", currentSemester=" + currentSemester
				+ ", status=" + status + ", active=" + active + ", registeredFrom=" + registeredFrom + ", mName="
				+ mName + ", fName=" + fName + ", birthDate=" + birthDate + ", phone=" + phone + "]";
	}

}
