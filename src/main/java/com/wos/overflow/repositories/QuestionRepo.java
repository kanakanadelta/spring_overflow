package com.wos.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wos.overflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {
	List<Question> findAll();
}
