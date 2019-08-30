package backtracking;

/**
 * 背包总的承载重量是 Wkg,有 n 个物品，每个物品的重量不等，并且不可分割
 * 在不超过背包所能装载重量的前提下，背包中可装的最大重量是多少
 *
 * @author mochenghui
 * @date 2019/8/30 16:27
 */
public class _01Backpack {

    static int maxW = Integer.MIN_VALUE;

    /**
     * @param i     考察到第几个物品
     * @param cw    装载的重量
     * @param items 物品重量，下标为物品编号，值为重量
     * @param n     物品总个数
     * @param w     背包可承受重量
     */
    public static void f(int i, int cw, int[] items, int n, int w) {

        if (i >= n || cw == w) {
            if (cw > maxW) maxW = cw;
            return;
        }

        f(i + 1, cw, items, n, w);//不装
        if (cw + items[i] <= w) {//满足前提才装
            f(i + 1, cw + items[i], items, n, w);//装
        }
    }

    public static void main(String[] args) {
        int[] items = {2, 2, 4, 6, 3};
        f(0, 0, items, items.length, 9);
        System.out.println(maxW);
    }

}
