
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

class Element{

int data;
Element link=null; 
 
public Element(int d)
{
    data=d;
}

void append(int d){
    Element end=new Element(d);
    Element n=this;
    while(n.link!=null){
        n=n.link;
    }
    n.link=end;
}

Element appendstart(Element e,int d){
    Element start=new Element(d);
    start.link=e;
    return start;
}

void dispel(Element e)
{   Element prev = e;
    do
    {
       System.out.println("Element"+prev.data);
        prev=prev.link;        
    }while(prev!=null);
}

public void checkduplicate(Element e)
{
    Element prev=e;
    do{
        
        
       // System.out.println("Value Being Checked "+prev.data);
        Element pprev=prev;
                do{
                    
                            if(prev.data==pprev.link.data)
                            {  // System.out.println("Value Being Compared With "+pprev.data+" "+pprev.link.data);
                                if(pprev.link.link==null)
                                {
                                    pprev.link=null;
                                }
                                else
                                {
                                    pprev.link=pprev.link.link;
                                }
                            }
                            else
                            {
                                pprev=pprev.link;
                            }
                    
                  }while(pprev.link!=null);
        prev=prev.link;
    }while(prev!=null);
    
}



public void kthtolast(Element e,int k)
{   Element prev=e;
    ArrayList al = new ArrayList(); 
    int count =0;
    do
    {
        al.add(prev.data);
        prev=prev.link;
    }while(prev!=null);
    
    System.out.println("The Value You Are Looking For "+al.get(al.size()-k));
}

public int Converttonumber(Element e)
{
    String s="";
    Element prev=e;
    do
    {
        s+=prev.data;
        prev=prev.link;
    }while(prev!=null);
StringBuffer sb=new StringBuffer(s);
sb=sb.reverse();
return(Integer.parseInt(sb.toString()));

}

public void adder(Element e,Element f)
{
    int x=Converttonumber(e);
    int y=Converttonumber(f);
    
    System.out.println("Added Value"+(x+y));
}

public Element breaker(Element e,int br)
{
    Element newlist=new Element(br);
    Element prev=e;
    do{
        
        if(prev.data>=br)
        {//System.out.println("Check");
            newlist.append(prev.data);
        }
        if((prev.data<br))
        {//System.out.println("Check1");
         newlist=newlist.appendstart(newlist,prev.data);
        }
        prev=prev.link; 
    }while(prev.link!=null);
       
   return newlist;
    
    
}






}

public class LinkedList {
public static void main(String args[])
{
    Element e=new Element(1);
    e.append(2);
    e.append(2);
    e.append(14);
    e.append(5);
    e.append(6);
    e.append(7);
    e.append(28);
    e.append(0);
    e.append(6);
    //Element mm=e.link;
    /*System.out.println(mm.data);
    mm=e.link.link;
    System.out.println(mm.data);
    
    System.out.println(e.data);*/
   // e.dispel(e);
   // System.out.println("RUN 1 DONE");
    //e.checkduplicate(e);
   // System.out.println("RUN 2 DONE");
    //e.dispel(e);
    //e.kthtolast(e, 3);
    Element a=new Element(7);
    a.append(1);
    a.append(6);

    Element b=new Element(5);
    b.append(9);
    b.append(2);
    
    //e.adder(a, b);
    Element x=e.breaker(e, 6);
    System.out.println("TEST");
    e.dispel(x);

}


    
}
