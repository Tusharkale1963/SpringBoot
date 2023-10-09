package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.entity.StudentEntity;
import com.student.serviceimpl.StudentEntityImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentEntityImpl st;

	@GetMapping("get/{id}")
	public ResponseEntity<StudentEntity> getStudent(@PathVariable Integer id, Model model) {
		StudentEntity student = st.getStudent(id);
		return new ResponseEntity<StudentEntity>(student, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public List<StudentEntity> getAllStudent() {
		return st.getAllStudent();
	}

	@PostMapping("/save")
	public StudentEntity saveStudent(@RequestBody StudentEntity stude) {
		return st.saveStudent(stude);
	}

	@PutMapping("/update/{id}")
	public StudentEntity updateStudent(@PathVariable Integer id, @RequestBody StudentEntity std) {
		return st.updateStudent(std, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return st.deleteStuden(id);
	}
}
