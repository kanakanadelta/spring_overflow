package com.wos.overflow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wos.overflow.models.Question;
import com.wos.overflow.services.AnswerService;
import com.wos.overflow.services.QuestionService;
import com.wos.overflow.services.TagQuestionService;
import com.wos.overflow.services.TagService;


@Controller
@RequestMapping("/")
public class MainController {
	// DEPENDENCY INJECTION //
	@Autowired
	private AnswerService aS;
	@Autowired
	private QuestionService qS;
	@Autowired 
	private TagService tS;
	@Autowired
	private TagQuestionService tQS;
	
	public MainController(
			AnswerService aS,
			QuestionService qS,
			TagService tS,
			TagQuestionService tQS
			) {
		this.aS = aS;
		this.qS = qS;
		this.tS = tS;
		this.tQS = tQS;
	}
	
	// // // // // // // //
	// RESTFUL ROUTES 
	
	// INDEX - GET all questions //
	@GetMapping("/questions")
	public String index(Model model) {
		List<Question> questions = qS.allQuestions();
		model.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	// NEW - Page to make a new question
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		// serve page to make new question
		return "newQuestion.jsp";
	}
	
	// END CONTROLLER
}
