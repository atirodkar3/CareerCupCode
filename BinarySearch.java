class BinarySearch {

    public static void main(String args[]) {
        System.out.println("\nTest with Odd Number of Elements");
        int[] test0 = new int[]{1, 4, 9};
        System.out.println(BinarySearch(test0, 4));
        System.out.println(BinarySearch(test0, 9));
        System.out.println(BinarySearch(test0, 1));
        System.out.println(BinarySearch(test0, 0));

        System.out.println("\nTest with all Duplicates");
        int[] test1 = new int[]{1, 1, 1, 1, 1};
        System.out.println(BinarySearch(test1, 1));
	System.out.println(BinarySearch(test1, 0));

        System.out.println("\nTest with One Value");
        int[] test2 = new int[]{-1};
	System.out.println(BinarySearch(test2, -1));
	System.out.println(BinarySearch(test2, 0));

        System.out.println("\nTest with Even Length Array with Large Individual Values");
        int[] test3 = new int[]{0, 2, 214783647, 214783647};
	System.out.println(BinarySearch(test3, 2));
	System.out.println(BinarySearch(test3, 214783647));

        System.out.println("\nTest With Empty Array");
        int[] test4 = new int[]{};
	System.out.println(BinarySearch(test4, 100));

        System.out.println("\nTest with Unsorted Array, kept in a try catch to handle any unidentified behaviour. " 
        + " Coincidentally, returns Value if value checked is the first Mid Value.");
        try {
            int[] test5 = new int[]{13, 4, 11, 9, 0, 0, -1};
            System.out.println(BinarySearch(test5, 14));       
            System.out.println(BinarySearch(test5, 9));       
        } catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println("\nTest with a Huge Array and Huge Values");
        int[] test6 = new int[42956731];
        int count = 0;
        for(int i = -21478365; count < 42956731; i++) {
            test6[count] = i;
            count++;
        }        
        System.out.println(BinarySearch(test6, 214783647));
        System.out.println(BinarySearch(test6, 21478365));
        System.out.println(BinarySearch(test6, -21478365));
        System.out.println(BinarySearch(test6, 4000));
    }


    private static String BinarySearch(int[] input, int valueToSearch) {
        int left = 0;
        int right = input.length - 1;
        int mid = (left + right) >> 1; // Used to handle Overflow Error.

        while((left <= right) && input[mid] != valueToSearch) {    
            if(input[mid] > valueToSearch) {
                right = mid - 1;
            } else if(input[mid] < valueToSearch) {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }
        
        if(left > right) {
            return "Value " + valueToSearch  +" Not Found";
        } else {
            return ("Number " + valueToSearch + " found at Array Position " + mid);
        }
    }
}
