class IntegerTest{

    private static void intAdd(Integer a) {
        a++;
    }

    public static void main(String[] args) {
        Integer a = new Integer(4);
        intAdd(a);
        System.out.println(a);
    }

}
