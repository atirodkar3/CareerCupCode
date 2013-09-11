class Fibonacci {

    public static void main(String[] args) {
        System.out.println(iterativeFibonacci(6));
        System.out.println(recursiveFibonacci(6));
    }

    // 0 1 1 2 3 5 8 13 21 34 
    private static int iterativeFibonacci(int position) {
        int previous = 0;
        int current = 1;

        for(int count = 2; count <= position; count++) {
            int temp = current + previous;
            previous = current;
            current = temp;
        }
        return current;
    }

    private static int recursiveFibonacci(int position) {
        if(position < 2) {
            return position;
        } else {
            return recursiveFibonacci(position - 1) + recursiveFibonacci(position - 2);
        }
    }
}
