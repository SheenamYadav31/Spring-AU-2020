package myPackage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		
		for(Failure faliure : result.getFailures()) {
			System.out.println(faliure.toString());
		}
		System.out.println("Result is : " + result.wasSuccessful());
		System.out.println("The Count : "+result.getRunCount());
	}

}