import java.util.Arrays;

class SpiralPrint {

    public static void main(String[] args) {
        int[][] oddInput = new int[][]{{ 1,  2,  3,  4, 5},
                                       {16, 17, 18, 19, 6},
                                       {15, 24, 25, 20, 7},
                                       {14, 23, 22, 21, 8},
                                       {13, 12, 11, 10, 9}};
        int[][] evenInput = new int[][]{{ 1,  2,  3, 4},
                                        {12, 13, 14, 5},
                                        {11, 16, 15, 6},
                                        {10,  9,  8, 7}};
        printSpiral(oddInput);
        printSpiral(evenInput);
    }

    private static void printSpiral(int[][] input) {
        

        if(input.length != input[0].length) {
            return;
        }

        int[] printArray = new int[input.length * input.length];
        int printCounter = 0;    

        int size = input[0].length;
        int numIterations = size / 2;
        int bias = 0;
       
        int loop1Row = 0;
        int loop2Column = size - 1;
        int loop3Row = size - 1;
        int loop4Column = 0;

        for(int iteration = 0; iteration < numIterations; iteration++) {
        
            //Horizontal Left to Right
            for(int i = 0 + bias; i < size - 1 - bias; i++) {
                printArray[printCounter++] = input[loop1Row][i];
            }
 
            // Vertical Right to Left
            for(int i = 0 + bias ; i < size - 1 - bias; i++) {
                printArray[printCounter++] = input[i][loop2Column];
            }

            // Horizontal Right to Left
            for(int i = size - 1 - bias ; i > 0 + bias; i--) {
                printArray[printCounter++] = input[loop3Row][i];
            }

            // Vertical Left To Right
            for(int i = size - 1 - bias; i > 0 + bias; i--) {
                printArray[printCounter++] = input[i][loop4Column];
            }

            if( (size % 2) == 1) {
                printArray[printCounter] = input[numIterations][numIterations];
            } 

            loop1Row++;
            loop2Column--;
            loop3Row--;
            loop4Column++;
            bias++;
        }   
        System.out.println(Arrays.toString(printArray));
    }
}
