class TwoSumTwoArrays {

    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 4, 5, 6};
        int[] array2 = new int[]{1, 4, 5, 7, 9};
        
        twoSumTwoArrays(array1, array2, 5);
    }

    private static void twoSumTwoArrays(int[] array1, int[] array2, int keySum) {
        
        int left = 0;
        int right = array2.length - 1;
         
        while(left < array1.length && right > -1) {
            int sum = array1[left] + array2[right];
            if(sum == keySum) {
                System.out.println("Left = " + array1[left] + " Right = " + array2[right]);
                left++;
                right--;
            } else if(sum > keySum) {
                right--;
            } else if(sum < keySum) {
                left++;
            }
        }
    }
}
