import java.util.Arrays;

class Kadane {

    public static void main(String[] args) {
	
	    Integer[] input = new Integer[]{ -8, -2, 14, -2, 88, -9};
		
		int maxEndingHere = 0;
		int maxSoFar = 0;
		int startPoint = 0;
		int endPoint = 0;
		
		for(int i = 0; i < input.length; i++) {
            if(0 > maxEndingHere + input[i]) {
			    startPoint = i + 1;
			}
     		maxEndingHere = Math.max(0, maxEndingHere + input[i]);
			
			if(maxSoFar < maxEndingHere) {
			    endPoint = i + 1;
			}
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}	
       
	    Integer[] outputArray = Arrays.copyOfRange(input, startPoint, endPoint);
        System.out.println(Arrays.toString(outputArray)); 
	}
}