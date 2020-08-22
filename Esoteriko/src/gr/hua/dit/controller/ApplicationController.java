package gr.hua.dit.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.DepartmentDAO;
import gr.hua.dit.dao.StudentApplicationDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.dao.StudentProfileDAO;
import gr.hua.dit.entity.Department;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentApplication;
import gr.hua.dit.entity.StudentProfile;

@Controller
@RequestMapping("/application")
public class ApplicationController {

	// inject the studentApplication dao
	@Autowired
	private StudentApplicationDAO studentApplicationDAO;
	
	// inject the student dao
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@RequestMapping("/list")
	public String ApplicationList(Model model) {

		// get students from dao
		List<StudentApplication> applications = studentApplicationDAO.getApplications();

		// add the customers to the model
		model.addAttribute("applications", applications);

		return "list-applications";

	}
	
	@GetMapping("/selectAM")
	public String selectAM(Model model) {
		
		// Get the students per department
		List<Student> year1 = departmentDAO.getDepartment2(1).getStudents();
		List<Student> year2 = departmentDAO.getDepartment2(2).getStudents();
		List<Student> year3 = departmentDAO.getDepartment2(3).getStudents();
		List<Student> year4 = departmentDAO.getDepartment2(4).getStudents();
		List<Student> senior = departmentDAO.getDepartment2(5).getStudents();
		
		// save them into a new list 
		List<Student> allStudents = new ArrayList<Student>();
		allStudents.addAll(year1);
		allStudents.addAll(year2);
		allStudents.addAll(year3);
		allStudents.addAll(year4);
		allStudents.addAll(senior);
		
		// send them to form
		model.addAttribute("students",allStudents);
		return "AM-form";
	}
	
	@GetMapping("/createApplication")
	public String printAm(@RequestParam("codeNumber") String am,HttpServletRequest request,Model model) {
		
		// retrieve from db the selected student with AM 
		Student student = studentDAO.getStudentByCodeNumber(am);
		// save the student into a session 
		HttpSession session = request.getSession();
		session.setAttribute("student", student);
		
		StudentApplication application = new StudentApplication();
		model.addAttribute("application",application);
		return "application-form";
	}
	
	@PostMapping("/saveApplication")
	public String saveApplication(@ModelAttribute("application") StudentApplication application,HttpServletRequest request) {
		
		System.out.println("APPLICATION");

		StudentApplication appli = new StudentApplication();
		
		// Generate the current date of application
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String currentDate = df.format(dateobj);
		System.out.println("Current Date:"+currentDate);
		
		// Income 
		int income = application.getIncome();
		
		// Brothers
		String brotherSis = application.getBrotherss();
		int brother_sister = Integer.parseInt(brotherSis); 
		
		// take the value from unemployed parents 
		String unemployed = application.getUnemployed();
		
		
		// different city
		String diffCity = application.getDiffCity();
		
		// create the points of Application
		int points = 0;
		String expected = "Yes";
		
		if(income == 0 || unemployed.contains(expected)) {
			points+=1000;
		}else if (income < 10000) {
			points+=100;
		}else if (income >= 10000 && income <=15000) {
			points+=30;
		}else {
			points+=0;
		}
		
		// check whether has brothers and sisters
		if(brother_sister > 0) {
			points = points+ (brother_sister *20);// +20 points per brother/sister
		}
		
		// check if he is studying in a different city
		if(diffCity.contains(expected))
			points+=50;
		
		System.out.println("Points:"+points);
		
		
		// validate field by default false
		String validated = "No";
		
		// save the application data into a new object
		StudentApplication finalApplication = new StudentApplication();
		finalApplication.setCreated(currentDate);
		finalApplication.setIncome(income);
		finalApplication.setBrotherss(brotherSis);
		finalApplication.setUnemployed(unemployed);
		finalApplication.setDiffCity(diffCity);
		finalApplication.setPoints(points);
		finalApplication.setValidated(validated);
		
		// retrieve session, retrieve the data from the first form
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		System.out.println("AM Student:"+student.getCodeNumber());
		
		student.add(finalApplication);
		// save application
		studentApplicationDAO.saveApplication(finalApplication);
		
		
		// clear the session
		session.setAttribute("student", null);
		
		return "redirect:/application/list";
	}
	
	@GetMapping("/viewApplication")
	public String viewApplication(@RequestParam("applicationId") int id, Model model) {
		
		// Get the student profile from the database
		StudentApplication application = studentApplicationDAO.getApplication(id);
		Student student = application.getStudent();
		
		model.addAttribute("application",application);
		model.addAttribute("student",student);
		
		return "student-application";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("applicationId") int id) {

		// delete the application
		studentApplicationDAO.deleteApplication(id);
		return "redirect:/application/list";
	}
	
	@GetMapping("/showFormForEdit")
	public String showFormEdit(@RequestParam("applicationId") int id, Model model,HttpServletRequest request) {


		// get application from the database with ID 
		StudentApplication application = studentApplicationDAO.getApplication(id);
		int studentID = application.getStudent().getId();
		
		// save the student ID into a session 
		HttpSession session = request.getSession();
		session.setAttribute("id", studentID);
		
		// pass the object in the model in order to fill in the form
		model.addAttribute("application", application);
		// send over to our form
		return "editApplication";
	}
	
	@PostMapping("/saveEditProfile")
	public String saveEditProfile(@ModelAttribute("application") StudentApplication application,HttpServletRequest request) {
		
		// Generate Current date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String currentDate = df.format(dateobj);
		System.out.println("Current Date:"+currentDate);
		
		// create the points for application
		int income = application.getIncome();
		String brotherss = application.getBrotherss();
		int numberBrothers = Integer.parseInt(brotherss);
		String unemployed = application.getUnemployed();
		String diffCity = application.getDiffCity();
		
		
		int points = 0;
		String expected = "Yes";
		
		if(income == 0 || unemployed.contains(expected)) {
			points+=1000;
		}else if (income < 10000) {
			points+=100;
		}else if (income >= 10000 && income <=15000) {
			points+=30;
		}else {
			points+=0;
		}
		
		// check whether has brothers and sisters
		if(numberBrothers > 0) {
			points = points+ (numberBrothers *20);// +20 points per brother/sister
		}
		
		// check if he is studying in a different city
		if(diffCity.contains(expected))
			points+=50; // +50 points
		
		System.out.println("Points:"+points);
		
		application.setCreated(currentDate);
		application.setPoints(points);
		
		// retrieve session, retrieve the data from the first form
		HttpSession session = request.getSession();
		int studentID = (int)session.getAttribute("id");
				
		Student student = studentDAO.getStudent(studentID);
		student.add(application);
		
		// Save the Application
		studentApplicationDAO.saveApplication(application);

		// clear the session
		session.setAttribute("id", null);
		
		return "redirect:/application/list";
	}
	
	@GetMapping("/nonValid")
	public String nonValid(Model model) {
		
		List<StudentApplication> applications = studentApplicationDAO.getNonValidApplications();
		
		model.addAttribute("applications",applications);
		
		return "list-nonValidApplications";
	}
	
	@GetMapping("/rules")
	public String rules() {
		
		return "rules";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
