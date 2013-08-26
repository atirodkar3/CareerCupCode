class AddBitwise {

    public static void main(String[] args) {
        System.out.println(add(5, 6));
        System.out.println(add(5, -1));
        System.out.println(add(0, 2));
    }

    private static int add(int a, int b) {
        if(b == 0) {
            return a;
        }

        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

}
