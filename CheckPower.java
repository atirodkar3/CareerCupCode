class CheckPower {
    public static void main(String[] args) {
        System.out.println(checkPower(30 ,3));
        System.out.println(checkPower(3, 1));
    }

    private static boolean checkPower(int num, int base) {
        return (Math.log(num) / Math.log(base)) % 1 == 0;
    }

}
