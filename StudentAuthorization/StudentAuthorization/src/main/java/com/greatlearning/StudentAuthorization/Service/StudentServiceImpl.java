package com.greatlearning.StudentAuthorization.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentAuthorization.Model.Student;
import com.greatlearning.StudentAuthorization.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
	}

	@Override
	public List<Student> searchBy(String firstName, String country) {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findByFirstNameContainsAndCountryContainsAllIgnoreCase(firstName,
				country);
		return students;
	}

	@Override
	public void save1(Student theStudent) {
		// TODO Auto-generated method stub

	}

}
