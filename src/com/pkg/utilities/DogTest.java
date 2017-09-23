package com.pkg.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;

interface pet
{
void beFrindly() throws IOException;	
}
class Animal2  {
	
	public void eat(){
		System.out.println("animal eating");
	}
}
class Dog22 extends Animal2 implements pet { 
	
	public void eat(){
		System.out.println("dog eating");
	}
	
	public void beFrindly() throws FileNotFoundException
	{
		System.out.println("be friendly");
	}
}
class beagle extends Dog22 implements pet
{
	//not needed to write but overrideen method if implemented
	public void beFrindly() throws ClassCastException //ok as its runtime exception
	{
		System.out.println("be friendly beagle");
	} 
	
}
class DogTest {
public static void main(String [] args) {
Dog22 d = new Dog22();
Animal2 a1 = d; // upcast ok with no explicit cast
Animal2 a2 = (Animal2) d; // upcast ok with an explicit cast

Animal2 aa=new Animal2();
//Dog22 dd= (Dog22)aa; //illegal downcast class cast exception

Dog22 d1= new Dog22();

Animal2 a3=d1; //upcasting automatic
a3.eat();

Dog22 d3=(Dog22)a3;  //downcasting explicitly declared
d3.eat();

beagle b44=(beagle) d1;
//results in class cast exception as downcasting leads to it.
//b44.beFrindly(); 

}
}
