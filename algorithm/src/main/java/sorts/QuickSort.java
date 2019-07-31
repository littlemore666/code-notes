package sorts;

public class QuickSort {
    /**
     * 在O(n)内找到第K小的元素
     *
     * @param arr
     * @param k
     * @return
     */
    public static int getTopK(int[] arr, int p, int r, int k) {
        if (arr.length<=0||arr==null||arr.length<k)return  -1;
        int q = partition(arr,p,r);
        while (q!=k-1){
            if (q<k-1){
                q=partition(arr,q+1,r);
            }else {
                q=partition(arr,p,q-1);
            }
        }
        return arr[q];
    }

    /**
     * 快排
     * @param arr
     * @param p
     * @param r
     */
    public static void quickSort(int[] arr, int p, int r) {
        if (p >= r) return;

        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int i = p;//不能置为0
        int j = p;//不能置为0
        int pivot = arr[r];

        for (; j <= r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;
    }


    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 1, 2, 3};
//        quickSort(arr, 0, arr.length - 1);
//        printAll(arr);
        int topK = getTopK(arr, 0, arr.length - 1, 7);
        System.out.println(topK);
    }

    public static void printAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
