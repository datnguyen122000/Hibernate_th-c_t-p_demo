package fa.training.dao;

import java.util.List;

import org.hibernate.HibernateException;

import fa.training.entities.Student;

public interface StudentDAO {
	
	boolean save(Student student) throws HibernateException;
	
	List<Student> getAll() throws HibernateException;
	
	Student getByID1(int studentId) throws HibernateException;
	
	Student getByID2(int studentId) throws HibernateException;

}
