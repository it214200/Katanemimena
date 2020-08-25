package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.dao.DepartmentDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.Department;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentApplication;
import gr.hua.dit.entity.StudentProfile;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	
	@Autowired 
	private StudentDAO studentDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@GetMapping("/students/{studentId}")    
	public Student getStudent(@PathVariable int studentId) {

            Student student = studentDAO.getStudent(studentId);

            if (student == null) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");
            }
            
            int id = student.getId();
            String fname = student.getFirstName();
            String lname = student.getLastName();
            String email = student.getEmail();
            String am = student.getCodeNumber();
            StudentProfile profile = student.getStudentProfile();
            
            
            Student stud = new Student(id,am,fname,lname,email,profile);
            
            return stud;
    }
    
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		
		//Department dep = departmentDAO.getDepartment2(6);
		//dep.add(student);
		
		studentDAO.saveStudent(student);
		
		return student;
	}
	
	
}
