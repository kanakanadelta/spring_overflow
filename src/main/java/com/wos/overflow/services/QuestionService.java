package com.wos.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.models.Question;
import com.wos.overflow.repositories.QuestionRepo;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepo qR;
	
	public QuestionService(QuestionRepo qR) {
		this.qR = qR;
	}
	
	// // // // //
	// SERVICES
	
	// GET ALL QUESTIONS //
	public List<Question> allQuestions() {
		return qR.findAll();
	}
	
	// GET A SPECIFIC QUESTION //
	/* service method */
	
	
	// CREATE NEW QUESTION //
	/* service method */
	
	
	// END SERVICES
}
