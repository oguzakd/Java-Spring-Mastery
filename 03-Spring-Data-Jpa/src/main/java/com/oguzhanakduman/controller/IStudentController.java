package com.oguzhanakduman.controller;

import java.util.List;

import com.oguzhanakduman.dto.DtoStudent;
import com.oguzhanakduman.dto.DtoStudentIU;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Integer id);
	
	public void deleteStudent(Integer id);
	
	public DtoStudent updateStudent(Integer id, DtoStudentIU student);
}
