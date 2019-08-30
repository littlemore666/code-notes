package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * lc:51
 *
 * @author mochenghui
 * @date 2019/8/30 11:08
 */
public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        int[][] arr = new int[n][n];
        List<List<String>> list = new ArrayList<>();
        solve(0, 0, arr, n, list);
        return list;
    }

    public static void solve(int x, int y, int[][] arr, int n, List<List<String>> list) {

        //整理结果
        if (x >= n) list.add(getResult(arr));

        for (int i = x; i < arr.length; i++) {
            for (int j = y; j < arr[i].length; j++) {
                if (isOk(arr, i, j, n)) {
                    arr[i][j] = 1;
                    solve(i + 1, 0, arr, n, list);//下一行
                    arr[i][j] = 0;//清除数据重新选择摆放位置
                }
                if (j==arr[i].length-1) return;//此处是为了让函数回退到上一次递归处去执行：arr[i][j] = 0;
            }
        }

    }

    public static boolean isOk(int[][] arr, int i, int j, int n) {

        //水平
        for (int x = 0; x < n; x++) {
            if (arr[i][x] == 1) return false;
        }

        //垂直
        for (int y = 0; y < n; y++) {
            if (arr[y][j] == 1) return false;
        }

        //左上右下
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
            if (arr[x][y] == 1) return false;
        }
        for (int x = i + 1, y = j + 1; x < n && y < n; x++, y++) {
            if (arr[x][y] == 1) return false;
        }

        //右上左下
        for (int x = i - 1, y = j + 1; x >= 0 && y < n; x--, y++) {
            if (arr[x][y] == 1) return false;
        }
        for (int x = i + 1, y = j - 1; x < n && y >= 0; x++, y--) {
            if (arr[x][y] == 1) return false;
        }
        return true;
    }

    public static List<String> getResult(int[][] arr) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String row = "";
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    row = row + "Q";
                }else {
                    row = row+".";
                }
            }
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new NQueen().solveNQueens(4);
        System.out.println(lists.toString());
        System.out.println(lists.size());
    }

}
