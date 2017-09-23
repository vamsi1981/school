package com.pkg.utilities;

class Frog {
int frogCount = 0; // Declare and initialize
// instance variable
public Frog() {
frogCount += 1; // Modify the value in the constructor

}
void mine()
{ex();}
static void ex(){
	//mine(); //can't access instance method in static block or method
}
public static void main (String [] args) {
new Frog();
new Frog();
new Frog();
//System.out.println("Frog count is now " +frogCount); //compiler error
}
}
