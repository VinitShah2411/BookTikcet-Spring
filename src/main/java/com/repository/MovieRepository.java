package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.MovieBean;

@Repository
public interface MovieRepository extends CrudRepository<MovieBean, Integer>  {
	List<MovieBean> findAll();
}
