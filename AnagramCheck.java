import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

class AnagramCheck {

    public static void main(String[] args){
        String[] input = new String[]{"ram", "test", "arm", "protest", "prootest", "testpro", "cc", "bd"};
      
        HashMap<Integer, ArrayList<String>> wordList = new HashMap<Integer, ArrayList<String>>();
        for(int i = 0; i < input.length; i++) {
            int asciiValue = 0;
            for (int alphabet = 0; alphabet < input[i].length(); alphabet++) {
                asciiValue += Math.pow( (int)input[i].charAt(alphabet), 2);
            }            
            asciiValue += asciiValue * input[i].length();
            if(wordList.get(asciiValue) == null) {
            	ArrayList<String> initialise = new ArrayList<String>();
            	initialise.add(input[i]);
                wordList.put(asciiValue, initialise);
            } else {
                wordList.get(asciiValue).add(input[i]);
            }
        }
    
        for(int i : wordList.keySet()) {
            if(wordList.get(i).size() > 1) {
               	System.out.println(Arrays.deepToString(wordList.get(i).toArray()));
            }
        }
    }
}
