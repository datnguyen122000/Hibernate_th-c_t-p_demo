package fa.training.main;

import fa.training.dao.StudentDAO;
import fa.training.dao.impl.StudentDAOImpl;
import fa.training.entities.Student;
import fa.training.utils.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAOImpl();
		studentDAO.save(new Student(2, "KhoeHD2", "01-01-1997", 10, "PT", "0388446430"));
////		studentDAO.getAll().forEach(System.out::println);
//		
//		System.out.println(studentDAO.getByID2(2));

	}

}
