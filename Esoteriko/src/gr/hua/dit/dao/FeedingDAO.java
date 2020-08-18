package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Feeding;

public interface FeedingDAO {

	public List<Feeding> getFeedings();
	public Feeding getFeeding(int id);
	
}
