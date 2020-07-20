package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	// inject the customer dao
	@Autowired
	private StudentDAO studentDAO;

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
	
	// add a student object in database and return to '/student/list'
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentDAO.saveStudent(student);
		return "redirect:/student/list";
	}
	
	@GetMapping("/showFormForEdit")
	public String showFormEdit(@RequestParam("studentId") int id, Model model) {
		
		
		// get the student from the database with ID 
		Student student = studentDAO.getStudent(id);
		// set student as a model attribute in order to fill the student form
		model.addAttribute("student", student);
		// send over to our form
		return "student-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {
		
		// delete the student
		studentDAO.deleteStudent(id);
		
		return "redirect:/student/list";
	}

}







