
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rosenkrantz
 */




public class palindromedynamic {
   
static void dynapalin(String s)
{


String best;
best="";

for(int p=1;p<s.length()-1;p++)
{   String cur="";
    cur+=s.charAt(p);
    int lp=p-1;
    int rp=p+1;
    boolean check=true;
    while(check)
    {   System.out.println("CHECKED "+s.charAt(lp)+" "+s.charAt(rp)+" "+lp+" "+rp+" "+p);
    if(s.charAt(lp)==s.charAt(rp))
        {
            cur=s.charAt(lp)+cur+s.charAt(rp);
            if(lp!=0 && rp!=s.length()-1)
            {
                lp--;
                rp++;
            }
            else
            {
                check=false;
            }
            
            
        }
        else
    {
        check=false;
    }
    }
    
    if(cur.length()>=best.length())
    {
        best="";
        best=cur;
        System.out.println(best);
    }

}

//System.out.println(best);
}    

static void permutations(String s)
{
     ArrayList<String> words = new ArrayList<String>();;
    String g="";
    words.add(g);
    g+=s.charAt(0);
    words.add(g);
    
    for(int i=1;i<s.length();i++)
    {
     ArrayList<String> nwords = new ArrayList<String>();;   
        Iterator iter=words.iterator();
        
        while(iter.hasNext())
        {
            String ns=iter.next().toString();
            for(int j=0;j<ns.length()+1;j++)
            {   
                if(j==0)
                {//   System.out.println("ffwf");
                    nwords.add(s.charAt(i)+ ns.substring(j,ns.length()));
                    //nwords.add(ns.substring(j,ns.length())+s.charAt(i));
                    // System.out.println(s.charAt(i)+ ns.substring(j,ns.length()));
                }
                else
                {   
                  //  System.out.println("ffwf");
                    //System.out.println(ns.substring(0,j-1) + s.charAt(i)+ ns.substring(j+1,ns.length()));
                    nwords.add(ns.substring(0,j) + s.charAt(i)+ ns.substring(j,ns.length()));
                }
            }
        }
    
    Iterator iter1=nwords.iterator();
        
        while(iter1.hasNext())
        {
            String ss=iter1.next().toString();
            if(!words.contains(ss))
            {
                words.add(ss);
            }
          //  System.out.println(ss);
        }
    }
 
       Iterator iter2=words.iterator();
        
        while(iter2.hasNext())
        {
            System.out.println(iter2.next());
        } 
    
    
    
}
    
    
static void brackets(int n)
{
    ArrayList<String> br2=new ArrayList<String>();

    br2.add("()");
    
    for(int i=0;i<n-1;i++)
    {   
        ArrayList<String> br3=new ArrayList<String>();
        Iterator iter=br2.iterator();
        String xy;
        
        while(iter.hasNext())
        {   
            xy=iter.next().toString();
            for(int j=0;j<xy.length();j++)
            {   String temp="";
                if(j==0)
                {
                   temp="()"+xy;
                   
                }
                else
                {
                    temp=xy.substring(0,j)+"()"+xy.substring(j,xy.length());
                }
                br3.add(temp);
                
            }
            
        }
    Iterator i4=br3.iterator();
    while(i4.hasNext())
    {
        String g=i4.next().toString();
        if(!br2.contains(g))
        {br2.add(g);
        }
    }
    
    }
    
    Iterator i1=br2.iterator();
    while(i1.hasNext())
    {
        System.out.println(i1.next());
        
    }
    
            
    
}


static void anagram(String[] s)
{
    Hashtable alpha=new Hashtable();
    for(int i=97;i<123;i++)
    {   
    alpha.put(i,(char)i);
   // String val="ff";
  //  System.out.println((int)val);
    //System.out.println("OUT "+(char)i+" "+Integer.valueOf((char)i));

    }
    
    Set set=alpha.entrySet();
    Iterator i1=set.iterator();
    
    while(i1.hasNext())
    {
        System.out.println(i1.next());
    }
    Hashtable wordc=new Hashtable();
    wordc.put(stringval(s[0]),s[0]);
    for(int i=1;i<s.length;i++)
    {
        
      //  wordc.put(s[i], )
        if(wordc.containsKey(stringval(s[i])))
                {   
                    String x=wordc.get(stringval(s[i])).toString();
                    if(x.length()==s[i].length())
                            {
                             System.out.println("ANAGRAM "+s[i]+" "+x);   
                            }
                    
                }  
       wordc.put(stringval(s[i]),s[i]);
       
    }
}
static int stringval(String s)
{   
    int x=0;
    for(int i=0;i<s.length();i++)
    {
        x+=(int)s.charAt(i);
    }
    return x;
}



public static void main(String args[])
{
    //palindromedynamic.dynapalin("ab53lerelba");
    //permutations("abc");
    //brackets(4);
    /*
    String[] s={"ameya","fff","ayema","ayem"};
    anagram(s);

    cache c=new cache();
    c.add(2);
    c.add(4);
    c.add(5);
    System.out.println(c.getPos());
    System.out.println(c.access());*/
}
}

class cache{
Hashtable ca=new Hashtable();
int i=0;

void add(int x)
{   
    if(i>10)
    {
        i=0;
        ca.put(i,x);    
    }
    else
    {
        ca.put(i,x);    
        i++;
    }
}

int getPos()
{
return i;
}

int access()
{
    int hit=(int)(Math.random()%i);
    return (int)(ca.get(hit));
}
}
