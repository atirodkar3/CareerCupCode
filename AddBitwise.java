class AddBitwise {

    public static void main(String[] args) {
        System.out.println(add(5, 6));
        System.out.println(add(5, -1));
        System.out.println(add(0, 2));
    }

    private static int add(int sum, int carry) {
        if(carry == 0) {
            return sum;
        }

        sum = sum ^ carry;
        carry = (sum & carry) << 1;
        return add(sum, carry);
    }

}
