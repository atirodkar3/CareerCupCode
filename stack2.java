/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class stack2 {
    
    static LinkedList addd(LinkedList l1, LinkedList l2)
    {
        //LinkedList added=new LinkedList();
        LinkedList l3=new LinkedList();
        while(!l1.isEmpty())
        {
            boolean drop=false;
            while(!drop){
                int x=l1.removeLast();
                int y=l2.removeLast();

                if(x>y)
                {
                    l3.add(y);
                }
                if(x<=y)
                {
                    l2.add(x);
                    while(!l3.isEmpty())
                    {
                        l2.add(l3.removeLast());
                    }
                    drop=true;
                }

            }
        }
        
        
        return l2;
        
    }
    
    
    public static void main(String args[])
    {
        LinkedList l1=new LinkedList();
        LinkedList l2=new LinkedList();
        
        l1.add(2);
        l1.add(8);
        l1.add(15);
        l1.add(26);
        
        l2.add(1);
        l2.add(5);
        l2.add(15);
        l2.add(16);
        l2.add(36);
        l2.add(36);
        
        
        Linked List addd=sort(l1,l2);
        
        
    }
    
    
    
}
