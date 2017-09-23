package com.pkg.utilities;

class Animal1 {
void makeNoise() {System.out.println("generic noise"); }
}
class Dog1 extends Animal1 {
void makeNoise() {System.out.println("bark"); }
void playDead() { System.out.println("roll over"); }
}
class CastTest2 {
public static void main(String [] args) {
Animal1 [] a = {new Animal1(), new Dog1(), new Animal1() };
for(Animal1 animal : a) {
animal.makeNoise();
if(animal instanceof Dog1) {
//animal.playDead(); // try to do a Dog behavior ? compiler error
animal.makeNoise();
((Dog1)animal).playDead();

}
}
}
}