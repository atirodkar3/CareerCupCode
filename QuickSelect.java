class QuickSelect {

    public static void main(String[] args) {
        int[] input = {1, 4, 11, 2, 44, 6};
        //System.out.println(selectKth(input, 1));        

        stringPermutations("110");
    }

public static int selectKth(int[] arr, int k) {
 if (arr == null || arr.length <= k)
  throw new Error();
 
 int from = 0, to = arr.length - 1;
 
 // if from == to we reached the kth element
 while (from < to) {
  int r = from, w = to;
  int mid = arr[(r + w) / 2];
 
  // stop if the reader and writer meets
  while (r < w) {
 
   if (arr[r] >= mid) { // put the large values at the end
    int tmp = arr[w];
    arr[w] = arr[r];
    arr[r] = tmp;
    w--;
   } else { // the value is smaller than the pivot, skip
    r++;
   }
  }
 
  // if we stepped up (r++) we need to step one down
  if (arr[r] > mid)
   r--;
 
  // the r pointer is on the end of the first k elements
  if (k <= r) {
   to = r;
  } else {
   from = r + 1;
  }
 }
 
 return arr[k];
}
    private static void stringPermutations(String input) {
        permute("", input);
    }

    private static void permute(String prefix, String input) {
        if(input.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i =0; i < input.length(); i++) {
                permute(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));
            }
        }
    }
}
