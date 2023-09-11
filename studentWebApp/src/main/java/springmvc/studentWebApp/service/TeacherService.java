package springmvc.studentWebApp.service;

import java.util.List;
import springmvc.studentWebApp.Model.Student;

public interface TeacherService {
	Student getStudent(int id);
	List<Student> getAllStudents();
	void addStudent(Student student);
	void editStudent(Student student);
	void deleteStudent(int id);
	void deleteAllStudents();
	public boolean studentInThisClass(Student student);
}
