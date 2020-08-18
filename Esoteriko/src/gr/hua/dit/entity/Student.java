package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.OneToMany;

// A pojo class that maps the object in database

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "codeNumber")
	private String codeNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	//@OneToOne()
	//@OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE,
		//	CascadeType.PERSIST,CascadeType.REFRESH})
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_profile_id")
	private StudentProfile studentProfile;

	@OneToMany(mappedBy="student",fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<StudentApplication> applications;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="dept_id")
	private Department department;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="feed_id")
	private Feeding feeding;
	
	public Student() {
	}

	public Student(String codeNumber, String firstName, String lastName, String email) {
		this.codeNumber = codeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentProfile getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}

	public List<StudentApplication> getApplications() {
		return applications;
	}

	public void setApplications(List<StudentApplication> applications) {
		this.applications = applications;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Feeding getFeeding() {
		return feeding;
	}

	public void setFeeding(Feeding feeding) {
		this.feeding = feeding;
	}

	public void add(StudentApplication application) {
		if(applications == null) {
			applications = new ArrayList<>();
		}
		applications.add(application);
		application.setStudent(this);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", codeNumber=" + codeNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", studentProfile=" + studentProfile + ", applications="
				+ applications + ", department=" + department + ", feeding=" + feeding + "]";
	}

}