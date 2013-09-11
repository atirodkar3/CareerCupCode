class SquareRoot {

    public static void main(String[] args) {
        System.out.println(rahsonSquareRoot(25));
        System.out.println(rahsonSquareRoot(2));
    }

    private static double rahsonSquareRoot(int squaredNumber) {
        double doubleSquaredNumber = (double)squaredNumber;
        double base = doubleSquaredNumber;
        double currRoot = 0.5  * (base + (doubleSquaredNumber / base));

        while(base != currRoot) {
            base = currRoot;
            currRoot = 0.5 * (base + (doubleSquaredNumber / base));
        }
        
        return currRoot;
    }
}
