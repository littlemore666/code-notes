package binatytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author mochenghui
 * @date 2019/6/24 15:38
 */
public class BinaryTree {
    /**
     * 前序遍历
     *
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.value);
        inOrder(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.value);
    }

    /**
     * lc:102
     * 层次遍历
     * 借助队列实现，把元素放进队列，然后取出打印，然后把该节点的左右子树依次放进队列，重复此操作,后面可优化
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> thisLevel = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            thisLevel.offer(queue.poll());
            if (queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                while (!thisLevel.isEmpty()) {
                    TreeNode node = thisLevel.poll();
                    list.add(node.value);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    /**
     * lc:104 & 450
     */

}
