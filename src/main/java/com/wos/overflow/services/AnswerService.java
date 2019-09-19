package com.wos.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.models.Answer;
import com.wos.overflow.repositories.AnswerRepo;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepo aR;
	
	public AnswerService (AnswerRepo aR) {
		this.aR = aR;
	}
	
	// // // // // //
	// SERVICES 
	
	// FIND ALL ANSWERS //
	public List<Answer> allAnswers(){
		return aR.findAll();
	}
	
	// FIND ANSWERS FOR A SPECIFIC QUESTION //
	/* service method */
	
	// CREATE ANSWER //
	/* service method */
	
	
	// END SERVICE
}
