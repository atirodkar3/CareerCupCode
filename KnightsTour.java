public class KnightsTour {
    public static void main(String[] args) {
        Table table = new Table(8);
        table.setTable(4,4,1);
        table.setTable(18,2,1);
        table.displayTable();
    }
}

class Table {
    public static int[][] table;
    int length;
    public Table(int userLength) {
        length = userLength;
        table = new int[length][length];
    }

    public void setTable(int i, int j,int value) {
        if(i - 1 > table.length || i - 1 < 0 || j - 1 > table.length || j - 1 < 0) {
            System.out.println("Position " + i + " " + j + " Invalid");
        } else {
            table[i - 1][j - 1] = value;
            System.out.println("Position " + i + " " + j + " Set");
        }
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
}
