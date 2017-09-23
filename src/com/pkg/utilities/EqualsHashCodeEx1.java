package com.pkg.utilities;

import java.util.ArrayList;

class Box
{
String boxName;
int boxId;
Box(String boxName,int boxId)
{
this.boxId=boxId;
this.boxName=boxName;
}
public boolean equals(Box b)
{
if(this.boxId==b.boxId){return true;}
else {
	return false;
	}
}


 
public int hashCode() {  
    final int prime = 31;  
    int result = 1;  
    result = prime * result + this.boxId;  
    return result;  
}

        }
public class EqualsHashCodeEx1 {
	
	boolean compareObjects(Box b1, Box b2){
		if(b1.equals(b2)==true){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args) {
		Box b1= new Box("A",100);
		Box b2= new Box("A",100);
		Box b3= new Box("A",200);
		
		Box b4= new Box("A",300);
		ArrayList<Box> ss =new ArrayList<Box>();
		ss.add(b1);
		/*if(!ss.get(b2)){
			ss.add(b2);	
		}*/
		if(!ss.contains(b3)){
			ss.add(b3);	
		}
		if(!ss.contains(b4)){
			ss.add(b4);	
		}
		
		EqualsHashCodeEx1 ex = new EqualsHashCodeEx1();
		
		System.out.println(ss.size());
		if(ex.compareObjects(b1,b3)==true){
			System.out.println("both objects are functionally equal");
			
		}
		else
		{System.out.println("they are different");}
	}

	
}


	
	
	

