class StringInPlaceReverse {

    public static void main(String[] args) {
        String testString = "abcdefg"; //Reverse Alphabets
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "This Is A Test"; // Plain Test
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "\nThIs_iS_a_TeSt"; // Adding a New Line Character at start of String. 
                                         // This character should now be at the end of the String.
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = ""; //Empty String
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "a"; //Test with Single Letter
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "TestWithLarge                    Space"; // String with a space in the middle
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "This$$Test///Has###Special-+Characters"; // String with Special Characters
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = " this test has spaces in front and back "; // String with starting and ending spaces
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "ablewasiisawelba"; //Palindrome
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        testString = "aaaaa"; // Duplicate Characters
        System.out.println("Original String: " + testString  + " Reverse: " +  reverseString(testString));
        
    }
	
    private static String reverseString(String input) {
        int insertPosition = 0;
        for(int i = 0; i < input.length(); i++) { 
            input = new StringBuilder(input.substring(0, i)).append(input.substring(input.length() - 1, input.length())).append(input.substring(i, input.length() - 1)).toString();    
	}		
        return input;	
    }
}
