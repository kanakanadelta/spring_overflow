package com.wos.overflow.services;

import java.util.List;
import java.util.Optional;

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
	
	// SHOW A SPECIFIC QUESTION //
	public Question geQuestion(Long id) {
		Optional<Question> optQuestion = qR.findById(id);
		if(optQuestion.isPresent()) {
			return optQuestion.get();
		} else {
			return null;
		}
	}
	
	// CREATE NEW QUESTION //
	public Question createOrUpdateQuestion(Question question) {
		return qR.save(question);
	}
	
	
	// END SERVICES
}
