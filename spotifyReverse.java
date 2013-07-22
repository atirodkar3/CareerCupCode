import java.util.Scanner;

public class spotifyReverse {

    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println(reverseBinary(s.nextInt()));
	}
 
    private static int reverseBinary(int inputNumber)	 {
	    
		String binaryInputRepresentation = Integer.toBinaryString(inputNumber);
		
		String outputBinary = "";
		
		for(int i = binaryInputRepresentation.length() - 1; i > -1; i --) {
		    outputBinary += binaryInputRepresentation.charAt(i);
		}
		
		return Integer.parseInt(outputBinary, 2);
		
	}

	
}

