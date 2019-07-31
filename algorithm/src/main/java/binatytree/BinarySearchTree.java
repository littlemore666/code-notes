package binatytree;

/**
 * @author mochenghui
 * @date 2019/6/24 17:27
 */
public class BinarySearchTree {

    /**
     * 二叉树查找
     *
     * @param value
     * @return
     */
    public static TreeNode find(TreeNode root, int value) {
        if (root == null) return null;
        TreeNode p = root;
        while (p != null) {
            if (p.value == value) {
                return p;
            } else if (p.value > value) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 二叉树的插入操作
     */
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        TreeNode p = root;
        while (p != null) {
            if (p.value <= value) {
                if (p.right == null) {
                    p.right = new TreeNode(value);
                    return p;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(value);
                    return p;
                }
                p = p.left;
            }
        }
        return root;
    }

    /**
     * lc:450
     * 二叉搜索树删除操作
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        //先找到要删除的节点，及其父节点
        TreeNode pp = null;//记录父节点
        TreeNode p = root;//需要删除的节点
        while (p != null && p.value != key) {
            pp = p;
            if (p.value > key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        //没有要删除的节点
        if (p == null) return root;

        //如果该节点有左右两个子节点，则找到该节点右子树的最小节点，替代该节点
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            //替换节点
            p.value = minP.value;
            //下面变成删除minp节点，统一处理
            p = minP;
            pp = minPP;
        }

        //如果该节点是叶子节点或者只有一个子节点
        TreeNode child;//p的父节点把原来指向p的指针指向p的子节点就完成这种情况的删除
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        //删除
        if (pp == null) {//放在第一个判断，防止出现空指针
            //根节点的删除
            root = child;
        } else if (pp.right == p) {
            pp.right = child;
        } else if (pp.left == p) {
            pp.left = child;
        }

        return root;
    }

    /**
     * lc:104
     * 求二叉查找树的最大深度
     * 递归：退出条件：root==null
     *      递推公式：depth(root)=max(depth(root.left),depth(root.right))+1
     */
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
