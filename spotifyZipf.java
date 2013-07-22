import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class spotifyZipf {

    public static void main(String[] args) throws IOException {	    
	    ArrayList<ArrayList<String>> inputFile = new ArrayList<ArrayList<String>>();
	    ArrayList<Double> zipfCount = new ArrayList<Double>();
		ArrayList<String> mostPlayedSongs = new ArrayList<String>();
		inputFile = fileReader();
	    
        if(inputFile == null) {
		    System.out.println("Invalid Input");
		} else {
            zipfCount = getZipfCount(inputFile);
			mostPlayedSongs = getMostPlayedSongs(zipfCount, inputFile);
		    printFunction(mostPlayedSongs);
		}		
	}

    public static ArrayList<ArrayList<String>> fileReader() throws IOException {
	    Scanner scanner = new Scanner(System.in);        
		ArrayList<ArrayList<String>> fileContents = new ArrayList<ArrayList<String>>();
	
	    try{				    
            String currentLine = scanner.nextLine();				
            ArrayList<String> fileRow = new ArrayList(Arrays.asList(currentLine.split(" ")));
            fileContents.add(fileRow);
			int numberOfInputLines = Integer.parseInt(fileRow.get(0));
			int numberOfOutputLines = Integer.parseInt(fileRow.get(1));
			if (numberOfInputLines < numberOfOutputLines) {
			    return null;
			}
			
            for (int lineCount = 0; lineCount < numberOfInputLines; lineCount++) {
			    currentLine = scanner.nextLine();				
                fileRow = new ArrayList(Arrays.asList(currentLine.split(" ")));
                fileContents.add(fileRow);			    			
			}            
		} catch(Exception e) { 
            System.out.println("Read Error");		
			return null;
		} finally {
		    scanner.close();
		}	    
		return fileContents;
	}
	
	public static ArrayList<Double> getZipfCount(ArrayList<ArrayList<String>> inputFile) {
	    ArrayList<Double> zipfCount = new ArrayList<Double>();
		int numberOfSongs = Integer.parseInt(inputFile.get(0).get(0));
		long playCountSong1 = Long.parseLong(inputFile.get(1).get(0));
		for (int songNumber = 1; songNumber <= numberOfSongs; songNumber++) {
		    zipfCount.add( (double)(playCountSong1 / (songNumber)) );					
		}				
		return zipfCount;		
	}
	
	public static ArrayList<String> getMostPlayedSongs(ArrayList<Double> zipfCount, ArrayList<ArrayList<String>> inputFile) {
	    int numberOfSongs = Integer.parseInt(inputFile.get(0).get(0));
		
		ArrayList<String> mostPlayedSongs = new ArrayList<String>();
		Map<Double, String> songsBetterThanZipfCount = new TreeMap<Double, String>();
		for (int songNumber = 0; songNumber < numberOfSongs; songNumber++) {
            songsBetterThanZipfCount.put((Double.parseDouble(inputFile.get(songNumber + 1).get(0)) / zipfCount.get(songNumber))  , inputFile.get(songNumber + 1).get(1).trim());                  
		}		
		
		int songCount = 0;
		int topSongThreshold = Integer.parseInt(inputFile.get(0).get(1));
		
		ArrayList<Double> songKey = new ArrayList<Double>(songsBetterThanZipfCount.keySet());
        for(int song = songKey.size() - 1; song > songKey.size() - topSongThreshold - 1; song--) {		    
            mostPlayedSongs.add(songsBetterThanZipfCount.get(songKey.get(song)));
        }		
	
		return mostPlayedSongs;
	}

    public static void printFunction(ArrayList<String> songList) {
        for (int song = 0; song < songList.size(); song++) {
		    System.out.println(songList.get(song));
	    }	
    }	
}