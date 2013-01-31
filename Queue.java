/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

class Elements{
    int data;
    int min;
    Elements link=null;
    Elements next=null;
    public Elements(int d)
    {
        data=d;
        min=d;
    }

    public void append(int d)
    {
        Elements end=new Elements(d);
        min=Math.min(min,end.data);
        Elements n=this;
        while(n.link!=null)
        {
            n=n.link;
        }
        
        n.link=end;
        System.out.println("Current Minimum Value is: "+min);
       // System.out.println(n.link.data);
    }
    
    
    public void PlateAppend(int d)
    {
        Elements nval=new Elements(d);
        Elements n=this;
        while(n.next!=null)
        {
            n=n.next;
        }
        int count=0;
        while(n.link!=null)
        {   count+=1;
            n=n.link;
        }
        if(count==4)
        {
            n.next=nval;
            n=n.next;
        }
    System.out.println("Entry Made");
    }
    
    
    void dispel(Elements e)
    {   System.out.println("Dispel Begin");
        Elements prev = e;
        int co=0;
        do
        {
           System.out.println("Element "+prev.data+" Count: "+co);
            prev=prev.link;        
            co++;
        }while(prev!=null);
        System.out.println("Dispel End");
    }

    void displate(Elements e)
    {   System.out.println("Dispel Begin");
        Elements prev = e;
        int co=0;
        
        do
        {
           System.out.println("Element "+prev.data+" Count: "+co);
            prev=prev.link;        
            co++;
        
        }while(prev!=null);
        
        System.out.println("Dispel End");

        
        
    }
    
public void qout(){
    
    Elements p=this;
    Elements n=p;
    while(n.link!=null)
    {
        int t=n.data;
        n.data=n.link.data;
        n.link.data=t;   
        n=n.link;
    }
    n.link=null;
    System.out.println("PP "+n.data);
    
    do{
        p=p.link;
        
        
    }while(p.link.link!=null);
    System.out.println("Value Queue Removed "+p.data);
    p.link=null;
}
  
public void stack(){
    Elements p=this;
    do{
        p=p.link;
        
        
    }while(p.link.link!=null);
    System.out.println("Value Stack Popped "+p.data);
    p.link=null;
    
    
    
}

public void appender(int d)
{
    Elements n=this;
    
    while(n.next!=null)
    {
        
    }
}



    
}


public class Queue {
    public static void main(String args[])
    {
        Elements e=new Elements(1);
        e.append(2);
        e.append(3);
        e.append(4);
        e.append(5);
        e.append(6);
        e.append(7);
        e.append(8);
        e.append(9);
        e.append(10);
        e.append(11);
        e.append(12);
        e.append(13);
        /*e.dispel(e);
        //e.qout();
        e.stack();
        e.dispel(e);
        e.append(1);
        e.append(6);
        e.stack();
        e.dispel(e);
        e.qout();
        e.dispel(e);*/
        e.PlateAppend(14);
        e.displate(e);
    }
    
    
    
}
