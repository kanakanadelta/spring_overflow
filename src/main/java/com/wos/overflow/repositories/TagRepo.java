package com.wos.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wos.overflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	List<Tag> findAll();
}
