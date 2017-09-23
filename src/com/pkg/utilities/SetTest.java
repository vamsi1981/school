package com.pkg.utilities;

import java.util.*;
class SetTest {
public static void main(String[] args) {
boolean[] ba = new boolean[5];
// insert code here
//Set s = new HashSet();
Set s= new TreeSet();
ba[0] = s.add("a");
//ba[1] = s.add(new Integer(42));
ba[2] = s.add("b");
ba[3] = s.add("a");
//ba[4] = s.add(new Object());
for(int x=0; x<ba.length; x++)
System.out.print(ba[x] + " ");
System.out.println("\n");
for(Object o : s)
System.out.print(o + " ");
System.out.println("_______________________________________");

TreeMap<String, String> map = new TreeMap<String, String>();

map.put("a", "ant");

map.put("d", "dog");

map.put("h", "horse");


SortedMap<String, String> submap;

submap = map.subMap("a", "h");


System.out.println(map + " " + submap);

System.out.println("--------------------------------------");


HashSet sss=new HashSet();
TreeSet ssa=new TreeSet(sss);


CompEmp cm= new CompEmp();
TreeMap hh = new TreeMap(cm);
hh.put(new Employee(400,"abc"), "abc");
hh.put(new Employee(800,"bcd"), "abc");
hh.put(new Employee(100,"abc"), "abc");
hh.put(new Employee(500,"bcd"), "abc");
hh.put(new Employee(600,"abc"), "abc");
hh.put(new Employee(300,"bcd"), "abc");
//hh.entrySet();
Set s11= hh.keySet();
Employee e1=null;
for(Iterator it=s11.iterator();it.hasNext();)
{
e1= (Employee)it.next();
System.out.println(e1.getEmployeeId());
}
//Collections.sort(list)

}
}