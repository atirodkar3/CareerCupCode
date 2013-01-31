
import java.util.Enumeration;
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
public class Hashes {
    
public static void main(String args[])
{
    Hashtable leader=new Hashtable();
    leader.put("Dead Kennedys", "Jello Biafra");
    leader.put("Black Flag", "Henry Rollins");
    leader.put("The Cure", "Robert Smith");
    leader.put("Germs", "Darby Crash");
    Enumeration enumeratorr=leader.elements();
    
    Day day = null;
    
    
    
    //System.out.println(enumeratorr.nextElement());
    System.out.println(leader);
    System.out.println(leader.keySet());
    System.out.println(leader.values());
    System.out.println(leader.size());
    //System.out.println(leader.elements());
    
    while(enumeratorr.hasMoreElements())
    {
    //if(leader.containsValue("Black")){System.out.println((leader.get("Black Flag")).toString());}
    System.out.println(enumeratorr.nextElement());
    }
    
    System.out.println ();
    System.out.println ("ITERATOR STUFF");
    System.out.println ();
    
    leader.put("Germs","Lorna Doon");
    Set set = leader.entrySet();
    Iterator enumerator1=set.iterator();
    while(enumerator1.hasNext())
    {
    //if(leader.containsValue("Black")){System.out.println((leader.get("Black Flag")).toString());}
    System.out.println(enumerator1.next());
    }
        
    System.out.println(leader.keySet());
    System.out.println(leader.values());
    


}
    
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}    
    
}
