package gr.hua.dit.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.DepartmentDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.dao.StudentProfileDAO;
import gr.hua.dit.entity.Department;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentProfile;

@Controller
@RequestMapping("/student")
public class StudentController {

	// inject the student dao
	@Autowired
	private StudentDAO studentDAO;

	// inject the studentprofile dao	
	@Autowired
	private StudentProfileDAO studentProfileDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@RequestMapping("/list")
	public String listStudents(Model model) {

		// get students from dao
		List<Student> students = studentDAO.getStudents();

		// add the customers to the model
		model.addAttribute("students", students);

		return "list-students";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Student student = new Student();
		model.addAttribute("student",student);

		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String showFormProfile(HttpServletRequest request,@ModelAttribute("student") Student student) {

		// save the student data save the data from the form into a session 
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		
		// going to second form 
		return "redirect:/student/showProfileFormForAdd";
	}
	
	@GetMapping("/showProfileFormForAdd")
	public String showProfileFormForAdd(Model model) {

		StudentProfile profile = new StudentProfile();
		model.addAttribute("profile",profile);

		return "profile-form";
	}
	
	@PostMapping("/saveProfile")
	public String saveProfile(HttpServletRequest request,@ModelAttribute("profile") StudentProfile profile) {
		
		Department department = departmentDAO.getDepartment2(6);
		
		// retrieve session, retrieve the data from the first form
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		System.out.println("STUDENT");
		System.out.println(student);
		System.out.println("Set profile data in student");
		student.setStudentProfile(profile);
		System.out.println(student);
		
		
		department.add(student);
		
		// save student data to database,first form
		System.out.println("SAVE STUDENT");
		studentDAO.saveStudent(student);
		
		// clear session
		session.setAttribute("student", null);
		
		return "redirect:/student/list";
	}

	@GetMapping("/showFormForEdit")
	public String showFormEdit(@RequestParam("studentId") int id, Model model) {


		// get the student from the database with ID 
		Student student = studentDAO.getStudent(id);
		
		
		// pass the student object in the model in order to fill in the form
		model.addAttribute("student", student);
		// send over to our form
		return "editStudent";
	}
	
	@PostMapping("/showFormProfileEdit")
	public String showFormProfileEdit(HttpServletRequest request,@ModelAttribute("student") Student student) {

		int id = student.getId();
		
		// save from the first form and save into a session 
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		
		return "redirect:/student/showUpdateProfile";
	}
	
	@GetMapping("/showUpdateProfile") 
	public String showUpdateProfile(HttpServletRequest request,Model model) {
		
		// take the data from the first form and save it into the session
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		int id = student.getId();
		System.out.println("Student ID: "+id);
		// retrieve from db the profile object with id
		StudentProfile profile = studentProfileDAO.getProfile(id);
		System.out.println("Profile: ");
		System.out.println(profile);

		
		model.addAttribute("profile",profile);
		
		return "editProfile";
	}
	
	@PostMapping("/saveEditProfile")
	public String saveEditProfile(@ModelAttribute("profile") StudentProfile profile,HttpServletRequest request) {
		
		// take the data from the first form and save it into the session
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		
		student.setStudentProfile(profile);
		System.out.println("Save Student");
		System.out.println(student);
		
		// save edit data to database
		studentDAO.saveStudent(student);

		// clear the session
		session.setAttribute("student", null);
		
		return "redirect:/student/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {

		// delete the student
		studentDAO.deleteStudent(id);

		return "redirect:/student/list";
	}

	@GetMapping("/profile")
	public String studentProfile(@RequestParam("studentId") int id, Model model) {

		// Get the student profile from the database
		Student student = studentDAO.getStudent(id);
		StudentProfile profile = student.getStudentProfile();
		//StudentProfile profile = studentProfileDAO.getProfile(id);

		// set student as a model attribute in order to fill the student form
		model.addAttribute("student",student);
		model.addAttribute("profile", profile);
		
		return "student-profile";
	}

}







