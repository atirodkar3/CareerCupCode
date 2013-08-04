import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Arrays;

class HashSetOrder {
    public static void main(String[] args) {
        Integer[] arrayInt = new Integer[]{22,1,3,3,2,2,5,6,-1,7,4,4,4,4,4,4};
		LinkedHashSet<Integer> linkedSet = new LinkedHashSet<Integer>();
		Collections.addAll(linkedSet,arrayInt);

		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		Collections.addAll(treeSet,arrayInt);
				
        System.out.println(Arrays.deepToString(linkedSet.toArray()));
	    System.out.println(Arrays.deepToString(treeSet.toArray()));
	
    }
}