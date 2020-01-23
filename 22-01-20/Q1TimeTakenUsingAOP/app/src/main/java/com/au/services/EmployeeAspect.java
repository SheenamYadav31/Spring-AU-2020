package com.au.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.*;
import java.util.*;


@Aspect
public class EmployeeAspect {
	
	private long startTime;
	private long endTime;
	//this is an advice
	@Before("execution(* com.au.services.EmployeeManager.getAllEmployee(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		startTime = System.currentTimeMillis();
		System.out.println("Start time is: "+startTime);
		System.out.println("EmployeeAspect.logBefore() : "+joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.au.services.EmployeeManager.getAllEmployee(..))")
	public void logAfterV1(JoinPoint joinPoint) {
		endTime = System.currentTimeMillis();
		System.out.println("End time is: "+endTime);
		System.out.println("EmployeeAspect.logBefore() : "+joinPoint.getSignature().getName());
		System.out.println("Total time taken =  "+ (endTime-startTime)+" milliseconds");
	}
}
