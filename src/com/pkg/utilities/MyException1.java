package com.pkg.utilities;

class MyException1 extends Exception {
void someMethod () {
try {
	doStuff();
} catch (MyException1 e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
public static void main(String[] args) {
	new MyException1().someMethod();
}
void doStuff() throws MyException1 {
try {
throw new MyException1();
}
catch(MyException1 me) {
throw me;
}
}
}