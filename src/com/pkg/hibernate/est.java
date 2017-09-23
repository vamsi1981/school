package com.pkg.hibernate;

abstract  class abc {
void get()
{

int i=1;
System.out.println(i);
}

}
class est extends abc
{
	void get()
	{
		System.out.println("sdfsdfsd");
	}
public 	static void main(String[] args) {
	est e = new est();
	e.get();
}
}
