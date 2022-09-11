package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.TheaterBean;

@Repository
public interface TheaterRepository extends CrudRepository<TheaterBean, Integer> {
	
}
