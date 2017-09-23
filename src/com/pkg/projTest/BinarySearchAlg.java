package com.pkg.projTest;

class Node
{
int  nodeValue;
Node leftNode;
Node rightNode;
int currentNodeDepth=0;
 int leftdepthofTree;
int rightdepthofTree;
public Node(int i)
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

public Node addNode(int Value)
{   Node leftNode;
	Node rightNode;
	Node currentNode=this;
	Node tempNode=this;
	Node returnedNode=null;
	Node breakNode=null;
	Node rightTemp[]=null;
	
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
			tempNode= new Node(Value);
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
			tempNode= new Node(Value);
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



public Node[] getNextNodes(Node n)
{
Node []newN=new Node[2];
if(n.rightNode!=null){
	newN[1]=n.rightNode;
}
if(n.leftNode!=null){
	newN[1]=n.leftNode;
}


return newN;
}
public Node nextLeftNode(Node n)
{
return 	this.leftNode;
}

public Node nextRightNode(Node n)
{
return 	this.rightNode;
}

}

public class BinarySearchAlg {
public static void main(String[] args) {
	
	Node n=new Node(5);
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
}
	
	
}
