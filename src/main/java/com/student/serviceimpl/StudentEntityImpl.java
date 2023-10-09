package com.student.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.StudentEntity;
import com.student.repo.StudentRepo;
import GlobleException.IdNotFoundException;

@Service
public class StudentEntityImpl {

	@Autowired
	private StudentRepo studentRepo;
	public StudentEntity getStudent(Integer id) {
		
		StudentEntity findById = studentRepo.findById(id)
				.orElseThrow(()-> new IdNotFoundException("Id is not present"));
		return findById;
	}

	
	public StudentEntity saveStudent(StudentEntity student) {
		StudentEntity save = studentRepo.save(student);
		return save;
	}

	
	public String deleteStuden(Integer id) {
	
		studentRepo.deleteById(id);
		return "id delete successfull : "+id;
	}

	
	public StudentEntity updateStudent(StudentEntity student, Integer id) {
		
		StudentEntity updateStuent = studentRepo.findById(id).orElseThrow
				(()-> new IdNotFoundException("Id not found"));
		
		updateStuent.setAddress(student.getAddress());
		updateStuent.setMobileNum(student.getMobileNum());
		updateStuent.setName(student.getName());
		updateStuent.setSchoolName(student.getSchoolName());
		updateStuent.setStd(student.getStd());
		updateStuent.setMarksheet(student.getMarksheet());
		
		return updateStuent;
	}

	
	public List<StudentEntity> getAllStudent() {
		List<StudentEntity> findAll = studentRepo.findAll();
		return findAll;
	}

}
