import java.util.Arrays;

class QuickSort{
	
    public static void main(String[] args) {
 	
        int[] input = new int[]{1, 1, 0, 3};
	int[] sorted = quickSort(input, 0, input.length - 1);
	System.out.println(Arrays.toString(sorted));
    }

    private static int[] quickSort(int[] input, int left, int right) {
    	int mid = (left + right) / 2;
        int i = left;
        int j = right;

        if((right - left) < 1) {
            return input;
        } 

        while(i <= j) {
       	    while((input[i] <= input[mid]) && (i < mid)) {
                i++;
            }

            while((input[j] > input[mid])) {
                j--;
            }            

	    if(i <= j) {
                int temp = input[i];
	        input[i] = input[j];
	        input[j] = temp;      
                i++;
                j--;                                         
            }
        }
        
        if(j > left) {
	    input = quickSort(input, left, j);
        }

        if(i < right) {
            input = quickSort(input, i, right);
        }
        return input;
    }
}
