package com.example.demo.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.StudentController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void getStudent() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);

		Root<Student> student = cq.from(Student.class);
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		    
		System.out.println(resultList);
		
	}
	
	@Override
	public void getStudent1() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 CriteriaQuery<Tuple> cq = cb.createTupleQuery();

		Root<Student> student = cq.from(Student.class);
		cq.select(student.get("last_name"));
		TypedQuery<Tuple> tq = entityManager.createQuery(cq);
		List<Tuple> resultList = tq.getResultList();
		    
		resultList.forEach(e -> { System.out.println(e.get(0)); });
		
	}
	
	@Override
	public void getStudent2() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 CriteriaQuery<Tuple> cq = cb.createTupleQuery();

		Root<Student> student = cq.from(Student.class);
		cq.multiselect(student.get("first_name"),student.get("last_name"));
		TypedQuery<Tuple> tq = entityManager.createQuery(cq);
		List<Tuple> resultList = tq.getResultList();
		    
		resultList.forEach(e -> { System.out.printf("%s%s",e.get(0) , e.get(1)); });	
	}
	
	@Override
	public void getStudent3() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(cb.construct(String.class,root.get("first_name")));
		TypedQuery<String> tq = entityManager.createQuery(cq);
		List<String> resultList = tq.getResultList();
		System.out.println(resultList);
	}
	
	@Override
	public void getStudent4() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.multiselect(root.get("first_name"),root.get("last_name"));
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		System.out.println(resultList);
	}
	
	//sessionFactory
	@Override
	public void getStudent5() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.multiselect(root.get("first_name"),root.get("last_name"));
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		System.out.println(resultList);
	}

	@Override
	public void getStudent6() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.orderBy(cb.asc(root.get("password")));
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		System.out.println(resultList);
		
		for(Student s : resultList)
		{
			System.out.println(s.getPassword());
		}
		
		cq.orderBy(cb.desc(root.get("password")));
		TypedQuery<Student> tq1 = entityManager.createQuery(cq);
		List<Student> resultList1 = tq1.getResultList();
		System.out.println(resultList1);
		
		for(Student s : resultList1)
		{
			System.out.println(s.getPassword());
		}
	}
	
	@Override
	public void getStudent7() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.where(cb.greaterThan(root.get("age"), 20));
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		System.out.println(resultList);
		
		cq.where(cb.lt(root.get("age"),25));
		TypedQuery<Student> tq1 = entityManager.createQuery(cq);
		List<Student> resultList1 = tq1.getResultList();
		System.out.println(resultList1);
		
		cq.where(cb.between(root.get("age"),18,25));
		TypedQuery<Student> tq2 = entityManager.createQuery(cq);
		List<Student> resultList2 = tq2.getResultList();
		System.out.println(resultList2);
		
		cq.where(cb.like(root.get("first_name"),"M%"));
		TypedQuery<Student> tq3 = entityManager.createQuery(cq);
		List<Student> resultList3 = tq3.getResultList();
		System.out.println(resultList3);
		
		cq.where(cb.in(root.get("age")).value(18).value(37));
		TypedQuery<Student> tq4 = entityManager.createQuery(cq);
		List<Student> resultList4 = tq4.getResultList();
		System.out.println(resultList4);
	}
	
	//error
	@Override
	public void getStudent8() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.multiselect(root.get("age"),cb.count(root)).groupBy(root.get("age"));
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.getResultList();
		System.out.println(resultList);
	}

	//2nd highest salary 
	@Override
	public void getStudent9() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.orderBy(cb.desc(root.get("salary")));
		
		TypedQuery<Student> tq = entityManager.createQuery(cq);
		List<Student> resultList = tq.setFirstResult(1).setMaxResults(1).getResultList();
		for(Student student : resultList) {
		System.out.println(student);		
		}
		
	}

}
