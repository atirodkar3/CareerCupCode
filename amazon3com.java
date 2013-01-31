
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */



public class amazon3com {
    static void checker(String x){
        String found="";
        String tempval="";
        int previ=999;
        for(int i=0;i<x.length();i++)
        {  
            for(int j=i+1;j<x.length();j++)
            {
                if(x.charAt(i)==x.charAt(j))
                {   if(previ==999 || x.charAt(previ)==x.charAt(j-1))
                {
                    tempval+=x.charAt(j);
                    previ=i;
                    break;
                }
                    
                }
                
            }
        }
        if(tempval.length()>found.length())
            {
                found=tempval;
            }
        else{
            tempval="";
            }
        System.out.println(found);
    }
    
    static void kpoints(int x[][], int k)
    {   int cur[]={3,4};
        int val[]=new int[k];
        int kk=9999;
        
        for(int i=0;i<val.length;i++)
        {
            val[i]=kk-i;
        }
        //System.out.println(Arrays.toString(val));
        for(int i=0;i<x.length;i++)
        { Arrays.sort(val);
        
        if( ((cur[0]-x[i][0]) * (cur[0]-x[i][0]) + (cur[1]-x[i][1]) * (cur[1]-x[i][1]))< val[k-1] )
         {
             val[k-1]=((cur[0]-x[i][0]) * (cur[0]-x[i][0]) + (cur[1]-x[i][1]) * (cur[1]-x[i][1]));
         }
            
        }
        
        System.out.println(Arrays.toString(val));
        
    }
    
    static int factorial(int x)
    {   
        int fact=1;
        while(x>0)
        {
            fact*=x;
            x--;
        }
        return fact;
    }
    
    static double coss(double x)
    {   x= x*3.14159/180;
        double cosv=0;
        boolean sign=true;
        for(int i=0;i<20;i+=2)
        {
            double datum=Math.pow(x,i)/factorial(i);
            if(!sign)
                cosv+=datum*(-1);
            else
                cosv+=datum;
            sign=!sign;
        }
        
        return (cosv);
    }
    
    static double sinn(double x)
    {   x= x*3.14159/180;
        double sinv=0;
        boolean sign=true;
        for(int i=1;i<22;i+=2)
        {
            double datum=Math.pow(x,i)/factorial(i);
            
            if(!sign)
                sinv+=(-1)*datum;
            else
                sinv+=datum;
            sign=!sign;
        }
        
        return (sinv);
    }
    
    static void ran()
    {   int arr[]={1,2,3,4,5};
        for(int i=0;i<5;i++)
        {   
            //System.out.println(val);
            int index=(int)(Math.random()*1000)%arr.length;
            //System.out.println(index);
            System.out.println("Random Value "+arr[index]);
            
        }
        
        
    }
    
    
   // static recfibo(int x)
    //{
        
    //}
    

    
    
    public static void main(String args[])
    {/*
        String x="abcdabcdxxabcrrbcdgwb";
        //int[] xx=new int[4];
        int [][] xx={{1,2},{3,4},{5,6},{3,2},{3,3}};
        //System.out.println(xx[0][0]);
        
        checker(x);
        kpoints(xx,2);*/
       // System.out.println(factorial(3));
        System.out.println(coss(45));
       System.out.println(sinn(45));
       System.out.println((2<<1)+" "+(2<<3));
       int a;
       int b;
       ran();
    }
    
    
    
}
