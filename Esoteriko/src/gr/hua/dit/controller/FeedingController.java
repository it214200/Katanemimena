package gr.hua.dit.controller;

import java.util.ArrayList;
import java.util.List;

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
import gr.hua.dit.dao.FeedingDAO;
import gr.hua.dit.entity.Department;
import gr.hua.dit.entity.Feeding;
import gr.hua.dit.entity.Student;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

	@Autowired
	private FeedingDAO feedingDAO;
	
	@Autowired
	private DepartmentDAO departmentDAO;
	
	@GetMapping("/rules")
	public String rules() {
	
		return "rules";
	}
	
	@GetMapping("/list")
	public String feedingList(Model model) {
		
		//List<Department> departments = departmentDAO.getDepartments();
		Department dep1  = departmentDAO.getDepartment2(1);
		Department dep2  = departmentDAO.getDepartment2(2);
		Department dep3  = departmentDAO.getDepartment2(3);
		Department dep4  = departmentDAO.getDepartment2(4);
		Department dep5  = departmentDAO.getDepartment2(5);
		
		// departments names
		String dep1Name = dep1.getdName();
		String dep2Name = dep2.getdName();
		String dep3Name = dep3.getdName();
		String dep4Name = dep4.getdName();
		String dep5Name = dep5.getdName();
		List<String> depListName = new ArrayList<String>();
		depListName.add(dep1Name);
		depListName.add(dep2Name);
		depListName.add(dep3Name);
		depListName.add(dep4Name);
		depListName.add(dep5Name);
		
		// size of department
		int maxStudentsD1 = dep1.getMaxStudents();
		int maxStudentsD2 = dep2.getMaxStudents();
		int maxStudentsD3 = dep3.getMaxStudents();
		int maxStudentsD4 = dep4.getMaxStudents();
		int maxStudentsD5 = dep5.getMaxStudents();
		List<Integer> maxStudents = new ArrayList<Integer>();
		maxStudents.add(maxStudentsD1);
		maxStudents.add(maxStudentsD2);
		maxStudents.add(maxStudentsD3);
		maxStudents.add(maxStudentsD4);
		maxStudents.add(maxStudentsD5);
		
		// students per department
		int y1Students,y2Students,y3Students,y4Students,seniorStudents;
		y1Students = y2Students = y3Students = y4Students = seniorStudents = 0;
		
		List<Department> departments = new ArrayList<Department>();
		departments.add(dep1);
		departments.add(dep2);
		departments.add(dep3);
		departments.add(dep4);
		departments.add(dep5);
		
		for(Department d:departments) {
			if(d.getId()==1) {
				y1Students = d.getStudents().size();
			}else if(d.getId()==2) {
				y2Students = d.getStudents().size();
			}else if(d.getId()==3) {
				y3Students = d.getStudents().size();
			}else if(d.getId()==4) {
				y4Students = d.getStudents().size();
			}else if(d.getId()== 5){
				seniorStudents = d.getStudents().size();
			}
		}
		
		List<Integer> years = new ArrayList<Integer>();
		years.add(y1Students);
		years.add(y2Students);
		years.add(y3Students);
		years.add(y4Students);
		years.add(seniorStudents);
		
		System.out.println("FEEDING");
		//List<Feeding> feedList = feedingDAO.getFeedings();
		
		Feeding feed1 = feedingDAO.getFeeding(1);
		Feeding feed2 = feedingDAO.getFeeding(2);
		Feeding feed3 = feedingDAO.getFeeding(3);
		Feeding feed4 = feedingDAO.getFeeding(4);
		Feeding feed5 = feedingDAO.getFeeding(5);
		
		
		int y1Winners = feed1.getStudents().size();
		int y2Winners = feed2.getStudents().size();
		int y3Winners = feed3.getStudents().size();
		int y4Winners = feed4.getStudents().size();
		int seniorWinners = feed5.getStudents().size();
		List<Integer> winners = new ArrayList<Integer>();
		winners.add(y1Winners);
		winners.add(y2Winners);
		winners.add(y3Winners);
		winners.add(y4Winners);
		winners.add(seniorWinners);
		
		List<Feeding> feedList = feedingDAO.getFeedings();
		
		model.addAttribute("depName",depListName);
		model.addAttribute("maxStudents",maxStudents);
		model.addAttribute("years",years);
		model.addAttribute("feedList", feedList);
		model.addAttribute("winners", winners);

		
		
		return "feeding";
	}

	@GetMapping("/view")
	public String view(@RequestParam("feedingId") int id, Model model) {
		
		String dName = departmentDAO.getDepartment2(id).getdName();
		Feeding f = feedingDAO.getFeeding(id);
		List<Student> students = f.getStudents();
		String feedingPeriod = f.getFeedStart() + "-" + f.getFeedEnd();
		
		model.addAttribute("dName",dName);
		model.addAttribute("students", students);
		model.addAttribute("feedingPeriod",feedingPeriod);
		
		return "viewFeeding";
	}
//	
//	@GetMapping("/selectDepartment") 
//	public String SelectDep(Model model) {
//		
//		// retrieve the departments without feeding, feeding_id = null
//		List<Department> departments = departmentDAO.getDepartmentsWithoutFeed();
//		
//		// prepare the dropdown list
//		List<String> dNames = new ArrayList<String>();
//		for(Department d:departments) {
//			dNames.add(d.getdName());
//		}
//		
//		Department dep = new Department();
//		model.addAttribute("department",dep);
//		model.addAttribute("dNames",dNames);
//		
//		return "selectDep";
//	}
//	
//	@PostMapping
//	public String saveDepartment(@ModelAttribute("department") Department dep,HttpServletRequest request) {
//		
//		
//		
//		HttpSession session = request.getSession();
//		//session.setAttribute("student", student);
//		
//		return "";
//	}
//	
//	@PostMapping
//	public String saveFeeding(@ModelAttribute("feed") Feeding feed) {
//		
//		// New Feed - Data from the selectDep.jsp
//		int depID = feed.getId();
//		String feedStart = feed.getFeedStart();
//		String feedEnd = feed.getFeedEnd();
//		String appStart = feed.getAppStart();
//		String appEnd = feed.getAppEnd();
//	
//		Department d = departmentDAO.getDepartment2(depID);
//		// get the max number of students from department
//		int maxStudentsDep = d.getMaxStudents();
//		
//		// new feed must have 80% deparment students
//		int maxStudents = (int) (maxStudentsDep*0.8);
//		
//		Feeding feeding = new Feeding(feedStart,feedEnd,appStart,appEnd,maxStudents);
//		
//		d.setFeeding(feeding);
//		
//		return "redirect:/Esoteriko";
//	}
//	
//	
//	
	
}
