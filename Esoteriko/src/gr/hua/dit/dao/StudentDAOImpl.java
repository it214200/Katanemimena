package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    
    // annotate transactional launches and terminates a transaction
    @Override
    @Transactional
	public List<Student> getStudents() {
    	// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        // create a query
        Query<Student> query = currentSession.createQuery("from Student", Student.class);        
        
        // execute the query and get the results list
        List<Student> students = query.getResultList();
                        
        //return the results, list of students
        return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// use the session to save the student in database
		currentSession.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
        // create a query, retrieve from database using the primary key
		Student student = currentSession.get(Student.class, id);
		
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query query = 
				currentSession.createQuery("delete from Student where id=:studentId");
		
		// set a parameter to use it into query
		query.setParameter("studentId", id);
		
		query.executeUpdate();
		
	}

}
