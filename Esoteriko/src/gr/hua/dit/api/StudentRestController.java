package gr.hua.dit.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	// return student by codeNumber
	@CrossOrigin
	@GetMapping("/students/{studentAM}")    
	public Student getStudentByAM(@PathVariable int studentAM) {

			String am = String.valueOf(studentAM);
			// get the student with ID
            Student student = studentDAO.getStudentByCodeNumber(am);

            if (student == null) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");
            }
            
            int id = student.getId();
            String fname = student.getFirstName();
            String lname = student.getLastName();
            String email = student.getEmail();
            String codeNumber = student.getCodeNumber();
            StudentProfile profile = student.getStudentProfile();
            
       
            
            List<StudentApplication> applications = new ArrayList<StudentApplication>();
            if(student.getApplications().isEmpty()) {
            	applications = null;
            	Student stud = new Student(id,codeNumber,fname,lname,email,profile);
               
                return stud;
            }else {
            	applications = student.getApplications();
            	
            	// empty list
                List<StudentApplication> appl1 = new ArrayList<StudentApplication>();
                // first application
                for(int i = 0; i < applications.size(); i++) {
                	StudentApplication application = applications.get(i);
                    String created = application.getCreated();
                    int income = application.getIncome();
                    String brotherss = application.getBrotherss();
                    String unployed = application.getUnemployed();
                    String diffCity = application.getDiffCity();
                    int points = application.getPoints();
                    String validated = application.getValidated();
                    StudentApplication app = new StudentApplication(created,income,brotherss,unployed,diffCity,points,validated);
                    
                    // add the application in application list
                    appl1.add(app);
                	
                }
                
                Student stud = new Student(id,codeNumber,fname,lname,email,profile,appl1);
            	return stud;
            	
            	
            }
            
    }
    	
	
}
