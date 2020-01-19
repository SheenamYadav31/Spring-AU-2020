package question2_annotaions;

import java.util.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//marker annotaion
@interface MarkerAnnotaion{
	
}

//SingleValueAnnotaion
@interface SingleValueAnnotaion{
	int x();
}

//(FULL)MultiValueAnnotaion


@Target(ElementType.TYPE)           //meta annotation
@Retention(RetentionPolicy.RUNTIME) //meta annotation
@interface MyAnnotation{
	int property1() default 0;
	String property2() default "Default_Value";
}

@MyAnnotation(property1=100, property2="city_city")
class Random1 {
	String name;
	int length;
	public Random1(String name, int length) {
		this.length = length;
		this.name = name;
	}
}

@MyAnnotation
class Random2 {
	String city;
	int distance;
	public Random2(String city, int distance) {
		this.distance = distance;
		this.city = city;
	}
}

public class myAnnotations {
	
	public static void main(String[] args) {
		
		Random1 obj1 = new Random1("Bengaluru",20);
		System.out.println("Values from class Random1 constructor: "+obj1.name+" "+obj1.length);
		
		Random2 obj2 = new Random2("Delhi",500);
		System.out.println("Values from class Random2 constructor: "+obj2.city+" "+obj2.distance);
		
		//to fetch features of annotaion
		//@SuppressWarnings("rawtypes")
		Class c = obj1.getClass();
		Annotation A = c.getAnnotation(MyAnnotation.class);
		MyAnnotation M = (MyAnnotation)A;
		System.out.println("Values from Annotation: "+M.property2()+" "+M.property1());
		
		Class c2 = obj2.getClass();
		Annotation A2 = c2.getAnnotation(MyAnnotation.class);
		MyAnnotation M2 = (MyAnnotation)A2;
		System.out.println("Default Values from Annotation: "+M2.property2()+" "+M2.property1());
		
	}

}
