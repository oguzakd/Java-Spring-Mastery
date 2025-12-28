package com.oguzhanakduman.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oguzhanakduman.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	// Custom Query Methods - JPARepository'in sunduğu methodların dışında sorgular yazmak için kullanılır.
	// HQL: Sınıf ismi ve değişken isimleri kullanılarak sorgular yazılır.
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s WHERE s.id= :studentId")
	Optional<Student> findStudentById(Integer studentId);
}
