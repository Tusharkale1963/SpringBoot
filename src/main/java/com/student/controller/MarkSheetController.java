package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.MarkSheet;
import com.student.serviceimpl.MarksheetServiceImpl;

@RestController
public class MarkSheetController {
	@Autowired
	private MarksheetServiceImpl markService;
	
	
	@GetMapping("/getM/{id}")
	public MarkSheet getMarksheet(@PathVariable Integer id) {
		
	return	markService.getMark(id);
	}
	@DeleteMapping("/deleteM/{id}")
	public String deleteMarksheet(@PathVariable Integer id) {
		
		return	markService.deleteMarks(id);
	}
	
	@GetMapping("/getAllM")
	public List<MarkSheet> getAllAMarkSheet(){
		return markService.getAll();
				
	}
	
	@PostMapping("/saveM")
	public MarkSheet saveMarks(@RequestBody MarkSheet marks) {
		return markService.saveMarks(marks);
	}
	
	@PutMapping("/updateM/{id}")
	public MarkSheet updateMarks(@PathVariable Integer id,@RequestBody MarkSheet mar) {
		return markService.updateMarks(id, mar);
	}
	
}
