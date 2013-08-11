class CheckSubStringPattern {

    public static void main(String[] args) {
	    System.out.println(checkIfPattern("aterbottlew", "waterbottle"));
	}
	
	private static String checkIfPattern(String input, String target) {
	    boolean match = false;
		
		for(int i = 0; i < input.length(); i++) {
		    if(composeStringMatch(input, i, target)) {
			    match = true;
			}
		}
		
		if(match) {
		     return "Success";
		} else {
		    return "Failure";
		}	
	}
	
	private static boolean composeStringMatch(String input, int index, String target) {
	    if((input.substring(index, input.length()) + input.substring(0, index)).equals(target)) {
		    return true;
		} else {
		    return false;
		}
	} 
}