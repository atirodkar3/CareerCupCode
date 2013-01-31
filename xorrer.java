/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
import java.util.*;
import java.io.*;


public class xorrer {
    public static void main(String args[])
    {
    
    
    int[] x={1,2,3,5,6,7,8,9,10};
    int xr=1;
    for(int i=1;i<x.length;i++)
    {
        xr=xr^x[i];
    }
    int xr1=1;
    for(int i=2;i<x.length+2;i++)
    {
        xr1=xr1^i;
    }
    
    
    System.out.println(xr^xr1);    
    //System.out.println(1^2);
    
    }
    
    
    
    
}
