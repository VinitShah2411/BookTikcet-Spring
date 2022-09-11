package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.SeatBean;

public interface SeatRepository extends CrudRepository<SeatBean, Integer> {
	SeatBean findBySeatName(String seatName);
	List<SeatBean> findAll();
}
