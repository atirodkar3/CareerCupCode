import java.util.*;
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class hanoi {
static int diskarr[]=new int[6];
static int count=0;
public static void init()
{
  for(int i=0;i<6;i++)
  {
      diskarr[i]=0;
  
  }
}
public static void main(String args[])
{
    
System.out.println("Enter the Number of Disks");    
Scanner s=new Scanner(System.in);
int disknum=s.nextInt();
hanoi.init();
hanoi.move(disknum,3,1,2);

System.out.print(count);
}
    


public static void move(int n, int from, int to, int via) {
if (n == 1) {
    System.out.println("Move disk from pole " + from + " to pole " + to);
    diskarr[from]--;
    diskarr[to]++;
    count++;
  for(int i=0;i<6;i++)
  {
      if(diskarr[i]<0){diskarr[i]=0;}
  
  }    
    
  } else {
    move(n - 1, from, via, to);
    move(1, from, to, via);
    move(n - 1, via, to, from);
  }
  
System.out.println(Arrays.toString(diskarr));

}


}

