package com.greatlearning.StudentAuthorization.Service;

import java.util.List;

import com.greatlearning.StudentAuthorization.Model.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(int theId);

	public void save1(Student theStudent);

	public void deleteById(int theId);

	void save(Student theStudent);

	public List<Student> searchBy(String firstName, String country);

}
