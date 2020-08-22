package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import gr.hua.dit.entity.Department;
import gr.hua.dit.entity.Student;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	// inject the session factory
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	@Transactional
	public List<Department> getDepartments() {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Department> query = currentSession.createQuery("from Department",Department.class);
        
        List<Department> departments = query.getResultList();
		return departments;
	}

	@Override
	@Transactional
	public Department getDepartment(int id) {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Department department = currentSession.get(Department.class, id);
        
		return department;
	}

	@Override
	@Transactional
	public Department getDepartment2(int id) {

		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Department> query = currentSession.
        		createQuery("select i from Department i "
        					+ "JOIN FETCH i.students "
        				    + "where i.id=:depart_id",Department.class);
        		
        query.setParameter("depart_id", id);
        
        Department department = query.getSingleResult();
        
		return department;
	}

	@Override
	@Transactional
	public void saveDepartment(Department dep) {

		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        currentSession.saveOrUpdate(dep);
	}

}
