class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] array = new int[]{7, 8, 11, 4, 5, 6, 6, 7};
        System.out.println(searchInRotatedArray(array, 5));
        System.out.println(searchInRotatedArray(array, 15));
    }

    private static boolean searchInRotatedArray(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while(left <= right) {
            
            int mid = (left + right) / 2;
            if(array[mid] == key) {
                return true;
            }
            if(array[left] <= array[mid]) {
                if(array[left] <= key && key < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(key <=  array[right] && key > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
