import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class HandOfCards {
    
	public static void main(String[] args) {
	    ArrayList<Card> initializedPackOfCards = initialize();
	    shuffle(initializedPackOfCards);
	}
	
	private static ArrayList<Card> initialize() {
	    String[] suits = new String[]{"Clubs", "Spades", "Hearts", "Diamonds"};
		ArrayList<Card> cardDeck = new ArrayList<Card>();
		
		for(int suit = 0; suit < suits.length; suit++) {
		    for(int number = 1; number < 13; number++) {			
			    String cardValue = getCardValue(number);
			    cardDeck.add(new Card(suits[suit], cardValue));			    
			}					
		}
        return cardDeck;		
	}

	private static String getCardValue(int number) {
	    if(CardMetadata.SPECIAL_CARDS.containsKey(number)) {
		    return CardMetadata.SPECIAL_CARDS.get(number);		    
		} else {
		    return "" + number;
		}	
	}

	private static void printCards(ArrayList<Card> cards) {
	    System.out.println(":::::::::::::::::::::::: Card Values ::::::::::::::::::::::::");
		for(int card = 0; card < cards.size(); card++) {
		    System.out.println(cards.get(card).suit + " " + cards.get(card).value);
		}
	}

	private static void shuffle(ArrayList<Card> cards) {
	    int initialDeckSize = cards.size();
		ArrayList<Card> shuffledCards = new ArrayList<Card>();
		
		for(int i = 0; i < initialDeckSize; i++) {
		    int indexOfCardObtained = (int)(Math.random() * 10000) % cards.size();
			shuffledCards.add( cards.get(indexOfCardObtained) );
			cards.remove(indexOfCardObtained);
		}
		
		printCards(shuffledCards);
	}
}

class Card {
    String suit;
	String value;
    
	public Card(String suit, String value) {
	    this.suit = suit;
		this.value = value;	
	}
}

class CardMetadata {
    public static final HashMap<Integer, String> SPECIAL_CARDS = new HashMap<Integer, String>();
	static {
	    SPECIAL_CARDS.put(1, "Ace");
        SPECIAL_CARDS.put(10, "Jack");
	    SPECIAL_CARDS.put(11, "Queen");
	    SPECIAL_CARDS.put(12, "King");
	}
}