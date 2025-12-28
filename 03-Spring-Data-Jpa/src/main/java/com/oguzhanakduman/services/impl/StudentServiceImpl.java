package com.oguzhanakduman.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguzhanakduman.dto.DtoCourse;
import com.oguzhanakduman.dto.DtoStudent;
import com.oguzhanakduman.dto.DtoStudentIU;
import com.oguzhanakduman.entites.Course;
import com.oguzhanakduman.entites.Student;
import com.oguzhanakduman.repository.StudentRepository;
import com.oguzhanakduman.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}

	@Override
	public List<DtoStudent> getAllStudents() {
		List<DtoStudent> dtoList = new ArrayList<>();
		List<Student> studentList = studentRepository.findAllStudents();
		
		for(Student student : studentList) {
			DtoStudent dtoStudent = new DtoStudent();
			BeanUtils.copyProperties(student, dtoStudent);
			dtoList.add(dtoStudent);
		}
		return dtoList;
	}

	@Override
	public DtoStudent getStudentById(Integer id) {
		DtoStudent dtoStudent = new DtoStudent();
		
		Optional<Student> optional = studentRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		Student dbStudent = optional.get();
		BeanUtils.copyProperties(dbStudent, dtoStudent);
		
		if(!dbStudent.getCourses().isEmpty() && dbStudent.getCourses() != null) {
			for (Course course : dbStudent.getCourses()) {
				DtoCourse dtoCourse = new DtoCourse();
				BeanUtils.copyProperties(course, dtoCourse);
				
				dtoStudent.getCourses().add(dtoCourse);
			}
		}
		
		return dtoStudent;
		
	}

	@Override
	public void deleteStudent(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		
		if(optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
	}

	@Override
	public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
		DtoStudent dtoStudent = new DtoStudent();
		Optional<Student> dbStudentOptional = studentRepository.findStudentById(id);
		
		if(dbStudentOptional.isPresent()) {
			Student dbStudent = dbStudentOptional.get();
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
			
			Student updatedStudent = studentRepository.save(dbStudent);
			BeanUtils.copyProperties(updatedStudent, dtoStudent);
			
			return dtoStudent;
		}
		return null;
	}

}
