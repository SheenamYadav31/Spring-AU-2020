package com.springau.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springau.model.Point;

import src.springau.config.AppConfig;

public class Shape {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Point point = context.getBean(Point.class);
		System.out.println(point);

	}

}
