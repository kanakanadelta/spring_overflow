package com.wos.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.models.Tag;
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
	
	// GET ALL Tags with relationships FOR A SPECIFIC QUESTION//
	/* Service Method*/
	public List<Object> findTags(Long questionId) {
		return tQR.findQuestionTags(questionId);
	}
	
	// CREATE A TagQuestion Relationship //
	public TagQuestion createTQ(TagQuestion tagQuestion) {
		return tQR.save(tagQuestion);
	}
	
	// END SERVICE
}
