package com.wos.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.models.TagQuestion;
import com.wos.overflow.repositories.TagQuestionRepo;

@Service
public class TagQuestionService {
	@Autowired
	private TagQuestionRepo tQR;
	
	public TagQuestionService(TagQuestionRepo tQR) {
		this.tQR = tQR;
	}
	
	// // // // //
	// SERVICES
	
	// GET ALL TagQuestions relationships FOR A SPECIFIC QUESTION//
	/* Service Method*/
	
	
	// CREATE A TagQuestion Relationship //
	public TagQuestion createTQ(TagQuestion tagQuestion) {
		return tQR.save(tagQuestion);
	}
	
	// END SERVICE
}
