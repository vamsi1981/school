package com.pkg.utilities;

import java.io.IOException;

class A
{
void get() throws Exception
{}
A put()
{
	System.out.println("a executed");
return null;	
}
}
class B extends A
{
	void get() throws RuntimeException
	{}
	
	/*A put()
	{
		System.out.println("b executed");
	return null;	
	}
	B put()
	{
		System.out.println("b executed");
	return null;	
	}*/
	void dumka(){}
	static void jet(){
		B b= new B();
		
		A a;
		a=b;
		
		
	}	
}
class CoffeeTest1
{
public static void main(String[] args) {
	A b= new B();
	b.put();
	System.out.println(Long.valueOf(1).equals(Integer.valueOf(1)));
}	

}