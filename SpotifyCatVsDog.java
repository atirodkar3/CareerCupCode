import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class SpotifyCatVsDog {
    
	public static void main(String[] args) {
	    ArrayList<Integer> output = new ArrayList<Integer>();
	 
	    Kattio io = new Kattio(System.in, System.out); 
		int numberOfTestCases = io.getInt();
		
		for(int testCase = 0; testCase < numberOfTestCases; testCase++) {
		    int total = 0;
			long numCats = io.getInt();
			int numDogs = io.getInt();
			int numVoters = io.getInt();
			ArrayList<Vote> catVotes = new ArrayList<Vote>();
			ArrayList<Vote> dogVotes = new ArrayList<Vote>();
			
			int catVoter = 0;
			int dogVoter = 0;

			for(int vote = 0; vote < numVoters; vote++) {
			    String winner = io.getWord();				
				String loser = io.getWord();				
				
				if(winner.substring(0,1).equals("C")) {
				    catVotes.add(new Vote(winner, loser));
				} else if(winner.substring(0,1).equals("D")) {
				    dogVotes.add(new Vote(winner, loser));
				}				
			}
			
            for(int catVote = 0; catVote < catVotes.size(); catVote++) {
                Vote currentCatVote = catVotes.get(catVote);
                for(int dogVote = 0; dogVote < dogVotes.size(); dogVote++) {
                    Vote currentDogVote = dogVotes.get(dogVote);

					if(currentCatVote.remove.equals(currentDogVote.keep) || currentCatVote.keep.equals(currentDogVote.remove)) {
                        if(!catVotes.get(catVote).badVotes.contains(currentDogVote)) { 
                            catVotes.get(catVote).badVotes.add(currentDogVote);
                        }					    						
                    }				
			    }
			}

            for(int catVote = 0; catVote < catVotes.size(); catVote++) {                
                for(int dogVote = 0; dogVote < dogVotes.size(); dogVote++) {                    
    				dogVotes.get(dogVote).linkSet = false;
				}
				
				if(createLinkCycles(catVotes.get(catVote), 0) == 1) {
                    total++;
                }				
			}
			output.add(numVoters - total);
		}			
        
		for(int outVal = 0; outVal < output.size(); outVal++) {
		    System.out.println(output.get(outVal));		
		}
	}

	private static int createLinkCycles(Vote catVote, int type) {
	    int thisTotal = 0;
	    for(int vote = 0; vote < catVote.badVotes.size(); vote++) {
		    if(!catVote.badVotes.get(vote).linkSet) {
			    catVote.badVotes.get(vote).linkSet = true;
							
			    if(catVote.badVotes.get(vote).link == null || createLinkCycles(catVote.badVotes.get(vote).link, 1) == 1) {
			        catVote.link = catVote.badVotes.get(vote);
                    catVote.badVotes.get(vote).link = catVote;							
    			    return 1;
			    }
		    }
		}	
		return 0;
	}
	
	static class Vote {
    	
		String keep;
		String remove;
        boolean linkSet;
        Vote link;		
		ArrayList<Vote> badVotes;
		
		public Vote(String keep, String remove) {
     		this.keep = keep;
			this.remove = remove;
			this.badVotes = new ArrayList<Vote>();
			this.linkSet = false;
			this.link = null;
		}		
		
		public String toString() {
		    return this.keep + " - " + this.remove;
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

		public double getDuble() {
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