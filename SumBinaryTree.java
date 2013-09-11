import java.util.ArrayList;
import java.util.Arrays;
class Node {

    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

class SumBinaryTree {
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(4);
        head.left.left = new Node(5);
        head.right = new Node(0);
        head.right.left = new Node(2);
        head.left.left.right = new Node(4);
        head.right.right = new Node(10);

        TwoSumOverBinaryTree(head, 3);
        TwoSumOverBinaryTree(head, 5);
    } 

    private static void TwoSumOverBinaryTree(Node head, int sum) {
        ArrayList<Integer> nodeList = new ArrayList<Integer>();
        int[] inputArray = listToArrayCopy(preOrderTraversal(head, nodeList));
        Arrays.sort(inputArray);

        int left = 0;
        int right = inputArray.length - 1;
        
        while(left <= right) {
            int total = inputArray[left] + inputArray[right];
            if(total == sum) {
                System.out.println("Left = " + inputArray[left] + ", Right = " + inputArray[right]);
                left++;
                right--;
            } else if(total > sum) {
                right--;
            } else if(total < sum) {
                left++;
            }
        }
    }

    private static ArrayList<Integer> preOrderTraversal(Node head, ArrayList<Integer> treeValues) {
        if(head == null) {
            return treeValues;
        } else {
            treeValues.add(head.data);
            treeValues = preOrderTraversal(head.left, treeValues);
            treeValues = preOrderTraversal(head.right, treeValues);
        }
        return treeValues;
    }
     
    private static int[] listToArrayCopy(ArrayList<Integer> sourceList) {
        int[] destArray = new int[sourceList.size()];
        int count = 0;
        for(Integer i : sourceList) {
            destArray[count++] = i;
        }
        return destArray;
    }
}
