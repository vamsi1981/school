package com.pkg.projTest;

public class BritishEnglishNumber {
public static void main(String[] args) {
	
	int k=999999999;
	
	//int k=999999999;
	//int k=918214516;
	//String getL= new String(k);
	String st=""+k+"";
	StringBuilder sb= new StringBuilder(st);
	sb.reverse();
	String []stp= sb.toString().split("");
	int pos=0;
	String totalString=" ";
	for(int i=stp.length-1;i>=0;i--)
	{	
		String [] initDesc=new String[4];
		pos=i;
		
		if(pos==9)
		{
			initDesc[0]="hundred ";
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" "+initDesc[0]+" and ";
		}
		
		if(pos==8)
		{
			initDesc[0]=" million ";
			if(Integer.parseInt(stp[i])==1)
			{
				totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,Integer.parseInt(stp[i]+stp[i-1]))+" ";
				i=i-1;
				totalString=totalString+ " million ";
			}
			else{
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
			}
			//totalString=totalString+ " million"; 
			
		}
		
		if(pos==7)
		{
			initDesc[0]="million ";
			
			totalString=totalString+ appendEnglish(Integer.parseInt(stp[i]), pos,0)+" "+initDesc[0]+ " and "; 
			
		}
		if(pos==6)
		{
			initDesc[0]="hundred ";
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" "+initDesc[0]+" and ";
		}
		if(pos==5)
		{
			initDesc[0]="thousand ";
			if(Integer.parseInt(stp[i])==1)
			{
				totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,Integer.parseInt(stp[i]+stp[i-1]))+" ";
				i=i-1;
			}
			else{
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
			}
			totalString=totalString + initDesc[0] +" and "; 
		}
		if(pos==4)
		{
	//		initDesc[0]=
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
			
			if(stp.length>=6)
			{
				totalString=totalString + "thousand" + " and ";
			}
		}
		
		
		if(pos==3)
		{
	//		initDesc[0]=
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
			
			
				totalString=totalString + "hundred"+ " and ";
			
		}
		
		if(pos==2)
		{
	//		initDesc[0]=
			if(Integer.parseInt(stp[i])==1)
			{
				
				totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,Integer.parseInt(stp[i]+stp[i-1]))+" ";
				i=i-1;
			}
			else{	
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
		}
			
		}
		
		if(pos==1)
		{
	//		initDesc[0]=
			totalString=totalString + appendEnglish(Integer.parseInt(stp[i]), pos,0)+" ";
			
			
		}
		
		
		System.out.println(totalString);
	}
}

static String appendEnglish(int i,int position,int teen)
{
	String []units= {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven"
			,"twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String []tens={"zero","not","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
	String []hundreds = {"zero","one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
	String []thousands= {"thousand"};
	String []million={"million"};
	String Stret="";
	if((position==1 || position==3|| position==4 || position==7 || position==6 || position==9 ) && teen==0)
	{
		if(i==0)
		{
			Stret="";
		}
		if(i==1)
		{
		Stret=units[1];
	}
		if(i==2)
		{
		Stret=units[2];
		}
		if(i==3)
			{
		Stret=units[3];
			}
		if(i==4)
		{
	Stret=units[4];
		}
		if(i==5)
		{
		Stret=units[5];
		}
		if(i==6)
		{
		Stret=units[6];
			}
		if(i==7)
		{
		Stret=units[7];
		}
		if(i==8)
		{
		Stret=units[8];
		}
		if(i==9)
		{
		Stret=units[9];
		}
		
	}	
	if((position==2 || position==5 || position==8 ) && teen==0)
	{
		if(i==0)
		{
			Stret="";
		}
		//handle
		if(i==1)
		{
		Stret=tens[1];
	}
		if(i==2)
		{
		Stret=tens[2];
		}
		if(i==3)
			{
		Stret=tens[3];
			}
		if(i==4)
		{
		Stret=tens[4];
		}
		
		if(i==5)
		{
		Stret=tens[5];
		}
		
		if(i==6)
		{
		Stret=tens[6];
			}
		if(i==7)
		{
		Stret=tens[7];
		}
		if(i==8)
		{
		Stret=tens[8];
		}
		if(i==9)
		{
		Stret=tens[9];
		}
		
	}
	
	if((position==2 || position==5 || position==8 ) && teen!=0)
	{
		if(teen==11)
		{
			Stret= units[11];
		}
		if(teen==12)
		{
			Stret= units[12];
		}
		if(teen==13)
		{
			Stret= units[13];
		}
		if(teen==14)
		{
			Stret= units[14];
		}
		if(teen==15)
		{
			Stret= units[15];
		}
		if(teen==16)
		{
			Stret= units[16];
		}
		if(teen==17)
		{
			Stret= units[17];
		}
		if(teen==18)
		{
			Stret= units[18];
		}
		if(teen==19)
		{
			Stret= units[19];
		}
		
	}
	
	
	
	
return Stret;	
}





}
