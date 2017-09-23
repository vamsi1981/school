package com.pkg.utilities;

 class myAnimal {
public void eat() {
System.out.println("Generic Animal Eating Generically");
}
}
public class myHorse extends myAnimal {
public void eat() {
System.out.println("Horse eating hay ");
}
public void eat(String s) {
System.out.println("Horse eating " + s);
}
public static void main(String[] args) {
	myAnimal ah = new myHorse();
	ah.eat();
}
}