package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.StudentApplication;

public interface StudentApplicationDAO {

	public List<StudentApplication> getApplications();
	public void saveApplication(StudentApplication application);
	public StudentApplication getApplication(int id);
	public StudentApplication getApplicationbyPoints(String points);
	public void deleteApplication(int id);
	public List<StudentApplication> getNonValidApplications();
	public List<StudentApplication> getApplications2();
	public void deleteApp(StudentApplication application);
}
