package com.pkg.utilities;
//import com.pkg.controller.DefModifier;
  class JoeTest {
public static void main(String args[])
{
	toTest tt= new toTest();
	System.out.println(tt.i);

}
}
 class toTest {
int i;
	 synchronized void doit()
	{
		final  int i;
		//getit(i);
	}
	 void getit(int i){}
}