
import java.util.Scanner;
import java.util.*;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class Stringpermutations {
    
   public static char[] arrange(char[] s)
   {
       for(int i=0;i<s.length;i++)
       {
           for(int j=1;j<s.length;j++)
           {
               if(Character.getNumericValue(s[j-1])>Character.getNumericValue(s[j]))
               {
                  char t=s[j-1];
                  s[j-1]=s[j];
                  s[j]=t;
               }
           }
       }
       
       return s;
   }
    
    public static void main(String args[])
{   Scanner s=new Scanner(System.in);
    System.out.println("Enter String 1");
    String ss=s.next();
    char[] bx=ss.toCharArray();
  //  System.out.println(Arrays.toString(bx));
    System.out.println("Enter String 2");
    String s1=s.next();
    char[] bx1=s1.toCharArray();
    
    bx=Stringpermutations.arrange(bx);
    bx1=Stringpermutations.arrange(bx1);
    
    System.out.println(Arrays.toString(bx));
    System.out.println(Arrays.toString(bx1));
    String fin1="";
    String fin2="";
    for(int i=0;i<bx.length;i++)
    {
        fin1+=bx[i];
    }
    
    for(int i=0;i<bx1.length;i++)
    {
        fin2+=bx1[i];
    }    
    
    if(fin1.equals(fin2))
    {  System.out.println("IS PERMUTATION");
    }
    else
    {
        System.out.println("IS NOT PERMUTATION");
    }   
    //bx=Arrays.sort(bx);
    
    
        

}
}
