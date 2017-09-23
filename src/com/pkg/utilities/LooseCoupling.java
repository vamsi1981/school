package com.pkg.utilities;

import java.util.Date;

class DoTaxes {
float rate;
float doColorado() {
SalesTaxRates str = new SalesTaxRates();
rate = str.salesRate; // ouch
// this should be a method call:
// rate = str.getSalesRate("CO");
// do stuff with rate
str.getSalesRate("");
return 2.0f;
}
}
class SalesTaxRates {
	char c;
	byte b=(byte)129;
public float salesRate=1.4333332222f; // should be private
public float adjustedSalesRate; // should be private
public float getSalesRate(String region) {
salesRate = new DoTaxes().doColorado(); // ouch again!
// do region-based calculations
return adjustedSalesRate;
}
}

public class LooseCoupling {
public static void main(String[] args) {
	SalesTaxRates sss= new SalesTaxRates();
	//sss.getSalesRate(""); //results in stackoverflow
	System.out.println(sss.c + "" + sss.salesRate+""+sss.b);
	Date d;
	//System.out.println(d);
	String s =new String("abc");
	String t=s.concat("cdf");
//	t.concat("cdf");
	System.out.println(s+"  "+t);
	int []key;
	int []mint = new int[6];
	
	//wrapper
	Long l= Long.valueOf(5);
	System.out.println(l);
	long l1= l.longValue();
	System.out.println(l1);
	
}
}
