class StringInPlaceReverse {

    public static void main(String[] args) {
        System.out.println(reverseString("  _  This is a / /  t2e3s4t  "));
    }
	
	private static String reverseString(String input) {
        int insertPosition = 0;
		
    	for(int i = 0; i < input.length(); i++) { 
		    input = input.substring(0, i) + input.substring(input.length() - 1, input.length()) + input.substring(i, input.length() - 1);    
		}		
		return input;	
	}
}