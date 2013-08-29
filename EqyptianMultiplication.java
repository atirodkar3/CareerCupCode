class EgyptianMultiplication {

    public static void main(String[] args) {
        System.out.println(multiply(17, 6));
        System.out.println(multiply(0, 6));
        System.out.println(multiply(2, -6));
    }

    private static int multiply(int left, int right) {
    	int product = 0;
        while(left > 0) {
            if(left % 2 == 1){
                product = product + right;
            }
            left = left>>1;
            right = right<<1;
        }
        return product;           
    }
}
