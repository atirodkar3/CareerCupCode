/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */
public class Bits {
    static int getBit(int x, int i)
    {
        boolean val=(x & (1<<i))!=0;    
        // (isHappy == true)?"I'm Happy!":"I'm Sad!"; 
        int xx;
        xx=(val) ? 1:0;
        //System.out.println(xx);
        return xx;
    }
    
    static void printBit(int x){
        System.out.println("Binary Value of "+x);
        int i=1;
        int xlen=Integer.toBinaryString(x).length();
        int count=xlen-1;
        while(count>=0)
        {
          System.out.print(getBit(x,count));
        count--;
        }
    
        System.out.println();
}
    
    static int setBit(int x, int i)
    {   
        x=x|1<<i;
        
        return x;
    }
    
    static int clearBit(int x, int i)
    {   
        //System.out.println(~(1<<i));
        x=x&~(1<<i);
        
        return x;
    }
    
    static void fitinbit(){
        int x=4096;
        int y=199;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(y));
        int ii=2;
        int j=Integer.toBinaryString(y).length();
        int k=j;
        j=0;
        for(int i=ii;i<=k+ii;i++)
        {   
            if(getBit(y,j)==0)
            {   System.out.println("Clearbit "+getBit(y,j));
                x=clearBit(x,i);
            }
            else
            {   System.out.println("Setbit ");
                x=setBit(x,i);
            }
            j++;
        }
    
        System.out.println(Integer.toBinaryString(x));
    
    }
    
    static double decbinconvert(double x)
    {
        double dec=x%1;
        int num=(int)x/1;
        
        String number="";
        
        while(num!=1)
        {
            if((num%2)==0)
            {
                number+=0;
            }
            else
            {
                number+=1;
            }
            num=num/2;
            
        }
        number+=1;
        StringBuffer sb=new StringBuffer(number);
        sb.reverse();
        number=sb.toString();
        
        System.out.println(number);
        number+=".";
        
        int count=0;
        while(count<33 && dec%1!=0.0 )
        {   dec=dec*2;
            number+=(int)dec/1;
            dec=dec%1;
            //System.out.println("DEC "+dec);
            count++;
        }
        System.out.println(count);
        if(count==33)
        {
            System.out.println("Error");
            return 0;
        }
        else
        {
            return Double.parseDouble(number);
        }
    }
    
    
    
    static int factorial(int n)
    {
        if(n<=1)
        { return 1;
        }        
        else
        {    return n*factorial(n-1);
        }
    }
    
    
    public static void main(String args[])
    {/*   int i=1;
        int x=25;
        System.out.println(Integer.toBinaryString(x)+" "+Integer.toBinaryString(x).length());
        printBit(x);
        x=setBit(x,1);
        printBit(x);
        x=clearBit(x,1);
        printBit(x);
    */
        //fitinbit();
        System.out.println(decbinconvert(14.22));
        System.out.println(factorial(4));
        
        
    }
    
    
}
