package com.pkg.projTest;

class MyNewNode
{
int  nodeValue;
MyNewNode leftNode;
MyNewNode rightNode;
MyNewNode previousNode;
int currentNodeDepth=0;
 int leftdepthofTree;
int rightdepthofTree;
boolean traversedOrnot=false;

public MyNewNode(int i)
{
this.nodeValue=i;
}
/*public Node addNode(int Value)
{   Node leftNode;
	Node rightNode;
	if(Value<this.nodeValue)
	{
		leftNode= new Node(Value);
		this.leftNode=leftNode;
	}
	else
	{
		rightNode= new Node(Value);
		this.rightNode=rightNode;
	}
	return this;
}*/

public MyNewNode addNode(int Value)
{   MyNewNode leftNode;
	MyNewNode rightNode;
	MyNewNode currentNode=this;
	MyNewNode tempNode=this;
	MyNewNode returnedNode=null;
	MyNewNode breakNode=null;
	MyNewNode rightTemp[]=null;
	
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
		
		if(Value>currentNode.nodeValue && currentNode.rightNode!=null)
		{
			currentNode =currentNode.rightNode;
			continue;
		}
		
		if(Value<currentNode.nodeValue && currentNode.leftNode!=null)
		{	
			currentNode =currentNode.leftNode;
			
			continue;
		}
		
		if(Value>currentNode.nodeValue && currentNode.rightNode==null)
		{ 
			int currentNodeD =currentNode.currentNodeDepth+1;// new line added
			tempNode= new MyNewNode(Value);
			
			//adding previousNode to a node new line
			tempNode.previousNode=currentNode;
			
			tempNode.currentNodeDepth=currentNodeD;
			currentNode.rightNode =tempNode;
			 
			//currentNode.currentNodeDepth=currentNodeD;// new line added
			//new block added
			if(currentNodeD>rightdepthofTree)
			{
				rightdepthofTree=currentNodeD;
			}
			break;
		}
		if(Value<currentNode.nodeValue && currentNode.leftNode==null)
		{ 
			int currentNodeD =currentNode.currentNodeDepth+1;// new line added
			tempNode= new MyNewNode(Value);
						
			//adding previousNode to a node new line
			tempNode.previousNode=currentNode;
						
			tempNode.currentNodeDepth=currentNodeD; //new line
			
			currentNode.leftNode =tempNode;
			//currentNode.currentNodeDepth=currentNodeD;// new line added
			//new block added
			if(currentNodeD>leftdepthofTree)
			{
				leftdepthofTree=currentNodeD;
			}
			
			break;
		}
		
		
	}
	
	
	return null;
}

public void postOrderTraversal(MyNewNode n)
{
	
/*while(true)
{
	
boolean endOfLeftLeaf=false;
while(n.leftNode!=null)
{
System.out.println(n.nodeValue);
n=n.leftNode;


}
endOfLeftLeaf=true;


}*/
	MyNewNode centreNode=null;
	MyNewNode n2=null;
 for(MyNewNode n1=n;;)
{
	
if(n1.leftNode!=null && n1.leftNode.traversedOrnot==false){
   n1=n1.leftNode;
	continue;
	
}
else
{
	
	/*System.out.println(n1.nodeValue);
	n1.traversedOrnot=true;*/
	//call previous method which gets right node
	//centreNode =n1.previousNode;
	//centreNode.traversedOrnot=true;
	//System.out.println(centreNode.nodeValue);
	if(n1.rightNode!=null && n1.rightNode.traversedOrnot==false)
				
	{	
		
		System.out.println(n1.nodeValue);
		n1.traversedOrnot=true;
		n1.rightNode.traversedOrnot=true;
		n1=n1.rightNode;
		
		continue;
		
	}
	
	else{
		
		if(n1.previousNode==null){break;}
		else
		{
			n1.previousNode.traversedOrnot=true;
			n1=n1.previousNode;
		continue;
		}
	}
	
}


}
	
	
	
	
	
	
	
	
	
	

}



public MyNewNode[] getNextNodes(MyNewNode n)
{
MyNewNode []newN=new MyNewNode[2];
if(n.rightNode!=null){
	newN[1]=n.rightNode;
}
if(n.leftNode!=null){
	newN[1]=n.leftNode;
}


return newN;
}
public MyNewNode nextLeftNode(MyNewNode n)
{
return 	this.leftNode;
}

public MyNewNode nextRightNode(MyNewNode n)
{
return 	this.rightNode;
}

}

public class BinarySearchAlgPostOrderTraversal {
public static void main(String[] args) {
	
	MyNewNode n=new MyNewNode(5);
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
	
	//Binary search..
	int i =n.leftdepthofTree;
	int j=n.rightdepthofTree;
	
	System.out.println("depth of left search  "+i);
	System.out.println("depth of left search  "+j);
	n.postOrderTraversal(n);
	
	System.out.println("  ");
}
	
	
}
