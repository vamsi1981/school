package com.pkg.utilities;

import java.util.*;
public class TestBadLegacy {
public static void main(String[] args) {
List<Integer> myList = new ArrayList<Integer>();
myList.add(4);
myList.add(6);
Inserter in = new Inserter();
in.insert(myList); // pass List<Integer> to legacy code

for(Integer i:myList)
{
System.out.println(i.intValue());	
}
}
}
class Inserter {
// method with a non-generic List argument
void insert(List list) {
list.add(new String("42")); // adds to the incoming list
}
}