package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.RouteBean;

public interface RouteRepo extends JpaRepository<RouteBean , Integer>{
		
//@Query("Select r from RouteBean where source=?1 and destination=?2")
Optional<RouteBean> findBySourceAndDestination(String source,String destination);
	Optional<RouteBean> findBySource(String source);
	
}

// 13th video