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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "dname")
	private String dName;
	
	@Column(name = "date_created")
	private String dCreated;
	
	@Column(name = "maxStudents")
	private int maxStudents;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="feeding_id")
	private Feeding feeding;

	// fetch=FetchType.LAZY
	@OneToMany(mappedBy="department",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Student> students;
	
	public Department() {
		
	}

	public Department(String dName, String dCreated, int maxStudents) {
		this.dName = dName;
		this.dCreated = dCreated;
		this.maxStudents = maxStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdCreated() {
		return dCreated;
	}

	public void setdCreated(String dCreated) {
		this.dCreated = dCreated;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public Feeding getFeeding() {
		return feeding;
	}

	public void setFeeding(Feeding feeding) {
		this.feeding = feeding;
	}

	public void add(Student student) {
		
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
		student.setDepartment(this);
		
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dName=" + dName + ", dCreated=" + dCreated + ", maxStudents=" + maxStudents
				+ ", feeding=" + feeding + ", students=" + students + "]";
	}

}
