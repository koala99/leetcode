import java.util.ArrayList;

/**
 * Created by lilei on 16/7/30.
 */
public class DemoTree {
    private BinaryTree root;

    //构建树
    public  void buildTree(BinaryTree tree,int data){
        if(root==null) {
            root = new BinaryTree(data);
        }else{
            if(data<tree.data){
              if(tree.left==null){
                  tree.left = new BinaryTree(data);
              }else{
                  buildTree(tree.left,data);
              }
            }else{
                if(tree.right == null){
                    tree.right=new BinaryTree(data);
                }else{
                    buildTree(tree.right,data);
                }
            }
        }

    }
    //前序遍历
    public static void preOrder(BinaryTree node){
        if(node != null){
            System.out.print(node.data+"  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //中序遍历
    public static void inOrder(BinaryTree node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data+"  ");
            inOrder(node.right);
        }
    }

    //后序遍历
    public static void postOrder(BinaryTree node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+"  ");

        }
    }

    //广度遍历
    public static void widthSearch(BinaryTree node){
        ArrayList<BinaryTree> lists =new ArrayList<BinaryTree>();
        lists.add(node);
        while (!lists.isEmpty()){
            BinaryTree tree = lists.get(0);
            System.out.print(lists.get(0).data+" ");
            lists.remove(0);
            if(tree.left!=null){
                lists.add(tree.left);
            }
            if(tree.right!=null){
                lists.add(tree.right);
            }
        }

    }


    public static void main(String args[]){
        int[] a = {2,4,12,45,21,6,111};
        DemoTree bTree = new DemoTree();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }
        preOrder(bTree.root);
        System.out.println("-----------");
        inOrder(bTree.root);
        System.out.println("-----------");
        postOrder(bTree.root);
        System.out.println("-----------");
        widthSearch(bTree.root);
    }

    class BinaryTree{
        private int data;
        private BinaryTree left;
        private BinaryTree right;

        public BinaryTree(int data){
            this.left=null;
            this.right=null;
            this.data=data;
        }

    }

}

