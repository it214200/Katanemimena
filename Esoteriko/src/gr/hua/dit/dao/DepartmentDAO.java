package gr.hua.dit.dao;

import gr.hua.dit.entity.Department;
import java.util.List;

public interface DepartmentDAO {

	public List<Department> getDepartments();
	public Department getDepartment(int id);
	public Department getDepartment2(int id);
	public void saveDepartment(Department dep);
}
