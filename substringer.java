/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class substringer {
    
public static void main(String args[])
{
   String s1="waterbottle";
   String s2="erbottlewat";
   
   if(s2.length()!=s1.length())
   {System.out.println("Length Does not Match");    
   }
   else
   {       
   System.out.println("Length Matches");  
   for(int i=0;i<s2.length();i++)
   {
       String temp=s2.substring(i,s2.length());
       temp=temp+s2.substring(0, i);        
       System.out.println(temp);
       if(temp.equals(s1))
        {
            System.out.println("Match Found at "+i);
            break;
        }
   }    
   }

}
}
