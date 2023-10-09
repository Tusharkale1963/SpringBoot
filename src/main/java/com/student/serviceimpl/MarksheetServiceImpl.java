package com.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.MarkSheet;
import com.student.entity.StudentEntity;
import com.student.repo.MarkSheetRepo;
import com.student.repo.StudentRepo;

import GlobleException.IdNotFoundException;

@Service
public class MarksheetServiceImpl {

	@Autowired
	private MarkSheetRepo markrepo;
	
	@Autowired
	private StudentRepo studententrepo;
	
	//getbyId
	public MarkSheet getMark(Integer id) {
		return markrepo.findById(id).orElseThrow(()-> new IdNotFoundException("markSheet id not found"));
	}
	
	//getAll
	public List<MarkSheet> getAll() {
		return markrepo.findAll();
	}
	
	// save
	public MarkSheet saveMarks(MarkSheet mark) {
	return	markrepo.save(mark);
	}
	
	// Delete
	public String deleteMarks(Integer id) {
		if(markrepo.existsById(id)) {
		 markrepo.deleteById(id);
		 return "delete successfull : "+id;
		 }
		else
		return "id is not found ";
	}
	
	public MarkSheet updateMarks(Integer id,MarkSheet newMarks) {
		MarkSheet marksheet = markrepo.findById(id)
		.orElseThrow(()->new IdNotFoundException("id not found : '"+id+"'"));
		marksheet.setEnglish(newMarks.getEnglish());
		marksheet.setGeography(newMarks.getGeography());
		marksheet.setHindi(newMarks.getHindi());
		marksheet.setHistory(newMarks.getHistory());
		marksheet.setMarathi(newMarks.getMarathi());
		marksheet.setMath(newMarks.getMath());
		
		return  markrepo.save(marksheet);
		
}
	}