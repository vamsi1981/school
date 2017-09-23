package com.pkg.utilities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilityCollection {
 public static	String constructDate(Date dcons)
	{  
	 String consDate=null;
		if(dcons!=null){
	    String consMonth;
		String consYear;
		if(dcons!=null){
		consDate =dcons.getDate()+"-"+(dcons.getMonth()+1)+"-"+(dcons.getYear()+1900);
		}
		}
		return consDate;
	}
public static	Date constructStringToDate(String dcons)

	{
	Date senDate=null;
	if(dcons!=null && !dcons.equals("")){
		String[] consDate=dcons.split("-");
		String consMonth;
		String consYear;
		 senDate =new Date(Integer.parseInt(consDate[2])-1900,Integer.parseInt(consDate[1])-1,Integer.parseInt(consDate[0]));
	}
		return senDate;
	}

public static Date getStrng2Date(String adate)
{  
	Date ddd =null;
	try
	{
		String[] split1=adate.split("/");
		int month=Integer.valueOf(split1[0]);
		int day=Integer.valueOf(split1[1]);
		int year=Integer.valueOf(split1[2]);
		Calendar cal=new GregorianCalendar();
		cal.set(year, month, day);
		 ddd = cal.getTime();
		
	}
	catch(Exception e)
	{
		System.out.println("Error in getStrng2Date(String adate)"+e);
	}
	return ddd;
}

public static Date getIndianStrng2Date(String adate)
{  
	Date ddd =null;
	try
	{
		String[] split1=adate.split("/");
		int day=Integer.valueOf(split1[0]);
		int month=Integer.valueOf(split1[1]);
		int year=Integer.valueOf(split1[2]);
		Calendar cal=new GregorianCalendar();
		cal.set(year, month, day);
		 ddd = cal.getTime();
		
	}
	catch(Exception e)
	{
		System.out.println("Error in getStrng2Date(String adate)"+e);
	}
	return ddd;
}


public static Date getCurrentDate()
{  
	Date ddd =null;
	try
	{
		
		Calendar cal=GregorianCalendar.getInstance();
		
		 ddd = cal.getTime();
		
	}
	catch(Exception e)
	{
		System.out.println("Error in getStrng2Date(String adate)"+e);
	}
	return ddd;
}
public static int[] dateConv(String date)
{
	//2013-11-25 13:12:42.0
	String []st=date.split(" ");
	String stdate[] =st[0].split("-");
	String sttime[]= st[1].split(":");
	int year = Integer.parseInt(stdate[0])-1900;
	int month = Integer.parseInt(stdate[1])-1;
	int day = Integer.parseInt(stdate[2]);
	
	int hour=Integer.parseInt(sttime[0]);
	int minute=Integer.parseInt(sttime[1]);
	String secsplit[]=sttime[2].split("\\.");
	int sec=Integer.parseInt(secsplit[0]);
	int micro=Integer.parseInt(secsplit[1]);
	//int[]constructdate=new int[year,month,day,hour,minute,sec,micro];
	int[]constructdate=new int[7];
	constructdate[0]=year;
	constructdate[1]=month;
	constructdate[2]=day;
	constructdate[3]=hour;
	constructdate[4]=minute;
	constructdate[5]=sec;
	constructdate[6]=micro;
	
return constructdate;	
}

}
