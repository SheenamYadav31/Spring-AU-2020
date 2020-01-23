package com.springau.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springau.model.Point;


@Service
public class MyService {
	
	@Autowired
	Point point;

}
