package binary_search;

public class BinarySearch {

    public static int binarySearchByLoop(int[] arr, int num) {
        if (arr == null) return -1;
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] > num) {
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchByRecursion(int[] arr, int p, int r, int num) {
        if (arr==null || p>r) return -1;
        int mid = p+((r-p)>>1);
        if (arr[mid]==num){
            return mid;
        }else if (arr[mid]>num){
            return binarySearchByRecursion(arr,p,mid-1,num);
        }else {
            return binarySearchByRecursion(arr,mid+1,r,num);
        }
    }

    /**
     * 求一个数的平方根
     * @param num 被求解的数
     * @param e  精度
     * @return
     */
    public static double sqrt(int num,double e){
        if (num==1) return 1;
        double low =0;
        double hight = num;
        while (true){
            double mid = low+(hight-low)/2;
            if ((((mid*mid)-num)>=0 && ((mid*mid)-num)<=e) || (((mid*mid)-num)<=0 &&-((mid*mid)-num)<=e)){
                return mid;
            }else if (((mid*mid)-num)>e){
                hight = mid;
            }else if (-((mid*mid)-num)>e){
                low = mid;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
////        int i = binarySearchByLoop(arr, 6);
//        int i = binarySearchByRecursion(arr,0,arr.length-1,7);
//        System.out.println(i);
        System.out.println(sqrt(26,0.000001));
    }

}
