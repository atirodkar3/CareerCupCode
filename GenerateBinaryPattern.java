import java.util.ArrayList;
import java.util.Arrays;
class GenerateBinaryPattern {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(allPatterns("10?00?11?").toArray()));
    }

    private static ArrayList<String> allPatterns(String pattern) {
        ArrayList<String> returnPatterns = new ArrayList<String>();
        int questionMarkCount = 0;
        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == '?') {
                questionMarkCount++;
            }
        }

        ArrayList<String> possiblePatterns = binaryPatterns(questionMarkCount);
        for(int possibility = 0; possibility < possiblePatterns.size(); possibility++) {
            String current = possiblePatterns.get(possibility);
            String iterationPattern = pattern;
            for(int i = 0; i < current.length(); i++) {
                iterationPattern = iterationPattern.replaceFirst("\\?", current.substring(i, i + 1));
            }
            returnPatterns.add(iterationPattern);        
        }
        return returnPatterns;
    }

    private static ArrayList<String> binaryPatterns(int size) {
        
        ArrayList<String> returnStrings = new ArrayList<String>();
        ArrayList<String> possibleStrings = new ArrayList<String>();
        possibleStrings.add("");
        for(int i = 0; i < size; i++) { 
            int permutationSize = possibleStrings.size();
            for(int stringCount = 0; stringCount < permutationSize; stringCount++) {
                String current = possibleStrings.get(stringCount);
                if((current.length() + 1) == size) {
                    returnStrings.add("0" + current);
                    returnStrings.add("1" + current);
                } else {
                    possibleStrings.add("0" + current);   
                    possibleStrings.add("1" + current);   
                }  
            }
        }
        return returnStrings;
    }

}
