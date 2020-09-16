package gr.hua.dit.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import gr.hua.dit.dao.StudentApplicationDAO;
import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentApplication;
import gr.hua.dit.entity.StudentProfile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class ApplicationRestController {

	@Autowired
	private StudentApplicationDAO studentApplicationDAO;
	
	@Autowired 
	private StudentDAO studentDAO;
	
	
	// return all applications
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
	
	// return all applications
	@CrossOrigin(origins = "http://127.0.0.1:5501")
	@GetMapping("/applications/{studentAM}")    
	public List<StudentApplication> getApplicationsbyAM(@PathVariable int studentAM) {

		String am = String.valueOf(studentAM);
		List<StudentApplication> applications = studentApplicationDAO.getApplications2();

	    if (applications == null) {
	    	throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found");
	    }
	            
	    List<StudentApplication> applist = new ArrayList<StudentApplication>();
	    for(StudentApplication a:applications) {
	    	if(a.getStudent().getCodeNumber().contains(am)) {
	    	StudentApplication application = new StudentApplication(a.getId(),a.getCreated(),a.getIncome(),
	            			a.getBrotherss(),a.getUnemployed(),a.getDiffCity(),a.getPoints(),a.getValidated());
	    	
	            	applist.add(application);
	    	}
	    }
	            
	            return applist;
	}
	
	// return student application
	@GetMapping("/applications/{appId}")
	public StudentApplication getApplication(@PathVariable int appId) {
		
		// get application from the database with ID 
		StudentApplication application = studentApplicationDAO.getApplication(appId);
		
		return application;
	}
	
	// create a new application
	//@CrossOrigin(origins = "http://127.0.0.1:5501")
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping("/applications")
	public StudentApplication addApplication(@RequestBody StudentApplication application) {
		
		int id = application.getStudent().getId();
		
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
		finalApplication.setId(0);
		
		finalApplication.setCreated(currentDate);
		finalApplication.setIncome(income);
		finalApplication.setBrotherss(brotherSis);
		finalApplication.setUnemployed(unemployed);
		finalApplication.setDiffCity(diffCity);
		finalApplication.setPoints(points);
		finalApplication.setValidated(validated);
		
		// get student with id
		Student student = studentDAO.getStudent(id);
		
		
		
		student.add(finalApplication);
		studentApplicationDAO.saveApplication(finalApplication);
		
		return finalApplication;
	}
	
	
}
