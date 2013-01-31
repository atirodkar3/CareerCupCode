import java.util.*;

class Node{
int data;
Node next=null;
Node end=null;
Node head=null;

public Node(int x){
data=x;
end=this;
head=this;
}

public void addNode(int d){
Node nn=new Node(d);
end.next=nn;
end=end.next;
System.out.println("Added "+d);
}

public void removeNode(int d){
Node n=this;
boolean flag=false;
    do{
    if(n.next.data==d){
    	    System.out.println("Removed "+d);
	    if(n.next.next==null)
		    {n.next=null;
		     break;
		    }
	    else
	            {n.next=n.next.next;	    
	            }
	    flag=true;
    		}
	    else
		{
		n=n.next;
		}		
       }while(n.next!=null && !flag);

	if(!flag)
	{
	System.out.println("Item Not Present");
	}
}

public void printlink(){
Node n=this;
while(n!=null){
System.out.println(n.data);
n=n.next;
}
}

public Node reverseList(){
Node n=this;
Node newd=new Node(n.data);
if(n==null) return n;
else
{
do
{
Node newn=new Node(n.next.data);
newn.next=newd;
newd=newn;
n=n.next;
}while(n.next!=null);
return newd;
}
}

public Node recreverseList(Node n){
if(n==null) return null;
if(n.next==null)return n;

Node nex=n.next;

n.next=null;

Node Remain=recreverseList(nex);

nex.next=n;
return Remain;

}

public void placerev(String x)
{
	x=x+"/";
	int i=x.length()-1;
	int j=0;
	while(j!=i && x.charAt(i)!='/')
	{
		if(x.charAt(i)!=' ')
			{
				i--;	
			}
		else
			{
							
				String temp=x.substring(i,x.length()-1);
				j+=temp.length()-1;
				x=temp+x.substring(0,i-1);
				i=x.length()-1;
			}
	}
	x=x.substring(0,x.length()-1);
	System.out.println("FInal String //"+x+"//");

	
	
}


public Node Linkex()
{
	Node x=new Node(1);
	x.next=new Node(2);
	x.next.next=new Node(3);
	x.next.next.next=new Node(4);
	//x.next.next.next.next=x.next;
	return x;
}

public String cyc(Node x)
{
String ret="";
boolean check=false;
Node hare=x.head;
Node tortoise=x.head;
while(!check)
{
	if(hare.next==null)
	{	
		ret="No Cycle";
		check=true;		
	}
	else 
	{	hare=hare.next;
	
	if(hare.next!=null && hare!=tortoise)
	{	hare=hare.next;
	}
	else
	{	if(hare==tortoise)ret="Cycle";	
		else
			ret="No Cycle";
		check=true;	
	}
	}
	tortoise=tortoise.next;
	if(hare==tortoise)
	{	ret="Cycle";
		check=true;
	}	
}
	return ret;
}



}

class LinkedList{
public static void main(String args[]){
Node n=new Node(1);
n.addNode(2);
n.addNode(3);
n.addNode(4);
n.removeNode(4);
n.removeNode(43);
n.printlink();
Node nn=n.reverseList();
nn.printlink();
Node nn1=n.recreverseList(n);
nn1.printlink();
n.placerev("I Love To Play");
Node xer=n.Linkex();
System.out.println(n.cyc(xer));
}
}