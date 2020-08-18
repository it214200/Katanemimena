package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentProfile;

@Repository
public class StudentProfileDAOImpl implements StudentProfileDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	// annotate transactional launches and terminates a transaction
	@Override
	@Transactional
	public StudentProfile getProfile(int id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query, retrieve from database using the primary key
		StudentProfile studentProfile = currentSession.get(StudentProfile.class, id);      

		return studentProfile;
	}

	@Override
	@Transactional
	public void saveProfile(StudentProfile profile) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the data to db
		currentSession.save(profile);
	}

}
