package gr.hua.dit.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feeding")
public class Feeding {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "feeding_start")
	private String feedStart;
	
	@Column(name = "feeding_end")
	private String feedEnd;
	
	@Column(name = "application_start")
	private String appStart;
	
	@Column(name = "application_end")
	private String appEnd;
	
	@Column(name = "maxStudents")
	private int maxStudents;

	@OneToMany(mappedBy="department",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<Student> students;
	
	public Feeding() {
		
	}
	
	public Feeding(String feedStart, String feedEnd, String appStart, String appEnd, int maxStudents) {
		this.feedStart = feedStart;
		this.feedEnd = feedEnd;
		this.appStart = appStart;
		this.appEnd = appEnd;
		this.maxStudents = maxStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedStart() {
		return feedStart;
	}

	public void setFeedStart(String feedStart) {
		this.feedStart = feedStart;
	}

	public String getFeedEnd() {
		return feedEnd;
	}

	public void setFeedEnd(String feedEnd) {
		this.feedEnd = feedEnd;
	}

	public String getAppStart() {
		return appStart;
	}

	public void setAppStart(String appStart) {
		this.appStart = appStart;
	}

	public String getAppEnd() {
		return appEnd;
	}

	public void setAppEnd(String appEnd) {
		this.appEnd = appEnd;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void add(Student student) {
		
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
		student.setFeeding(this);
		
	}

	@Override
	public String toString() {
		return "Feeding [id=" + id + ", feedStart=" + feedStart + ", feedEnd=" + feedEnd + ", appStart=" + appStart
				+ ", appEnd=" + appEnd + ", maxStudents=" + maxStudents + "]";
	}
	
}