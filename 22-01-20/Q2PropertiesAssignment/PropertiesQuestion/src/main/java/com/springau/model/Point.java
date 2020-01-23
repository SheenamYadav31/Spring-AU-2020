package com.springau.model;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:values.properties")
public class Point {
	
	private int x;
	private int y;
	private String name;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
		this.name="IAmAPoint";
	}
	
	public Point(String name, int x) {
		this.setName(name);
		this.x=x;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "POINT:  Name: "+this.name+" x: "+this.x+" y:"+ this.y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

