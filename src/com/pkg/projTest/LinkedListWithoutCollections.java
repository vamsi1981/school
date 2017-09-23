package com.pkg.projTest;

class MyNode
{
int  nodeValue;
MyNode previousNode;
MyNode nextNode;
 int leftdepthofTree;
int rightdepthofTree;
public MyNode(int i)
{
this.nodeValue=i;
}

public MyNode addNode(int Value)
{   MyNode leftNode;
	MyNode rightNode;
	MyNode currentNode=this;
	MyNode tempNode=this;
	MyNode returnedNode=null;
	MyNode breakNode=null;
	MyNode nextNode=null;
	MyNode rightTemp[]=null;
	
	/*  5
	n.addNode(3);
	n.addNode(6);
	n.addNode(9);
	n.addNode(10);
	n.addNode(15);
	n.addNode(4);
	n.addNode(12);
	n.addNode(16);
	n.addNode(18);
	n.addNode(21);
	n.addNode(14);
	*/
	
	while(true)
	{
		
		if(currentNode.nextNode!=null)
		{
			currentNode =currentNode.nextNode;
			continue;
		}
		
		
		
		if(currentNode.nextNode==null)
		{ 
			tempNode= new MyNode(Value);
			currentNode.nextNode =tempNode;
			//currentNode.previousNode=currentNode;
			nextNode=currentNode.nextNode;
			nextNode.previousNode=currentNode;
			currentNode=tempNode;
			//rightdepthofTree++;
			break;
		}
		
		
		
	}
	
	
	return null;
}
public MyNode[] getNextNodes(MyNode n)
{
MyNode []newN=new MyNode[2];
if(n.nextNode!=null){
	newN[1]=n.nextNode;
}
if(n.previousNode!=null){
	newN[1]=n.previousNode;
}


return newN;
}
public void searchReverseTraversel(MyNode n)
{
	MyNode temp1=null;
	MyNode identifyNode=null;
while(n.nextNode!=null)
{
	n=n.nextNode;
	identifyNode=n;
}
identifyNode =n;
while(identifyNode.previousNode!=null)
{
System.out.println(identifyNode.nodeValue);
identifyNode=identifyNode.previousNode;
	
}

}
public MyNode nextLeftNode(MyNode n)
{
return 	this.previousNode;
}

public MyNode nextRightNode(MyNode n)
{
return 	this.nextNode;
}

}

public class LinkedListWithoutCollections {
public static void main(String[] args) {
	
	MyNode n=new MyNode(5);
	n.addNode(3);
	n.addNode(6);
	n.addNode(9);
	n.addNode(10);
	n.addNode(15);
	n.addNode(4);
	n.addNode(12);
	n.addNode(16);
	n.addNode(18);
	n.addNode(21);
	n.addNode(14);
	
	n.searchReverseTraversel(n);
	//Binary search..
	int i =n.leftdepthofTree;
	int j=n.rightdepthofTree;
	
	System.out.println("depth of left search  "+i);
	System.out.println("depth of left search  "+j);
}
	
	
}
