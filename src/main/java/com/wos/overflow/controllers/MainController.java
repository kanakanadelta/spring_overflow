package com.wos.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wos.overflow.models.Question;
import com.wos.overflow.models.Tag;
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
	
	// NEW - Page to make a new question
	@GetMapping("/questions/new")
	public String newQuestion(
			@ModelAttribute("question") Question question,
			@ModelAttribute("tags") List<Tag> tags
			) {
		// serve page to make new question
		return "newQuestion.jsp";
	}
	
	// // // // // // // // // // // // // //
	// CREATE - new question to add to db //
	@PostMapping("/questions")
	public String createQuestion(
			@Valid 
			@ModelAttribute("question")Question question, 
			@ModelAttribute("tagString") String tagStr,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		} else {
			// Create new question
			qS.createOrUpdateQuestion(question);
			
			//////////////////////
			// Seperate the tags
			ArrayList<String> tagList = new ArrayList<String>();

		    String tempStr = "";
		    for(int i = 0; i < tagStr.length(); i++) {
		      char currChar = tagStr.charAt(i);
		      if(currChar != ',') {
		        // as long as the current char of tags isn't a comma, keep building str
		        tempStr+=currChar;
		      } else if (currChar == ','){
		        // if it found a comma, commence: split
		        int spaces = 0;
		        for(int k = tempStr.length() - 1; k > 0; k--) {
		          if(tempStr.charAt(k) != ' ') {
		            break; 
		          } else {
		            // increment number of spaces to take off at the end of the str
		            spaces++;
		          }
		        }
		        //if spaces were found, make a substring of the string with no spaces
		        if(spaces > 0) {
		          tempStr = tempStr.substring(0, tempStr.length()-spaces);
		        }
		        // add the str to the list
		        tagList.add(tempStr);

		        // check for spaces after the comma
		        if(tagStr.charAt(i+1) == ' ') {
		          for(int j = i+1; i < tagStr.length(); j++){
		            //increment i to skip the spaces until the next valid char
		            if(tagStr.charAt(j) == ' ') {
		              i++;
		            } else {
		              break;
		            }
		          }
		        }
		        
		        // start over temp str
		        tempStr = "";
		      }

		      // if last elem of tags, add str to list; 
		      if (i == tagStr.length()-1) {
		        tagList.add(tempStr.trim());
		      }
		    }
		    
		    // print test:
		    for(int i = 0; i < tagList.size() ; i++) {
		        System.out.println(tagList.get(i) + " - size: " + tagList.get(i).length());
		      }
			
			 // END TAG OPERATION //
		    ///////////////////////
			
			return "redirect:/questions";
		}
	}
	
	
	// END CONTROLLER
}
