package recursion;

public class Recursion {

    //数的全排列问题
    public static void permutation(int[] num, int size, int depth) {
        if (depth == size - 1) {
            System.out.println(num);
            return;
        }else if (depth<size-1){
            for (int i=depth;i<size;i++){
                swap(num,depth,i);
                permutation(num,size,++depth);
                swap(num,depth,i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    /**
//     * lc:46
//     * 数的全排列问题
//     * @param nums
//     * @return
//     */
//    public List<List<Integer>> permute(int[] nums) {
//
//    }

    public static void main (String [] args){
        int [] arr = {1,2,3};
        permutation(arr,arr.length,0);
    }
}
