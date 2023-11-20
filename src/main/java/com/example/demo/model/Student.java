package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student1")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String first_name;
	private String last_name;
	private int age;
	private String email;
	private String password;
	private String location;
	private String dept;
	private String city;
	private String state;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public Student(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	

	public Student(int age) {
		super();
		this.age = age;
	}


	public Student(int id, String first_name, String last_name,int age, String email, String password, String location,
			String dept, String city, String state) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.location = location;
		this.dept = dept;
		this.city = city;
		this.state = state;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", email=" + email + ", password=" + password + ", location=" + location + ", dept=" + dept
				+ ", city=" + city + ", state=" + state + "]";
	}
	
	
}
