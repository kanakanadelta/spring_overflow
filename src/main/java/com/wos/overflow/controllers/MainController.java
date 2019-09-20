package com.wos.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wos.overflow.models.Answer;
import com.wos.overflow.models.Question;
import com.wos.overflow.models.Tag;
import com.wos.overflow.models.TagQuestion;
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
	//  RESTFUL ROUTES  //
	// // // //  // // // 
	
	// // // // // // // // // // //
	// INDEX - GET all questions //
	@GetMapping("/questions")
	public String index(Model model) {
		List<Question> questions = qS.allQuestions();
		model.addAttribute("questions", questions);
		
		return "index.jsp";
	}
	
	// // // // // // // // // // //
	// NEW - Page to make a new question
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question")Question question) {
		// serve page to make new question
		return "newQuestion.jsp";
	}
	
	// // // // // // // // // // //
	// SHOW - page of the question
	@GetMapping("/questions/{id}")
	public String show(@PathVariable(value="id")Long id, Model model) {
		Question question = qS.geQuestion(id);
		model.addAttribute("qObj", question);
		return "showQuestion.jsp";
	}
	
	// // // // // // // // // // // // // //
	// CREATE - new question to add to db //
	@PostMapping("/questions")
	public String createQuestion(
			@ModelAttribute("question")Question question,
			@RequestParam("tagStr")String tagStr,
			BindingResult result
			) {
		
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			// Create new question
			qS.createOrUpdateQuestion(question);
			
			
			//////////////////////
			// Seperate the tags
			
			ArrayList<String> tagList = tS.tagSplit(tagStr);
			
		    // Tag and Relationship creation:
		    for(int i = 0; i < tagList.size() ; i++) {
		        System.out.println(tagList.get(i) + " - size: " + tagList.get(i).length());
		        
		        // make new tag for each tagStr in list
		        Tag newTag = new Tag();
		        newTag.setSubject(tagList.get(i));
		        tS.createTag(newTag);
		        
		        // make new relationship for each tag to the question
		        TagQuestion relationship = new TagQuestion();
		        relationship.setTag(newTag);
		        relationship.setQuestion(question);
		        tQS.createTQ(relationship);
		        
		        
		     }
		    System.out.println(question.getQuestionText());
			
			 // END TAG OPERATION //
		    ///////////////////////
			
			return "redirect:/questions";
		}
		// end create question
	}
	
	// // // // // // // // // // // // // //
	// CREATE - new answer for a question //
	@PostMapping("/questions/{id}/answer")
	public String createAnswer(
			@PathVariable(value="id")Long id, 
			@ModelAttribute("answer")Answer answer, 
			BindingResult result
			) {
		
		return "redirect:/questions/{id}";
	}
	
	// END CONTROLLER
}
