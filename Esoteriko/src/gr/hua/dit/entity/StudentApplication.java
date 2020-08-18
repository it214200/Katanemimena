package gr.hua.dit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;

@Entity
@Table(name = "student_application")
public class StudentApplication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date_created")
	private String created;

	@Column(name = "income")
	private int income;

	@Column(name = "brother_sister")
	private String brotherss;
	
	@Column(name = "unemployed_parents")
	private String unemployed;
	
	@Column(name = "different_city")
	private String diffCity;
	
	@Column(name = "points")
	private int points;
	
	@Column(name = "validated")
	private String validated;

	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public StudentApplication() {
	
	}
	
	public StudentApplication(String created,int income,String brotherss,String unemployed,String diffCity, int points, String validated) {
		this.created = created;
		this.income = income;
		this.brotherss = brotherss;
		this.unemployed = unemployed;
		this.diffCity = diffCity;
		this.points = points;
		this.validated = validated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getUnemployed() {
		return unemployed;
	}

	public void setUnemployed(String unemployed) {
		this.unemployed = unemployed;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public String getBrotherss() {
		return brotherss;
	}

	public void setBrotherss(String brotherss) {
		this.brotherss = brotherss;
	}
	
	public String getDiffCity() {
		return diffCity;
	}

	public void setDiffCity(String diffCity) {
		this.diffCity = diffCity;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentApplication [id=" + id + ", created=" + created + ", income=" + income + ", brotherss="
				+ brotherss + ", unemployed=" + unemployed + ", diffCity=" + diffCity + ", points=" + points
				+ ", validated=" + validated + ", student=" + student + "]";
	}

}
