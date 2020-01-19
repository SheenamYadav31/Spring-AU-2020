package question6_DateTime;

import java.util.*;
import java.time.*;
import java.text.*;

import java.time.temporal.*;
import java.time.temporal.ChronoUnit;
import java.time.chrono.ChronoZonedDateTime;
 
public class timezoneQue {
	
	public static void main(String[] args) {

		//Scanner in = new Scanner(System.in);

//		System.out.println("Enter  your birthdate in YYYY/MM/DD HH:mm:ss [Z] format: ");
//		s1 = in.nextLine();
//		
//		System.out.println("Enter your parents/siblings birthdate in YYYY/MM/DD HH:mm:ss [Z] format: ");
//		s2 = in.nextLine();
		
		ZonedDateTime date1 = ZonedDateTime.parse("2019-11-03T10:15:30+05:30[Europe/London]");
		ZonedDateTime date2 = ZonedDateTime.parse("2019-12-03T10:15:30+05:30[Asia/Calcutta]");
		
		ZoneId id = date1.getZone();
		
		ZonedDateTime z1 = date1.toInstant().atZone(id);
	    ZonedDateTime z2 = date2.toInstant().atZone(id);
		
	    System.out.println(ChronoUnit.DAYS.between(z1, z2));
	    
	}

}
