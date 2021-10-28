package fa.training.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.StudentDAO;
import fa.training.entities.Student;
import fa.training.utils.HibernateUtils;

public class StudentDAOImpl implements StudentDAO{
	private Session session;
	private Transaction transaction;

	public boolean save(Student student) throws HibernateException{
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();//bắt đầu
			session.save(student);
			transaction.commit();//đẩy code lên
			return true;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public List<Student> getAll() throws HibernateException{
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<Student> query = session.createQuery("FROM Student", Student.class);
			List<Student> students = query.list();
			transaction.commit();
			return students;
		}finally {
			session.close();
		}
	}

	public Student getByID1(int studentId) throws HibernateException {
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Student student = session.get(Student.class, studentId);
			transaction.commit();
			return student;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public Student getByID2(int studentId) throws HibernateException {
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query<Student> query = session.createQuery("FROM Student s WHERE s.studentID = :id", Student.class);
			query.setParameter("id", studentId);
			Student student = query.getSingleResult();
			transaction.commit();
			return student;
		}finally {
			session.close();
		}
	}

}
