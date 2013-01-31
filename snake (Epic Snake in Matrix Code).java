
import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */








public class snake {
    
    static LinkedList snaker(int[][] x)
    {   LinkedList finale=new LinkedList();
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<x[0].length;j++)
            {   LinkedList curr=new LinkedList();
                boolean trr=true;
                int l=i;
                int k=j;
                curr.add(x[l][k]);
                while(trr)
               {   //System.out.println("l "+l+" k "+k); 
                   if(k<x[0].length-1 && l<x.length-1)  
                    {       
                            if(Math.abs(x[l][k]-x[l][k+1])==1 && k+1<x[0].length)
                            {   System.out.println("RIGHT1");
                                curr.add(x[l][k+1]);
                                k=k+1;
                            }
                            else if(Math.abs(x[l][k]-x[l+1][k])==1 && l+1<x.length)
                            {   System.out.println("DOWN1");
                                curr.add(x[l+1][k]);
                                l=l+1;
                            }
                            else
                            {
                                trr=false;
                                System.out.println("False 1");
                                if(curr.size()>=finale.size()){
                                finale.clear();
                                while(!curr.isEmpty())
                                {
                                    finale.add(curr.removeLast());
                                }
                                curr.clear();
                                }
                            }
                    }
                    else
                    {
                            if(k<x[0].length-1 && l>=x.length-1)  
                            {   
                                            if(Math.abs(x[l][k]-x[l][k+1])==1 && k+1<x[0].length)
                                         {   System.out.println("RIGHT2");
                                             curr.add(x[l][k+1]);
                                             k=k+1;
                                         }
                                            else
                                            {                                               {
                                        trr=false;
                                        System.out.println("False 2");
                                        if(curr.size()>=finale.size())
                                        {
                                            finale.clear();
                                            while(!curr.isEmpty())
                                            {
                                                finale.add(curr.removeLast());
                                            }

                                        }
                                        curr.clear();
                                        }
                                            }
                                            
                                            
                                            
                            }
                             else
                                        if(k>x[0].length-1 && l<x.length-1)        
                                        {
                                        if(Math.abs(x[l][k]-x[l+1][k])==1 && l+1<x.length)
                                          {   System.out.println("DOWN2");
                                              curr.add(x[l+1][k]);
                                              l=l+1;
                                          }
                                        else{                                               {
                                        trr=false;
                                        System.out.println("False 2");
                                        if(curr.size()>=finale.size())
                                        {
                                            finale.clear();
                                            while(!curr.isEmpty())
                                            {
                                                finale.add(curr.removeLast());
                                            }

                                        }
                                        curr.clear();
                                        }
                                            }
                                        
                                        
                                        
                                        }
                            else
                                        {
                                        trr=false;
                                        System.out.println("False 2");
                                        if(curr.size()>=finale.size())
                                        {
                                            finale.clear();
                                            while(!curr.isEmpty())
                                            {
                                                finale.add(curr.removeLast());
                                            }

                                        }
                                        curr.clear();
                                        }
                         }
                        
                }
                
                
                
                
            }
            
            
            
        }
            
       return finale;
    }
    
    
    
    
    public static void main(String args[]){
    int[][] x={{1,3,2,6,8},{-9,7,1,-1,2},{1,5,0,1,9}};
    LinkedList snn=snaker(x);
    
    while(!snn.isEmpty())
    {
        System.out.println(snn.removeLast());
    }
    
    }
    /*
     * 1 3 2 6 8
    -9 7 1 -1 2
    1 5 0 1 9
     */
    
}
