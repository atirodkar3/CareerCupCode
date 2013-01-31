/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
import java.util.*;

public class ArraysandStrings1 {

public static void main(String args[])
{   Scanner s=new Scanner(System.in);
    System.out.println("Enter String");
    String inputstring=s.next();
    
    boolean xx=false;
    
    if(inputstring.length()>256)
    {
    System.out.println("Since Length over 256, there has to be a copy.");
    }
    else
    {
    for(int i=0;i<inputstring.length();i++)
    {   
 
        
            for(int j=i+1;j<inputstring.length();j++)
            {
                if(inputstring.charAt(i)==(inputstring.charAt(j)))
                {   if(xx)
                        break;
                    System.out.println("There is a copy of "+inputstring.charAt(j));
                    xx=true;

                }

            }
        
     
    }
    if(!xx)
    {
        System.out.println("No Match Found");
    }
    }
    
    
}
    
    
    
}
