class StringAdder {

    public static void main(String[] args) {
        String input = "112112221333111111444444444333";
	    System.out.println(countString(input));
    }

    private static String countString(String input) {
        input = input + " ";
        String countString = "";
	    int count = 1;
	    String currentChar = "";
	
	    for(int i = 0; i < input.length(); i++) {		
        	if(!currentChar.equals(input.substring(i, i+1))) { 
    			if(!currentChar.equals("")) {
			            countString += count + currentChar;
				}
    			currentChar = input.substring(i, i+1);
	    		count = 1;
	    	} else {
    		        count++;		
		    }		
	    }
		return countString;
    }
}