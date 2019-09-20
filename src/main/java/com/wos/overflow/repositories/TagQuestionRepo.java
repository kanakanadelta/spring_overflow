package com.wos.overflow.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wos.overflow.models.TagQuestion;

@Repository
public interface TagQuestionRepo extends CrudRepository<TagQuestion, Long>{
	List<TagQuestion> findAll();
	
	@Query(value="SELECT * FROM tags \n" + 
			"WHERE tags.id IN (\n" + 
			"SELECT tags.id FROM questions\n" + 
			"JOIN tags_questions ON questions.id = tags_questions.question_id\n" + 
			"JOIN tags ON tags_questions.tag_id = tags.id\n" + 
			"WHERE question_id = ?1)", nativeQuery=true)
	List<Object> findQuestionTags(Long questionId);
}
