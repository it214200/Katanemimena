package gr.hua.dit.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.dao.StudentApplicationDAO;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentApplication;
import gr.hua.dit.entity.StudentProfile;

@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	@Autowired
	private StudentApplicationDAO studentApplicationDAO;
	
	@GetMapping("/applications")    
	public List<StudentApplication> getApplications() {

            List<StudentApplication> applications = studentApplicationDAO.getApplications2();

            if (applications == null) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");
            }
            
            List<StudentApplication> applist = new ArrayList<StudentApplication>();
            for(StudentApplication a:applications) {
            	StudentApplication application = new StudentApplication(a.getId(),a.getCreated(),a.getIncome(),
            			a.getBrotherss(),a.getUnemployed(),a.getDiffCity(),a.getPoints(),a.getValidated());
            	applist.add(application);
            }
            
            return applist;
    }
	
	
	
}
