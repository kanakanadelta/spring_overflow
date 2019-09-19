package com.wos.overflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.repositories.TagRepo;

@Service
public class TagService {
	@Autowired
	private TagRepo tR;
	
	public TagService(TagRepo tR) {
		this.tR = tR;
	}
	
	// // // // //
	// SERVICES
	
	// GET ALL TAGS FOR A SPECIFIC QUESTION//
	/* Service Method*/
	
	
	// CREATE A TAG //
	/* Service Method */
	
	// END SERVICE
}
