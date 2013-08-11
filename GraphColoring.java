import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

class GraphColoring {

    public static void main(String[] args) {
	    ArrayList<Node> inputCondition = inputs();
        HashMap<String, ArrayList<String>> colorMap = colors();
		HashMap<String, ArrayList<String>> colors = graphColoring(colorMap, inputCondition);
		printFunction(colors);
	}

	private static HashMap<String, ArrayList<String>> colors() {
	    HashMap<String, ArrayList<String>> colorMap = new HashMap<String, ArrayList<String>>();

		ArrayList<String> colorList = new ArrayList<String>();
        colorList.add("Red");		
        colorList.add("Blue");		
		colorList.add("Green");		
		//Add Color Here
		
        colorMap.put("Colors", colorList);
        colorMap.put("Red", new ArrayList<String>());
    	colorMap.put("Blue", new ArrayList<String>());
		colorMap.put("Green", new ArrayList<String>());
		//Add Color Here
        
		return colorMap;
	}
	
	private static ArrayList<Node> inputs() {
	    ArrayList<Node> inputStates = new ArrayList<Node>();
		inputStates.add(new Node("a", new String[]{"b", "c", "e", "g"}));
		inputStates.add(new Node("b", new String[]{"a", "c"}));
		inputStates.add(new Node("c", new String[]{"a", "d"}));
		inputStates.add(new Node("d", new String[]{"c", "e"}));
		inputStates.add(new Node("e", new String[]{"a", "d", "g", "f"}));
        inputStates.add(new Node("f", new String[]{"e"}));
		inputStates.add(new Node("g", new String[]{"a", "e"}));
		
		return inputStates;
	}
	
	private static HashMap<String, ArrayList<String>> graphColoring(HashMap<String, ArrayList<String>> colors, ArrayList<Node> inputStates) {
	    Collections.sort(inputStates, Collections.reverseOrder());   
        ArrayList<Node> notInsertedStates = new ArrayList<Node>();
		
		ArrayList<String> colorList = colors.get("Colors");
        
        int colorIndex = 0;
        for(int node = 0; node < inputStates.size(); node++) {
		    boolean canInsert = true;    
            String currentColor = colorList.get(colorIndex);
			Node currentNode = inputStates.get(node); 
            for(int neighbour = 0; neighbour < currentNode.borderingNodes.length; neighbour++) { 
                String currentNeighbour = currentNode.borderingNodes[neighbour];			    
                if(colors.get(colorList.get(colorIndex)).contains(currentNeighbour)) { 
                    notInsertedStates.add(inputStates.get(node)); 
					canInsert = false;
					break;
                }				
            }			
			
			if(canInsert) { 
			    colors.get(colorList.get(colorIndex)).add(currentNode.nodeName);
			}
			colorIndex++;
			if(colorIndex == colorList.size()) {
			    colorIndex = 0;
			}
        }				
		
		for(int node = 0; node < notInsertedStates.size(); node++) { 
            boolean insertSuccess = false;			
    		for(int color = 0; color < colorList.size(); color++) {
			    for(int borderNode = 0; borderNode < notInsertedStates.get(node).borderingNodes.length; borderNode++) {
				    String currentBorderNode = notInsertedStates.get(node).borderingNodes[borderNode];
					if(!colors.get(colorList.get(color)).contains(currentBorderNode)) {                        
					    insertSuccess = true;					    
                    } else {
                        insertSuccess = false;
                        break;					    
                    }					
				}
				
				if(insertSuccess) {
				    colors.get(colorList.get(color)).add(notInsertedStates.get(node).nodeName);
					color = colorList.size();					
				}
				
			}			
			
			if(!insertSuccess) {
			    System.out.println("Node Error for node " + notInsertedStates.get(node).nodeName);
			}
		}
		
		return colors;
	}
	
	private static void printFunction(HashMap<String, ArrayList<String>> colors) {
	    ArrayList<String> colorList = colors.get("Colors");
		
		for(int i = 0; i < colorList.size(); i++) {
		    System.out.println("Nodes Colored " + colorList.get(i) + " are: " + Arrays.deepToString(colors.get(colorList.get(i)).toArray()));
		}
	}
	
    static class Node  implements Comparable<Node> {
        String nodeName;
		String[] borderingNodes;

        public Node(String nodeName, String[] borderingNodes) {
            this.nodeName = nodeName;
			this.borderingNodes = borderingNodes;
        }		
		
		public int compareTo(Node node) {
		    if(borderingNodes.length > node.borderingNodes.length) {
			    return 1;			
			}
			
			if(borderingNodes.length == node.borderingNodes.length) {
			    return 0;			
			}
			
			if(borderingNodes.length < node.borderingNodes.length) {
			    return -1;			
			}
			
			return 0;
		}
    }
}