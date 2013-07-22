import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class spotifyZipf {
	static ArrayList<ArrayList<String>> inputFile = new ArrayList<ArrayList<String>>();	    
    public static void main(String[] args) throws IOException {	    	
        Kattio io = new Kattio(System.in, System.out);    
        int songCount = io.getInt();
		int threshold = io.getInt();
		
		Row[] arrayOfSongs = new Row[songCount];

		for (int songNumber = 0; songNumber < songCount; songNumber++) {
		    long playCount = io.getLong();
			String songName = io.getWord();
		    double quality = playCount * (songNumber + 1);
		    arrayOfSongs[songNumber] = new Row(quality, songNumber, songName);
		}		
		
		Arrays.sort(arrayOfSongs);
		for(int topSong = arrayOfSongs.length - 1; topSong > songCount - threshold - 1; topSong--) {
		    io.println(arrayOfSongs[topSong].songName);			
		}
		io.close();
	}

	static class Row implements Comparable<Row> {
	    double quality;
		long songNumber;
		String songName;
		
		Row(double quality, long songNumber, String songName) {
		    this.quality = quality; 
		    this.songNumber = songNumber;
			this.songName = songName;
		}
		
		public int compareTo(Row row) {
            if(quality > row.quality) 
				return 1;
			else if (quality == row.quality) 
			    if(songNumber < row.songNumber) {
				    return 1;
				} else {
				    return -1;
				}
            else {
                return -1;
            }			
		}
	}

	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() {
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}

		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null)
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null)
							return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) {
				}
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}	
}