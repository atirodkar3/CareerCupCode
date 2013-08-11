
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class ReplaceSpaces {
    
    public static void main(String args[])
{   Scanner s=new Scanner(System.in);
    System.out.println("Enter String 1");
    String ss=s.nextLine();
    //System.out.println("str 1 "+ss);
    char[] bx=ss.toCharArray();    
    String ssv="";
    for(int i=0;i<bx.length;i++)
    {   
        if(bx[i]==' ')
        {   ssv+="%20";
        }
        else
        {
            ssv+=bx[i];
        }
    }
System.out.println("Final String "+ssv);

System.out.println(ss.replaceAll(" ","%TEST%"));

}
    
    
}
