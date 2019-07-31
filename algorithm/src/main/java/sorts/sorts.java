package sorts;

/**
 * 冒泡   插入  选择
 */
public class sorts {
    //冒泡
    public static void bubbleSort(int[] arr) {
        boolean flag = false;//增加哨兵，标记某次冒泡是否发生交换，如果没有交换则表明已经有序，后面的循环可以不用执行
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    //插入
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            //找到插入位置
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];//把前面的数据移动到后面
                } else {
                    break;
                }
            }
            //插入数据
            arr[j + 1] = value;
        }
    }

    //选择排序
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = min(arr, i);
            //交换
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static int min(int[] arr, int start) {
        int min = start;//该值只能设置为start,不能设置为其他
        for (; start < arr.length; start++) {
            if (arr[start] < arr[min]) {
                min = start;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] arr = {4, 6, 5, 1, 2, 3};
//        bubbleSort(arr);
//        insertionSort(arr);
        selectionSort(arr);
        printAll(arr);

    }

    public static void printAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
