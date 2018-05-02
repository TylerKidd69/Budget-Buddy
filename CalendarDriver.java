package accounts;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
public class CalendarDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar cal1 = Calendar.getInstance();
	      // You cannot use Date class to extract individual Date fields
	      int year = cal1.get(Calendar.YEAR);
	      int month = cal1.get(Calendar.MONTH);      // 0 to 11
	      int day = cal1.get(Calendar.DAY_OF_MONTH);
	      int hour = cal1.get(Calendar.HOUR_OF_DAY);
	      int minute = cal1.get(Calendar.MINUTE);
	      int second = cal1.get(Calendar.SECOND);
	   
	      System.out.printf("Now is %4d/%02d/%02d %02d:%02d:%02d\n",  // Pad with zero
	          year, month+1, day, hour, minute, second);
	      System.out.println("___________________________________________");
	      
	      
	      
	      Calendar cal = Calendar.getInstance();   // GregorianCalendar
	      System.out.println("Calendar's toString() is : " + cal + "\n");
	      System.out.println("Time zone is: " + cal.getTimeZone() + "\n");
	  
	      // An Easier way to print the timestamp by getting a Date instance
	      Date date = cal.getTime();
	      System.out.println("Current date and time in Date's toString() is : " + date + "\n");
	  
	      // Print Calendar's field
	      System.out.println("Year  : " + cal.get(Calendar.YEAR));
	      System.out.println("Month : " + cal.get(Calendar.MONTH));
	      System.out.println("Day of Month : " + cal.get(Calendar.DAY_OF_MONTH));
	      System.out.println("Day of Week  : " + cal.get(Calendar.DAY_OF_WEEK));
	      System.out.println("Day of Year  : " + cal.get(Calendar.DAY_OF_YEAR));
	      System.out.println("Week of Year : " + cal.get(Calendar.WEEK_OF_YEAR));
	      System.out.println("Week of Month : " + cal.get(Calendar.WEEK_OF_MONTH));
	      System.out.println("Day of the Week in Month : " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	      System.out.println("Hour  : " + cal.get(Calendar.HOUR));
	      System.out.println("AM PM : " + cal.get(Calendar.AM_PM));
	      System.out.println("Hour of the Day : " + cal.get(Calendar.HOUR_OF_DAY));
	      System.out.println("Minute : " + cal.get(Calendar.MINUTE));
	      System.out.println("Second : " + cal.get(Calendar.SECOND));
	      System.out.println();
	  
	      // Manipulating Dates
	      Calendar calTemp;
	      calTemp = (Calendar) cal.clone();
	      calTemp.add(Calendar.DAY_OF_YEAR, -365);
	      System.out.println("365 days ago, it was: " + calTemp.getTime());

	      calTemp = (Calendar) cal.clone();
	      calTemp.add(Calendar.HOUR_OF_DAY, 11);
	      System.out.println("After 11 hours, it will be: " + calTemp.getTime());

	      // Roll
	      calTemp = (Calendar) cal.clone();
	      calTemp.roll(Calendar.HOUR_OF_DAY, 11);
	      System.out.println("Roll 11 hours, it will be: " + calTemp.getTime());
	      System.out.println();
	     
	      
	      
	      
	      
	      System.out.println("\n");
	      
	      Calendar targetDate = Calendar.getInstance(); //getInstance grabs the current date and time
	      //calculate days until target date
	      targetDate.add(Calendar.MONTH, 6);
	      Calendar currentDate = Calendar.getInstance();
	      
	      System.out.println(currentDate.compareTo(targetDate));
	      
	      
	      //GOAL:
	      //1) Bills -
	      //	amount of $ needed per week
	      //2) amount of money needed per week to reach savings goal by target date
	      System.out.println("Month: "+currentDate.get(Calendar.MONTH));
	      System.out.println("Target Month: "+targetDate.get(Calendar.MONTH));
	      
	      int currentWeek = currentDate.get(Calendar.WEEK_OF_YEAR);
	      int targetWeek = targetDate.get(Calendar.WEEK_OF_YEAR);
	      System.out.println("Current Week: "+currentWeek);
	      System.out.println("Target Week: "+targetWeek);
	      System.out.println("You have "+(targetWeek - currentWeek)+" weeks to reach your goal.");
	      System.out.println("________________________");
	      
	      
	      //new targetdates
	      
	      targetDate = currentDate.getInstance();
	      
	      //set( year, month, day, hour, minute, sec)
	      targetDate.set(currentDate.get(Calendar.YEAR)+1, 5, 6, 0, 0, 0);
	      System.out.println("Target Date: " +targetDate.getTime());
	      System.out.println("Current Date: "+currentDate.getTime());
	      
	      //temporary calendar object used to calculate number of weeks
	      Calendar temp = currentDate.getInstance();
	      
	      //System.out.println(temp.compareTo(targetDate));
	      
	      //number of days counter
	      int days = 0;
	      
	      //Determines how many weeks until targetDate
	      while(temp.compareTo(targetDate)<0)
	      {
	    	  //Checks to see if there is a full year between dates
	    	  //if yes, adds 365 days (1 year)
	    	  if(temp.get(Calendar.YEAR)<targetDate.get(Calendar.YEAR) &&
	    			  temp.get(Calendar.MONTH) < targetDate.get(Calendar.MONTH))
	    	  {
	    		  days+=365;
	    		  temp.add(Calendar.YEAR,1);
	    	  }
	    	  
	    	  //checks to see if there is a full week between dates
	    	  //adds 7 days (1 week)
	    	  if(temp.get(Calendar.WEEK_OF_YEAR) < targetDate.get(Calendar.WEEK_OF_YEAR))
	    	  {
	    		  days+=7;
	    		  temp.add(Calendar.WEEK_OF_YEAR, 1);
	    	  }
	    	  
	    	  //adds days until temp.day = targetdate.day
	    	  if(temp.get(Calendar.DAY_OF_MONTH) != targetDate.get(Calendar.DAY_OF_MONTH))
	    	  {
	    		  days++;
	    		  temp.add(Calendar.DAY_OF_MONTH, 1);
	    	  }
	      }
	      
	      //calculates how many weeks out of calculated days
	      int weeks = days/7;
	      System.out.println("Weeks till target date: "+weeks);
	      
	}

}
