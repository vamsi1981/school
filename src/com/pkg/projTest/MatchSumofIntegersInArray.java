package com.pkg.projTest;

import java.util.ArrayList;
import java.util.List;

class ElementList
{
int elem1;
int elem2;
}
public class MatchSumofIntegersInArray {

	public static void main(String[] args) {
		
		int []arr= new int[]{4,5,3,7,2,6};
		int [][]cat = new int[5][];
		int catIndex=0;
		int catIncIndex=0;
		int sumElement=9;
		List<ElementList> ls = new ArrayList<ElementList>();
		ElementList lm=null;
		for(int i=0;i<arr.length;i++)
		{
			
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==sumElement)
				{
					System.out.println(arr[i]+"  "+arr[j]);
					lm= new ElementList();
					lm.elem1=arr[i];
					lm.elem2=arr[j];
					ls.add(lm);
				}
				
			}
		}
	System.out.println("------------------------------------------------------");
		for(ElementList unk: ls)
		{
			System.out.println(unk.elem1+"  "+unk.elem2);
		}
		
		
	//limitlesspairsComparision(new int[]{1,3,4,5,7,9,12,15,16},28);
	
	}
	
	/*public static void limitlesspairsComparision(int []arr,int comparesum)
	{
		int []mytemp1=arr;
		int []templist=new int[8];
		int tempcomp=comparesum;
		
		for(int i=0;i<mytemp1.length;i++)
		{
			int tempscore=mytemp1[i];
			for(int j=0;j<arr.length&& tempscore<=28 && j!=i;j++)
			{
					tempscore+= mytemp1[j];
				
			}
		}
	}*/
	
}
