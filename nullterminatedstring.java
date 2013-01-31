
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class nullterminatedstring {
    
public static String reverse(String s)
{
    String ss="";
    
    for(int i=s.length()-1;i>-1;i--)
    {
        ss+=(s.charAt(i));
    }
    
    return ss;
}
    
    
public static void main(String args[])
{   Scanner s=new Scanner(System.in);
    System.out.println("Enter String");
    String ss=s.next();
    
    System.out.println(reverse(ss));


}
    
    
}
