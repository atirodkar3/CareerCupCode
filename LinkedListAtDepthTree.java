import java.util.Hashtable;
import java.util.Arrays;
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    public Node(int n) {
        this.data = n;
        this.left = null;
        this.right = null;
    }

}


class LinkedListAtDepthTree {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(4);
        head.left.left = new Node(3);
        head.right = new Node(6);
        Hashtable<Integer, ArrayList<Integer>> rowValues = getListAtEveryTreeLevel(head); 

        for(int i : rowValues.keySet()) {
            System.out.println(Arrays.toString(rowValues.get(i).toArray()));
        }
    }

    private static Hashtable<Integer, ArrayList<Integer>> getListAtEveryTreeLevel(Node head) {
        Hashtable<Integer, ArrayList<Integer>> depthRows = new Hashtable<Integer, ArrayList<Integer>>();
        depthRows = preOrder(head, 0, depthRows);
        return depthRows;
    }

    private static Hashtable<Integer, ArrayList<Integer>> preOrder(Node current, int level, Hashtable<Integer, ArrayList<Integer>> depthRows) {
        if(current != null) {
            if(depthRows.get(level) == null) {
                ArrayList<Integer> insertList = new ArrayList<Integer>();
                insertList.add(current.data);
                depthRows.put(level, insertList);
            } else {
                depthRows.get(level).add(current.data);
            }

            depthRows = preOrder(current.left, level + 1, depthRows);            
            depthRows = preOrder(current.right, level + 1, depthRows);                      
        }
        return depthRows;
    }
}

