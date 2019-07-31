package binary_search;

/**
 * 查找第一个值等于给定值的元素
 * 查找最后一个值等于给定值的元素
 * 查找第一个大于等于给定值的元素
 * 查找最后一个小于等于给定值的元素
 */
public class TransBinarySearch {

    //查找第一个值等于给定值的元素
    public static int bs1(int[] arr, int num) {
        if (arr == null) return -1;
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] > num) {
                hight = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != num) {
                    return mid;
                } else {
                    hight = mid - 1;
                }
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    public static int bs2(int[] arr, int num) {
        if (arr == null) return -1;
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] < num) {
                low = mid + 1;
            } else if (arr[mid] > num) {
                hight = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != num) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    //查找第一个大于等于给定值的元素
    public static int bs3(int[] arr, int num) {
        if (arr == null) return -1;
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] >= num) {
                if (mid == 0 || arr[mid - 1] < num) {
                    return mid;
                } else {
                    hight = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    public static int bs4(int[] arr, int num) {
        if (arr == null) return -1;
        int low = 0;
        int hight = arr.length - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] <= num) {
                if (mid == arr.length - 1 || arr[mid + 1] > num) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    //循环有序数组中查找指定值
    //时间复杂度O(logn),空间复杂度O（1）
    public static int bs5(int[] arr, int num) {
        if (arr==null || arr.length<=0) return -1;
        int low = 0;
        int hight = arr.length - 1;
        //分界点
        int pivot = 0;
        //先二分查找分界点，O(logn)
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (arr[mid] >= arr[low]) {
                if (mid == arr.length-1 || arr[mid] > arr[mid + 1]) {
                    pivot = mid;
                    break;
                } else {
                    low = mid + 1;
                }
            } else {
                hight = mid;
            }
        }
        //找到分界点后再在各个区间二分查找给定值，O(logn)，注意边界条件
        if (num >= arr[0] && num <= arr[pivot]) {
            int low1 = 0;
            int hight1 = pivot;
            while (low1<=hight1){
                int mid1 = low1+((hight1-low1)>>1);
                if (arr[mid1]==num){
                    return mid1;
                }else if (arr[mid1]>num){
                    hight1 = mid1-1;
                }else {
                    low1=mid1+1;
                }
            }
        //需要判断pivot是否为最后一个下标
        } else if (pivot!=arr.length-1 && num >= arr[pivot+1] && num <= arr[arr.length - 1]) {
            int low1 = pivot+1;
            int hight1 = arr.length-1;
            while (low1<=hight1){
                int mid1 = low1+((hight1-low1)>>1);
                if (arr[mid1]==num){
                    return mid1;
                }else if (arr[mid1]>num){
                    hight1 = mid1-1;
                }else {
                    low1=mid1+1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
////        int[] arr = {4};
//        HashMap<String,String> map  = new HashMap(1000);
//        map.put("abc","abc");
////        System.out.println(bs5(arr, 9));

    }
}
