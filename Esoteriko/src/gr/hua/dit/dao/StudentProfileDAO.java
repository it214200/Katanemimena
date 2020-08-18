package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.StudentProfile;

public interface StudentProfileDAO {

	public StudentProfile getProfile(int id);
	public void saveProfile(StudentProfile profile);
	
}
