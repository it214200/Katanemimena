package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Feeding;

@Repository
public class FeedingDAOImpl implements FeedingDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Feeding> getFeedings() {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
		
        Query<Feeding> query = currentSession.createQuery("from Feeding",Feeding.class);
        
        List<Feeding> list = query.getResultList();
        
        return list;
	}

	@Override
	@Transactional
	public Feeding getFeeding(int id) {
		
		// get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Feeding> query = currentSession.createQuery("select i from Feeding i "
        					+ "JOIN FETCH i.students "
        				    + "where i.id=:feed_id",Feeding.class);
        
        query.setParameter("feed_id", id);
        
       Feeding feeding = query.getSingleResult();
		
		return feeding;
	}

	
}
