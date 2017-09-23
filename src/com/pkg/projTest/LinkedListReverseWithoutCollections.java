package com.pkg.projTest;

import java.util.LinkedList;

//class comp

public class LinkedListReverseWithoutCollections {
public static void main(String[] args) {
	
	
	LinkedList lnk= new LinkedList();
	lnk.add(5);
	lnk.add(6);
	lnk.add(7);
	lnk.add(8);
	lnk.add(9);
	lnk.add(10);
	
	for(int i=lnk.size()-1;i>=0;i--)
	{
		System.out.println(lnk.get(i));
	}
	
}

}
