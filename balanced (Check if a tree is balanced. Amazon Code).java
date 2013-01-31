class btree {
 int data;
 btree left;
 btree right;
 btree head;
 
 public btree(int d)//This constructor makes the head node.
 {
     data=d;
     left=null;
     right=null;
     head=this;
     //System.out.println(head.data);
 }

 public btree(int d,int i)//This constructor basically adds in values. I've added the extra int variable so that the head won't be reset again.
 {
     data=d;
     left=null;
     right=null;
 }
 
 
void add(int d)//This function can be used to construct a BST... Which is always balanced.
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



 static public btree returnSample()//A sample btree. This one is balanced.
 {
     btree n=new btree(5);
     n.left=new btree(3);
     n.right=new btree(7);
     n.left.left=new btree(2);
     n.left.right=new btree(4);
     n.right.left=new btree(6);
     n.right.right=new btree(8);
     return n;
     /*Looks Like           5
      *               3           7   
      *            2     4     6     8    
      * 
      *
      */
 
 }
 
 static public btree badSample()//A sample btree. This one is NOT balanced.
 {
     btree n=new btree(1);
     n.left=new btree(2);
     n.right=new btree(3);
     n.right.right=new btree(4);
     n.right.right.left=new btree(5);
     return n;
     
     
     /*Looks like:         1
      *                2       3
      *                             4
      *                        5
      */
 } 
 
 // As I said on the phone, let's now iterate through both the left and right subtree from the Root Node. We use a bunch of recursive calls to check the height. We then compare the height. Since it goes across both the trees, at every Node, it does the check and returns an int which specifies the height.
 
 static int height(btree p)
 {
     if(p==null)    // The base case. If the node is null, then the height is null as well.
         return 0;
     
     int lh=height(p.left);// Recurse and get the length of the left hand side.
     if(lh==-9999)
         return -9999;
     
     int rh=height(p.right);// Recurse and get the length of the right hand side
     if(rh==-9999)
         return -9999;
     
     int diff=lh-rh;//Now, we have the left and the right hand side. If either of them were <1, so if both were equal we would get 9999-9999=0. Anything else would be >1. We return whatever the max depth is: i.e. the actual height of the tree. Corner cases like left height being 1 and right height being more are considered as examples. 
     if(Math.abs(diff)>1)
         return -9999;
     else
         return Math.max(lh,rh)+1;
 } 
}
public class balanced {
public static void main(String args[]){
    btree b=new btree(1);
    btree sample=b.returnSample();
    
    if(b.height(sample)==-9999)//This should come out as balanced.
    {
        System.out.println("Not balanced");
    }else
    {
        System.out.println("Balanced");
    }
    
        if(b.height(b.badSample())==-9999)//This should come out as not balanced.
    {
        System.out.println("Not balanced");
    }else
    {
        System.out.println("Balanced");
    }
}    

/*
OUTPUT:

run:
Balanced
Not balanced
BUILD SUCCESSFUL (total time: 0 seconds)
*/

}

