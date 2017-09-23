package com.pkg.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestEmployee {
public static void main(String[] args) {
	  Employee emp1 = new Employee(123,"Amit");  
      Employee emp2 = new Employee(1234,"Ashish");  
      Employee emp4 = new Employee(126,"Krishna");
      
      Employee emp8 = new Employee(126,"Krishna");
      Employee emp9 = new Employee(126,"Krishna");
      Employee emp10 = new Employee(126,"Krishna");
      
      HashMap hm = new HashMap();  
      hm.put(emp1, "11");  
      hm.put(emp2, "123");
      hm.put(emp4, "126");
     
      //hm.put(emp8, "126");
      hm.put(emp8, "126");  
      hm.put(emp9, "126");
      hm.put(emp10, "126");
      
      Employee emp3 = new Employee(123,"Amit");  
      System.out.println(emp3.equals(emp1));  
      String name = (String) hm.get(emp3);  
      System.out.println(name);
      
      
      
      System.out.println("sdddfsdf");
      Employee emp5 = new Employee(126,"Krishna");  
      System.out.println(emp5.equals(emp4));  
      String name1 = (String) hm.get(emp5);  
      System.out.println(name1);
      System.out.println("sddd         fsdf");
     Set s=hm.keySet();
     Employee e1;
     
     for(Iterator<Employee> it=s.iterator();it.hasNext();)
     {
    	 e1 = it.next();
    	 
    	 System.out.println(e1.getEmployeeId()+ " "+e1.getName());
     }
     
     
     System.out.println("");
     System.out.println("Set List");
     Set<Employee> s1= new HashSet<Employee>();
     s1.add(emp1);
     s1.add(emp2);
     s1.add(emp4);
     s1.add(emp8);
     s1.add(emp9);
     s1.add(emp10);
     Employee e2;
     for(Iterator<Employee> it1=s1.iterator();it1.hasNext();)
     {
    	 e2 = it1.next();
    	 System.out.println(e2.getEmployeeId()+ " "+e2.getName());
     }
     
     LinkedList ss =new LinkedList();
     for(Iterator it=ss.iterator();it.hasNext();)
     {
    	 it.next();
     }
     Integer.parseInt("4");
     System.out.println("Hashset");
     Set s4 = new HashSet();
     s4.add(null);
     s4.add(null);
     s4.add("abc");
     s4.add("efd");
     System.out.println(s4.size());
     
     if(emp8==emp9){System.out.println("emp8==emp9 which true");}
     if(emp8.equals(emp9)){System.out.println("emp8 equals emp9 which true");}
     
     List s5 = new ArrayList();
     s5.add("a");
     s5.add("b");
     s5.add("c");
     s5.add("d");
     //s5.set(index, element)
     
     for(Iterator it=s5.iterator();it.hasNext();)
     {
    	 it.remove();
     }
}
}
