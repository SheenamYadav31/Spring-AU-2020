package question6_DateTime;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DOB_question {
		public Date myDate;
		public Date yourDate;
		
		public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) throws InterruptedException {
		    long diffInMillies = date2.getTime() - date1.getTime();
		    return timeUnit.convert(diffInMillies,TimeUnit.NANOSECONDS);
		}
		
		public static void main(String[] args) throws ParseException, InterruptedException {

			Scanner in = new Scanner(System.in);
			String d1, d2;
			
			DOB_question obj = new DOB_question();
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			
//			d1 = "06/25/1996 07:29:48";
//			d2 = "05/15/1998 10:31:48";
			System.out.println("Enter  your birthdate in MM/dd/yyyy HH:mm:ss format: ");
			d1 = in.nextLine();
			
			System.out.println("Enter your parents/siblings birthdate in MM/dd/yyyy HH:mm:ss format: ");
			d2 = in.nextLine();
			
			obj.myDate = format.parse(d1);
			obj.yourDate = format.parse(d2);
			System.out.println(d1);
			
			System.out.println("The difference in the given dates in NANOSECONDS is: ");
		
			System.out.println(getDateDiff(obj.myDate, obj.yourDate, TimeUnit.NANOSECONDS));
			
		}

	}
