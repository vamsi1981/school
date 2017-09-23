package com.pkg.utilities;
class con2
{
	//con2(int i,int j){} in case of constructor with arguments
}
class con1 extends con2
{
	private con1()
	{
		//this(5,4);
	}
	con1(int i,int j){
		//this();
	}
	void doit(){
		//this(); //cannot call it.
	//con1(); error
		new con1();
	}
	}

public class ConstructorStart {
public static void main(String[] args) {
	//con1 c = new con1(); // compiler error as no arg cons is needed
	con1 c= new con1(4,6);
}
	
}

