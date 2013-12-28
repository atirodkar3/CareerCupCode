import java.util.LinkedList;

public class KnightsTour {
    public static void main(String[] args) {
        Knight k = new Knight(8);
    }
}

class Table {
    public static int[][] table;
    int length;
    public Table(int userLength) {
        length = userLength;
        table = new int[length][length];
    }

    public void setTable(Position p ,int value) {
        int i = p.getX();
        int j = p.getY(); 
        if(i - 1 > table.length || i - 1 < 0 || j - 1 > table.length || j - 1 < 0) {
            System.out.println("Position " + i + " " + j + " Invalid");
        } else {
            table[i - 1][j - 1] = value;
            //System.out.println("Position " + i + " " + j + " Set");
        }
    }

    public int getTableValue(Position p) {
        return (table[p.getX() - 1][p.getY() - 1]);
    }

    public void displayTable() {
        for(int rowNum = 0; rowNum < length; rowNum++) {
            System.out.println();
            for(int colNum = 0; colNum < length; colNum++) {
                System.out.print(" " + table[rowNum][colNum] + " ");
            }
        }
        System.out.println();
    }

    public int getTableLength() {
        return length;
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x; 
    }

    public int getY() {
        return y;
    }
}

class Knight {
    private Position startPos;
    public Knight(int length) {
        Table bestTable = null;
        int bestVal = 0;        
        for(int testNum = 0; testNum < 10000001; testNum++) {
            Table table = new Table(length);
            int startX = 1 + (int)(Math.random() * ((length) - 1));
            int startY = 1 + (int)(Math.random() * ((length) - 1));
            startPos = new Position(startX, startY);
            int iterVal = iterateTour(table, startPos);
            if(iterVal > bestVal) {
                table.displayTable();
                bestTable = table;
                bestVal = iterVal;
            }
        }
        System.out.println(bestVal);
    }

    public int iterateTour(Table table, Position startPos) {
        Position newP = startPos;
        int iteration = 1;
        //System.out.println(newP.getX() + " " + newP.getY());
        while(newP != null) {
            table.setTable(newP, iteration++);
            //System.out.println("Start Position Set at " + newP.getX() + " " + newP.getY());
            newP = getNextPosition(newP, table);
        }
        return iteration;   
    }

    private Position getNextPosition(Position currentPosition, Table table) {
        int x = currentPosition.getX();
        int y = currentPosition.getY();

        LinkedList<Position> possiblePositions = getListOfPossiblePositions(x, y, table);        
        return decidePosition(possiblePositions);
    }

    private Position decidePosition(LinkedList<Position> openPositions) {
        // Define Algorithm

        if(openPositions.size() == 0) {
            return null;
        } else {
            int pos = (int)(Math.random() * (openPositions.size()));
            return openPositions.get(pos);
        }
    }

    private LinkedList<Position> getListOfPossiblePositions(int x, int y, Table table) {
        int length = table.getTableLength();
        LinkedList<Position> openSpots = new LinkedList<Position>();
        openSpots.add(new Position(x - 2, y + 1));
        openSpots.add(new Position(x - 2, y - 1));
        openSpots.add(new Position(x + 2, y + 1));
        openSpots.add(new Position(x + 2, y - 1));
        openSpots.add(new Position(x + 1, y + 2));
        openSpots.add(new Position(x + 1, y - 2));
        openSpots.add(new Position(x - 1, y + 2));
        openSpots.add(new Position(x - 1, y - 2));
        
        int iterator = 0;
        while(iterator < openSpots.size()) {
            Position posIteration = openSpots.get(iterator);
            int posX = posIteration.getX();
            int posY = posIteration.getY();
            
            if(posX < 1 || posX > length || posY < 1 || posY > length) {
                openSpots.remove(iterator);
            } else { 
                if (table.getTableValue(posIteration) != 0) {
                    openSpots.remove(iterator);  
                } else {
                    iterator++;
                }
            }
        }
        return openSpots;
    }
}
