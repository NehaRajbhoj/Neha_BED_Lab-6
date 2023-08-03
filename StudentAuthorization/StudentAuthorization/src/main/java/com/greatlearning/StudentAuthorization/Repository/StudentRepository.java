package com.greatlearning.StudentAuthorization.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.StudentAuthorization.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstNameContainsAndCountryContainsAllIgnoreCase(String firstName, String country);

}
