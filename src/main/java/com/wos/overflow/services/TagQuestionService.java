package com.wos.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.repositories.TagQuestionRepo;

@Service
public class TagQuestionService {
	@Autowired
	private TagQuestionRepo tqR;
	
	public TagQuestionService(TagQuestionRepo tqR) {
		this.tqR = tqR;
	}
	
	// // // // //
	// SERVICES
	
	// GET ALL TagQuestions relationships FOR A SPECIFIC QUESTION//
	/* Service Method*/
	
	
	// CREATE A TagQuestion Relationship //
	/* Service Method */
	
	// END SERVICE
}
