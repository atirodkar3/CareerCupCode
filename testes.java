/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

class Noder{
    int data;
    Noder link=null;
    
    public Noder(int d)
    {
        data=d;
    }
    
    public void iterate(){
    Noder n=this;
    do
    {   
     System.out.println(n.data);   
     n=n.link;   
    }while(n!=null);
    }
    
    public void append(int c)
    {
    Noder n=this;
    Noder x=new Noder(c);
    while(n.link!=null)
    {
     n=n.link;   
    }

    n.link=x;
    }
    
    
    
    
}
    
    
    



public class testes {
    
    public static void main(String args[])
    {
    Noder nn=new Noder(1);
    nn.append(2);
    nn.append(3);
    nn.append(4);
    nn.iterate();
    }
}
