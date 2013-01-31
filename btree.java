/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
import java.util.*;


public class btree {
 int data;
 btree left;
 btree right;
 btree head;
 
 public btree(int d)
 {
     data=d;
     left=null;
     right=null;
     head=this;
     System.out.println(head.data);
 }

 public btree(int d,int i)
 {
     data=d;
     left=null;
     right=null;
 }
 
 
void add(int d)
 {
     btree n=this.head;
     boolean done=false;
     btree newd=new btree(d,1);
     while(!done)
     {  
         if(d>n.data)
         {
            if(n.right==null)
            { n.right=newd;
              done=true;  
            }
            else
                n=n.right;
         }
         else
         if(d<n.data)
             {
              if(n.left==null)
              {    n.left=newd;
                   done=true;
              }
              else
                 n=n.left;
             }
         else
             if(d==n.data)
             {
                 System.out.println("No duplicates");
                 done=true;
             } 
     }
 }


void removeNode()
{
    
}
 
 void inorder(btree p)
 {  
     if(p!=null)
     {
         inorder(p.left);
         System.out.println(p.data);
         inorder(p.right);
     }
 }
    
 btree gethead()
 {
     return head;
 }
 
 public void BFS(btree p)
 {
     LinkedList ll=new LinkedList();
//     ll.add(2);
     
     
     
 }
 
 
 public static void main(String args[])
 {
     btree b=new btree(5);
     b.add(2);
     b.add(7);
     b.add(6);
     b.add(3);
     b.add(2);
     b.add(4);
     b.inorder(b.gethead());   
 }

 
 

}
