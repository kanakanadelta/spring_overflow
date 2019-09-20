package com.wos.overflow.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wos.overflow.models.Tag;
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
	public Tag createTag(Tag tag) {
		return tR.save(tag);
	}
	
	// TAG STRING SPLIT METHOD //
	public ArrayList<String> tagSplit(String tagStr) {

		ArrayList<String> tagList = new ArrayList<String>();

	    String tempStr = "";
	    for(int i = 0; i < tagStr.length(); i++) {
	      if(tagList.size() == 3) {
	    	  break;
	      }
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
	    
	    return tagList;
	}
	
	// END SERVICE
}
