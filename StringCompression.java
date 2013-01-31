/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

import java.util.*;
public class StringCompression {
 
    public static void main(String args[])
    {
        System.out.println("Enter String");
        Scanner s=new Scanner(System.in);
        String ss=s.nextLine();
        Hashtable alpha=new Hashtable();
        
        for(int i=0;i<ss.length();i++)
        {
            if(!alpha.containsKey(ss.charAt(i)))
            {   
                alpha.put(ss.charAt(i),1);
            }
            else
            {   int balance=Integer.parseInt(alpha.get(ss.charAt(i)).toString());
                alpha.put(ss.charAt(i),balance+1);
            }
        }
     String fin="";   
     Set set=alpha.entrySet();
     Iterator it=set.iterator();
        while(it.hasNext())
        {   //System.out.println("kkk "+it.next());
            fin+=it.next();
        }
    fin=fin.replace("=", "");
    
    
    if(fin.length()<ss.length())
    {
    System.out.println("Compressed String "+fin);    
    }
    else
    {
    System.out.println("Original String "+ss);        
    }
    
    
    }
    
    
    
    
}
