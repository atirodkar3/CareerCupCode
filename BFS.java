import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class BFS {

    public static void main(String[] args) {
        Node head = new Node(7);
        head.left = new Node(4);
        head.left.left = new Node(2);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(8);

        System.out.println(Arrays.toString(BreadthFirstSearch(head)));
    }

    private static int[] BreadthFirstSearch(Node head) {
        
        int[] returnArray = new int[6];
        int count = 0;
        Queue<Node> q = new LinkedList<Node>();

        q.add(head);
        while (!q.isEmpty()) {
           Node current = q.remove();
           returnArray[count] = current.data;
           count++;
           if(current.left != null) {
               q.add(current.left);
           }
           if(current.right != null) {
               q.add(current.right);
           }
        }
        
        return returnArray;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int n) {
        this.data = n;
        this.left = null;
        this.right = null;
    }

}
