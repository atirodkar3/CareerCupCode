
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
class Node{
    
    int data;
    Node left=null;
    Node right=null;
    Node link=null;
    
    public Node(int d)
    {
        data=d;
    }
    
    public void append(int d)
    {
        Node n=this;
        Node nval=new Node(d);
        if(n==null)
        {
            n.data=d;
        }
        else
        {   boolean done=false;
            while(!done)
            {
                 if(n.data<=d)
                 {
                     if(n.left==null)
                     {
                         n.left=nval;
                         done=true;
                     System.out.println("Data Entered Left "+nval.data);
                     }
                     else
                     {
                         n=n.left;
                     }
                 }
                 else
                 if(n.data>d)
                 {
                     if(n.right==null)
                     {
                         n.right=nval;
                         done=true;
                     System.out.println("Data Entered Right "+nval.data);
                     }
                     else
                     {
                         n=n.right;
                     }
                 }
            }
        }
    }
    
    
       
        
    
    public void BFS()
    {   Node n=this;
        Node bfs=new Node(n.data);
        while(bfs!=null)
        {
            if(n.left!=null)
            {   boolean x=false;
                do
                {
                    
                    
                }while(!x);
            }
            
            
        }
        
    
        
    }
    
}


public class TreeTraversal {
    
    public static void main(String args[])
    { 
        Node x=new Node(10);
        x.append(2);
        x.append(13);
        x.append(4);
        x.append(22);
        
    
    }
    
    
}
