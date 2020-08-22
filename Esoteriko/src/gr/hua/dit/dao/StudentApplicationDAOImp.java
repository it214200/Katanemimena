package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentApplication;

@Repository
public class StudentApplicationDAOImp implements StudentApplicationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<StudentApplication> getApplications() {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<StudentApplication> query = currentSession.createQuery("from StudentApplication", StudentApplication.class);        
        
        // execute the query and get the results list
        List<StudentApplication> applications = query.getResultList();
                        
        //return the results, list of students
		return applications;
	}

	@Override
	@Transactional
	public void saveApplication(StudentApplication application) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// use the session to save the student in database
		currentSession.saveOrUpdate(application);
	}

	@Override
	@Transactional
	public StudentApplication getApplication(int id) {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        StudentApplication application = currentSession.get(StudentApplication.class, id);
		
        return application;
	}

	@Override
	@Transactional
	public StudentApplication getApplicationbyPoints(String points) {

		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
       Criteria criteria =  currentSession.createCriteria(StudentApplication.class); 
       StudentApplication application = (StudentApplication) criteria.add(Restrictions.eq("points", points)).uniqueResult();
       
       return application;
	}

	@Override
	@Transactional
	public void deleteApplication(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// delete object with primary key
		Query query = currentSession.createQuery("delete from StudentApplication where id=:applicationId");
		
		// set a parameter to use it into query
		query.setParameter("applicationId", id);
				
		query.executeUpdate();
	}

	@Override
	@Transactional
	public List<StudentApplication> getNonValidApplications() {
		
		String validated = "No";
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		// delete object with primary key
		Query<StudentApplication> query = currentSession.createQuery("from StudentApplication where validated=:NonValidated");
				
		// set a parameter to use it into query
		query.setParameter("NonValidated", validated);
		
		List<StudentApplication> applications = query.getResultList();
		
		return applications;
	}

	@Override
	@Transactional
	public List<StudentApplication> getApplications2() {
		
		
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query<StudentApplication> query = currentSession.createQuery(
		"from StudentApplication i "
		+ "JOIN FETCH i.student",StudentApplication.class);
		
		List<StudentApplication> applications = query.list();
		
		return applications;
	}

	@Override
	@Transactional
	public void deleteApp(StudentApplication application) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete(application);
		
	}
	
}
