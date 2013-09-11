import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;

class HashSetOrder {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{22,1,3,3,2,2,5,6,-1,7,4,4,4,4,4,4};
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Collections.addAll(hashSet, arrayInt);
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<Integer>();
	Collections.addAll(linkedSet,arrayInt);
	TreeSet<Integer> treeSet = new TreeSet<Integer>();
	Collections.addAll(treeSet,arrayInt);
        treeSet = (TreeSet)treeSet.descendingSet();
        System.out.println(Arrays.deepToString(hashSet.toArray()));
        System.out.println(Arrays.deepToString(linkedSet.toArray()));
        System.out.println(Arrays.deepToString(treeSet.toArray()));
	
    }
}
