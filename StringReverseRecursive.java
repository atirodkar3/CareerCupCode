class StringReverseRecursive {

    public static void main(String[] args) {
        System.out.println(stringReverse("abcdefgh"));
    }

    private static String stringReverse(String str) {
        if(str == null || str.length() <= 1) {
            return str;   
        } else {
            
            return stringReverse(str.substring(1, str.length())) + (str.charAt(0));
        }
    }
}
