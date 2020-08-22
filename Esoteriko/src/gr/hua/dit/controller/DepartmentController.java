package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/department")
public class DepartmentController {

	// inject the student dao
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private StudentProfileDAO studentProfileDAO;
	
	@Autowired
	private StudentApplicationDAO studentApplicationDAO;
	
	@RequestMapping("/list")
	public String departmentList(Model model) {
		
		List<Department> departments =  departmentDAO.getDepartments();
				
		int year1,year2,year3,year4,senior,newcomers;
		year1 = year2 = year3 = year4 = senior = newcomers = 0;
		try {
			List<Student> students = studentDAO.getStudents();
			for(Student s:students) {
				int dedID = s.getDepartment().getId();
				if(dedID == 1) {
					year1++;
				}else if(dedID == 2) {
					year2++;
				}else if(dedID == 3) {
					year3++;
				}else if(dedID == 4){
					year4++;
				}else if(dedID == 6){
					newcomers++;
				}else {
					senior++;
				}
			}	
		}catch(java.lang.NullPointerException e) {
			System.out.println("Null Value");
		}
		
		List<Integer> years=new ArrayList<Integer>();
		years.add(year1);
		years.add(year2);
		years.add(year3);
		years.add(year4);
		years.add(senior);
		years.add(newcomers);
		
		model.addAttribute("departments",departments);
		model.addAttribute("years",years);
		
		return "list-departments";
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("departmentId") int id,Model model) {
		
		Department department = departmentDAO.getDepartment2(id);
	
		List<Student> students = department.getStudents();
		
		model.addAttribute("department",department);
		model.addAttribute("students",students);
			
		return "department";
	}
	
	@GetMapping("/editDepartment")
	public String editDepartment(@RequestParam("departmentId") int id,Model model) {
		Department department = departmentDAO.getDepartment(id);
		
		List<Student> students = studentDAO.getStudents();
		
		// create a new student list that match the department ID we chose
		List<Student> depStudents = new ArrayList<Student>();
		
		// if the id of student (depart_id) is the same with ID department then
		try {	
			for(Student s:students) {
				if(s.getDepartment().getId() == id) {
					depStudents.add(s);
				}
				
			}
		}catch(java.lang.NullPointerException e) {
			System.out.println("Null Value");
		}
		
		
		model.addAttribute("department",department);
		model.addAttribute("depStudents",depStudents);
		
		return "editDepartment";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(@RequestParam("departmentId") int id,Model model,HttpServletRequest request) {
		
		System.out.println("Department:"+id);
		// save the department ID into the session
		HttpSession session = request.getSession();
		session.setAttribute("depID", id);
		
		// take the list with new students, students without department
		Department newcomers = departmentDAO.getDepartment2(6);
		List<Student> students = newcomers.getStudents();
		
		// Preparing values for  Dropdown list, save the code numbers of new students into a new list
		List<String> codeNumbers = new ArrayList<String>();
		for(Student s:students) {
			codeNumbers.add(s.getCodeNumber());
		}
		
		// empty object to save the values from the form
		Student student = new Student();
		
		
		model.addAttribute("student",student);
		model.addAttribute("codeNumbersOptions",codeNumbers);
		
		return "selectStudent";
	}
	
	@PostMapping("/saveSelection")
	public String saveSelection(@ModelAttribute("student") Student student,HttpServletRequest request) {
		
		// take the codeNumber(selection) from the form
		String am = student.getCodeNumber();
		// from code number we retrieve the student from database
		Student stud = studentDAO.getStudentByCodeNumber(am);
		
		// copy the data of the student to new student object
		int id = stud.getId();
		String codeNumber = stud.getCodeNumber();
		String fname = stud.getFirstName();
		String lname = stud.getLastName();
		String email = stud.getEmail();
		Student newStudent = new Student(codeNumber,fname,lname,email);
		
		// >> >> profile data
		StudentProfile profile = studentProfileDAO.getProfile(id);
		String semester = profile.getCurrentSemester();
		String status = profile.getStatus();
		String active = profile.getStatus();
		String registeredFrom = profile.getRegisteredFrom();
		String mName = profile.getfName();
		String fName = profile.getfName();
		String bDate = profile.getBirthDate();
		String phone = profile.getPhone();
		
		StudentProfile newProfile = new StudentProfile(semester,status,active,registeredFrom,
				mName,fName,bDate,phone);
		
		// we delete the old object from databse to not have conflict with new one
		studentDAO.deleteStudent(id);
		System.out.println("Student Deleted");
		
		newStudent.setStudentProfile(newProfile);
		
		// get id of department in order to add the student in new department
		HttpSession session = request.getSession();
		int depID = (int)session.getAttribute("depID");
		
		// retrieve the department that we want to add the student
		Department department = departmentDAO.getDepartment2(depID);
		department.add(newStudent);
		
		// save student data to database,first form
		System.out.println("SAVE STUDENT");
		studentDAO.saveStudent(newStudent);
				
		int max = department.getMaxStudents();
		max = max - 1;
		department.setMaxStudents(max);
		
		// save department
		departmentDAO.saveDepartment(department);
	
		// clear session
		session.setAttribute("depID", null);
				
		
		return "redirect:/department/list";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int id,Model model) {
		System.out.println("HI");
		//int id = Integer.parseInt(studentId);
		Student stud = studentDAO.getStudent(id);
		System.out.println("GET THE STUDENT");
		System.out.println("AM: "+stud.getCodeNumber());

		
		String codeNumber = stud.getCodeNumber();
		String fname = stud.getFirstName();
		String lname = stud.getLastName();
		String email = stud.getEmail();
		Student student = new Student(codeNumber,fname,lname,email);
		
		StudentProfile profile = studentProfileDAO.getProfile(id);
		System.out.println("GET THE PROFILE");
		String semester = profile.getCurrentSemester();
		String status = profile.getStatus();
		String active = profile.getStatus();
		String registeredFrom = profile.getRegisteredFrom();
		String mName = profile.getfName();
		String fName = profile.getfName();
		String bDate = profile.getBirthDate();
		String phone = profile.getPhone();
		
		StudentProfile newProfile = new StudentProfile(semester,status,active,registeredFrom,
				mName,fName,bDate,phone);
		
		student.setStudentProfile(newProfile);
		System.out.println("SET THE STUDENT");
		
		List<StudentApplication> applications = studentApplicationDAO.getApplications2();
		for(StudentApplication a:applications) {
			int studentID = a.getStudent().getId();
			int appID = a.getId();
			if(studentID == id) {
				StudentApplication application = studentApplicationDAO.getApplication(appID);
				studentApplicationDAO.deleteApp(application);
			}
		}
		
		studentDAO.deleteStudent(id);
		System.out.println("DELETE THE STUDENT");

		
		// retrieve the newcomers department 
		Department department = departmentDAO.getDepartment2(6);
		/* we add temporarily the student that we deleted from the old department
		and place him to newcomers department */
		System.out.println("RETRIEVE THE DEPARTMENT");

		department.add(student);
		System.out.println("ADD THE STUDENT");

		studentDAO.saveStudent(student);
		System.out.println("STUDENT SAVED");

		
		return "redirect:/department/list";
	}
	
}










