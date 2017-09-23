package com.pkg.utilities;

class emds{}
class Bike{  
	  void run(){System.out.println("running");}  
	}  
	class Splender extends Bike{  
	  void run(){System.out.println("running safely with 60km");}  
	  
	  public static void main(String args[]){  
	    Bike b = new Splender();//upcasting  
	    b.run();  
	    
	    if(b instanceof Bike){System.out.println("xx");}
	    
	    if(b instanceof Splender){
	    	System.out.println("y");
	    }
	    int b1 = 3;
	    for (int a = 1; b1 != 1; System.out.println("iterate")) {
	    b1 = b1 - a;
	    }
	    
	    for(int i=1;i<5;i++)
	    {
	   // try{
	    	if(i==1){
	    	System.out.println(" "+i);
	    	break;
	    	}
	    /*}finally{
	    	
	    	System.out.println("finally");
	    }*/
	    	System.out.println("fina");
	    }
	    int ii=getdd();
	    System.out.println(" "+ii);
	} 
	  
	static int getdd()
	{
		try{
			int i=10;
			System.out.println(i);
		return 1;
		}catch(Exception e){
			return 1;
		}finally{
			System.out.println("sdfsd");
			return 2;
		}
	}
	
	}