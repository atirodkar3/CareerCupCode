/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

class Noden{
    int data;
    Noden left;
    Noden right;
    
    public Noden(){
        left=null;
        right=null;
    }
    
    public Noden(int x){
        data=x;
        left=null;
        right=null;
    }
    
    public void setLeft(Noden i){
        //left=this.left;
        left=i;
    }
    
    public void setRight(Noden i){
        right=i;
    }
    
    public void setdata(int i){
        data=i;
    }
    
    public int getdata(){
        return data;
    }
    
    public Noden getLeft(){
        return left;
    }

    public Noden getRight(){
        return right;
    }

}


class BST1 {
    private int count;
    private Noden tree;
    
    public BST1(){
        tree=null;
        count=0;
    }
    
    public boolean addNode(int d)
    {
        Noden newd=new Noden(d);
        
        if(count==0){
            tree=newd;
            count=1;
        }
        else{
            Noden cur=tree;
            while(true){
                if(d>cur.getdata()){
                    if(cur.getRight()==null){
                        cur.setRight(newd);
                        count++;
                        return true;
                    }
                    else{
                        cur=cur.getRight(); 
                    }
                }
                else{
                    if(d<cur.getdata()){
                        if(cur.getLeft()==null){
                            cur.setLeft(newd);
                            count++;
                            return true;
                        }
                        else{
                            cur=cur.getLeft();
                        }
                    }
                    if(d==cur.getdata()){
                        return false;
                    } 
                }
            }
        }
    return true;       
    }
 
    public boolean deleteNode(int d)
    {   
        if(tree==null){
         return false;   
        }
        Noden cur=tree;
        Noden cprev=null;
        while(cur!=null && d!=cur.getdata())
        {
            if(d>cur.getdata())
            {
                cprev=cur;
                cur=cur.getRight();
            }
            else if(d<cur.getdata()){
                cprev=cur;
                cur=cur.getLeft();
            }
        }
            
        if(cur==null){
            return false;
        }
        if(cur.getLeft()==null){
            if(cprev!=null){
                if(cprev.getRight().equals(cur)){
                    cprev.setRight(cur.getRight());
                }
                else {
                    cprev.setLeft(cur.getRight());
                }
            
            count--;
            }
        else{
            tree=cur.getRight();
            count--;
        }
        return true;
        }
        else if(cur.getRight()==null){
            if(cprev!=null){
                if(cprev.getLeft().equals(cur)){
                    cprev.setRight(cur.getLeft());
                }
                else{
                    cprev.setLeft(cur.getRight());
                }
            count--;
        }
        else{
            tree=cur.getLeft();
            count--;
        }
        return true;
    }
        else{
           Noden tprev=cur;
           Noden temp=cur.getLeft();
           
           while(temp.getRight()!=null)
           {
               tprev=temp;
               temp=temp.getRight();
           }
           cur.setdata(temp.getdata());
                   if(tprev!=cur){
                       tprev.setRight(temp.getLeft());
                   }
                   else{
                       tprev.setLeft(temp.getLeft());
                   }
                   --count;
                   return true;   
        }
    }

    public void preorder(Noden p){
        if(p!=null)
        {
            System.out.println(p.getdata());
            preorder(p.getLeft());
            preorder(p.getRight());
        }
    }
    
    public void inorder(Noden p){
        if(p!=null)
        {
            preorder(p.getLeft());
            System.out.println(p.getdata());
            preorder(p.getRight());
        }
    }
        
    public void postorder(Noden p){
        if(p!=null)
        {
            preorder(p.getLeft());
            preorder(p.getRight());
            System.out.println(p.getdata());
        }   
    }    
    
    public Noden getRoot()
    {
       return tree;
    }
}

public class BST{
    public static void main(String args[])
    {
       BST1 tree=new BST1();
       tree.addNode(1);
       tree.addNode(2);
       tree.addNode(3);
       tree.addNode(4);
       tree.addNode(5);
       tree.addNode(6);
       System.out.println("Pre");
       tree.preorder(tree.getRoot());
       System.out.println("Post");
       tree.postorder(tree.getRoot());
       System.out.println("IN");
       tree.inorder(tree.getRoot());
       tree.deleteNode(3);
       tree.deleteNode(4);
       System.out.println("2Pre");
       tree.preorder(tree.getRoot());
       System.out.println("Post");
       tree.postorder(tree.getRoot());
       System.out.println("IN");
       tree.inorder(tree.getRoot()); 
    }
    
}