package tree;

import java.util.ArrayList;

/**
 * Created by lilei on 16/7/30.
 */
public class DemoTree {
    private BinaryTree root;

    //构建二叉搜索树 即B树
    public void buildTree(BinaryTree tree, int data) {
        if (root == null) {
            root = new BinaryTree(data);
        } else {
            if (data < tree.data) {
                if (tree.left == null) {
                    tree.left = new BinaryTree(data);
                } else {
                    buildTree(tree.left, data);
                }
            } else {
                if (tree.right == null) {
                    tree.right = new BinaryTree(data);
                } else {
                    buildTree(tree.right, data);
                }
            }
        }

    }

    public int getMax(BinaryTree tree) {
        if (tree == null)
            return -1;

        while (tree.right != null)
            tree = tree.right;
        return tree.data;
    }

    public int getMin(BinaryTree tree) {
        if (tree == null)
            return -1;

        while (tree.left != null)
            tree = tree.left;
        return tree.data;
    }

    //前序遍历
    public static void preOrder(BinaryTree node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //中序遍历
    public static void inOrder(BinaryTree node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + "  ");
            inOrder(node.right);
        }
    }

    //后序遍历
    public static void postOrder(BinaryTree node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + "  ");

        }
    }
    // 求二叉树的深度
    public static int deep(BinaryTree node) {
        int h1, h2;
        if (node == null) {
            return 0;
        } else {
            h1 = deep(node.left);
            h2 = deep(node.right);
            return (h1 < h2) ? h2 + 1 : h1 + 1;
        }
    }

    //广度遍历
    public static void widthSearch(BinaryTree node) {
        ArrayList<BinaryTree> lists = new ArrayList<BinaryTree>();
        lists.add(node);
        while (!lists.isEmpty()) {
            BinaryTree tree = lists.get(0);
            System.out.print(lists.get(0).data + " ");

            lists.remove(0);
            if (tree.left != null) {
                lists.add(tree.left);
            }
            if (tree.right != null) {
                lists.add(tree.right);
            }
        }

    }


    public static void main(String args[]) {
        int[] a = {3, 1, 2, 5, 0, 7, 9, 8};
        DemoTree bTree = new DemoTree();
//        BinaryTree tree1 = new BinaryTree(1);
//        BinaryTree tree2 = new BinaryTree(2);
//        BinaryTree tree3 = new BinaryTree(3);
//        BinaryTree tree4 = new BinaryTree(4);
//        BinaryTree tree5 = new BinaryTree(5);
//        BinaryTree tree6 = new BinaryTree(6);
//        BinaryTree tree7 = new BinaryTree(7);
//        tree1.left = tree2;
//        tree1.right = tree3;
//        tree2.left = tree4;
//        tree2.right = tree5;
//        tree3.left = tree6;
//        tree3.right = tree7;
//        bTree.root = tree1;
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }
        System.out.print(bTree.getMax(bTree.root) + ":" + bTree.getMin(bTree.root));
//        preOrder(bTree.root);
//        System.out.println("");
//        inOrder(bTree.root);
//        System.out.println("");
//        postOrder(bTree.root);
//        widthSearch(bTree.root);
    }
    //二叉查找树
}

class BinaryTree {
    public int data;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

}

