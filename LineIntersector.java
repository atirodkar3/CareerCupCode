
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */

class supee{
    int x;
    int y;
    public supee()
{
    x=3;
    y=5;
}
}


public class LineIntersector extends supee{

public LineIntersector(){
    super();
    System.out.println(x);
    System.out.println(y);
}    
    
    
static int subtract(int x,int y)
{
    
    String yy=Integer.toBinaryString(y);
    StringBuilder yyy = new StringBuilder(Integer.toBinaryString(y));
    
    for(int i=0;i<yyy.length();i++)
    {
    
        if(yyy.charAt(i)=='1')
        {
            yyy.setCharAt(i,'0');
        }
        else
        {
            yyy.setCharAt(i,'1');
        }
    
    }
    
    System.out.println("yyy"+yyy);
    Stack<Integer> s1=new Stack();
    
    for(int j=0;j<Math.abs(Integer.toBinaryString(x).length()-Integer.toBinaryString(y).length())+1 ;j++)
    {
        yy="0"+yy;
    }
    System.out.println(yy);
    
    yy=yy.replace("0","2");
    yy=yy.replace("1","0");
    yy=yy.replace("2","1");
    System.out.println(yy);
return (Integer.parseInt(yy,2)+x);



}
    


static void sub()
{
    int z=4;
    
}


    
public static void main(String args[])
{
LineIntersector s =new LineIntersector();    
sub();
int m1=4;
int c1=2;

int m2=3;
int c2=3;


if( ((m1==m2) && (c1==c2)) || (m1!=m2) )
    System.out.println("INTERSECT");
else
    System.out.println("Doesn't Intersect");
    
System.out.println(subtract(4,3));



}   
    
}
