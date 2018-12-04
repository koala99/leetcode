package tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilei on 2017/7/10.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeTest {

    //637. Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        ArrayList<TreeNode> lists = new ArrayList<TreeNode>();
        lists.add(root);
        while (!lists.isEmpty()) {
            int num = lists.size();
            TreeNode tree;
            double val = 0;
            for (int i = 0; i < num; i++) {
                tree = lists.get(0);
                lists.remove(0);
                val += tree.val;
                if (tree.left != null) {
                    lists.add(tree.left);
                }
                if (tree.right != null) {
                    lists.add(tree.right);
                }
            }
            list.add(val / num);
        }
        return list;
    }

    //617. Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t1 != null && t2 == null) {
            return t1;
        }
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
        }
        return t1;
    }

    //606. Construct String from Binary Tree
    public String str = "";

    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        preOrder(t);
        return str;
    }

    public void preOrder(TreeNode node) {
        if (node == null)
            return;
        str = str + node.val;
        if (node.left != null || node.right != null) {
            str += '(';
            preOrder(node.left);
            str += ')';
            if (node.right != null) {
                str += '(';
                preOrder(node.right);
                str += ')';
            }
        }
    }

    //100. Same Tree
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null && t2 != null) {
            return false;
        }
        if (t1 != null && t2 == null) {
            return false;
        }
        if (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                return false;
            } else {
                return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
            }
        }
        return true;
    }

    //226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        return root;
    }

    //623. Add One Row to Tree
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            int deep = d - 1;
            addRow(root, v, deep, 1);
        }
        return root;
    }

    public void addRow(TreeNode node, int v, int deep, int thisDeep) {
        if (node == null) {
            return;
        }
        if (deep == thisDeep) {
            TreeNode leftTemp = node.left;
            TreeNode rightTemp = node.right;
            node.left = new TreeNode(v);
            node.right = new TreeNode(v);
            node.left.left = leftTemp;
            node.right.right = rightTemp;
            return;
        }
        addRow(node.left, v, deep, thisDeep + 1);
        addRow(node.right, v, deep, thisDeep + 1);
    }


    //572. Subtree of Another Tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (s.val == t.val && isTheSame(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    public boolean isTheSame(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        //当其中有个已到达底端但另一个还没有，返回false
        if ((s != null && t == null) || (s == null && t != null))
            return false;
        //当前val相等，继续对左子树右子树做同样的事，如果都true，则返回true
        if (s.val == t.val && isTheSame(s.left, t.left) && isTheSame(s.right, t.right))
            return true;
        return false;
    }

    //563. Binary Tree Tilt

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }

    //101. Symmetric Tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val != root.right.val) {
            return false;
        } else {
            return isSymmetricSame(root.left, root.right);
        }
    }

    public boolean isSymmetricSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null || left == null && right != null) {
            return false;
        } else {
            return left.val == right.val && isSymmetricSame(left.left, right.right) && isSymmetricSame(left.right, right.left);
        }
    }

    //257. Binary Tree Paths
    List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) findPaths(root, String.valueOf(root.val));
        return res;
    }

    private void findPaths(TreeNode n, String path) {
        if (n.left == null && n.right == null) res.add(path);
        if (n.left != null) findPaths(n.left, path + "->" + n.left.val);
        if (n.right != null) findPaths(n.right, path + "->" + n.right.val);
    }


    //437. Path Sum III
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return res;
        if (sum == root.val)
            res++;
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }


    //113. Path Sum II
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;
        helper(root, sum, new ArrayList<Integer>(), res);
        return res;
    }

    void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (sum - root.val == 0) {
                list.add(root.val);
                res.add(new ArrayList(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        if (root.left != null) {
            list.add(root.val);
            helper(root.left, sum - root.val, list, res);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.val);
            helper(root.right, sum - root.val, list, res);
            list.remove(list.size() - 1);
        }
        return;
    }

    //543. Diameter of Binary Tree
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }

    // 此函数是返回树的最大深度
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        diameter = Math.max(diameter, l + r);
        return Math.max(l, r) + 1;
    }


    //104. Maximum Depth of Binary Tree
    public static int deep(TreeNode node) {
        int h1, h2;
        if (node == null) {
            return 0;
        } else {
            h1 = deep(node.left);
            h2 = deep(node.right);
            return (h1 < h2) ? h2 + 1 : h1 + 1;
        }
    }

    //404. Sum of Left Leaves
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}