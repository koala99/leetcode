/**
 * Created by lilei on 2017/7/5.
 */
import java.util.*;
public class SkipList {
    public Node head;   //头节点
    public Node tail;   //尾结点
    public int h;   //层数
    public int size;    //元素个数
    public Random rand; //每次的随机数用来确定需不需要增加层数
    public SkipList(){
        Node p1 = new Node(Node.tou,0);
        Node p2 = new Node(Node.wei, 0);
        head=p1;
        tail=p2;
        head.setRight(tail);
        tail.setLeft(head);
        h=0;
        size=0;
        rand = new Random();
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    //找到需要插入位置的前一个节点
    public Node findF(String k){
        Node temp;
        temp=head;
        while(true){
            while(temp.getRight().key!=Node.wei&&temp.getRight().key.compareTo(k)<=0){
                /*
                 * 当链表最底层不为空的时候，从当前层向尾部方向开始查找，直到查找temp.getRight的下一个值大于 当前k的值为止，此时temp小于或等于当前k的值
                 *  要插入的位置即为temp之后的位置了
                 */
                temp=temp.getRight();
            }
            if(temp.getDown()!=null){
                temp=temp.getDown();
            }else{
                break;
            }

        }
        return temp;    //找到节点并返回

    }
    public int add(String k, int v){
        Node temp, temp1;
        temp=findF(k);
        int i;  //当前层数
        if(k.equals(temp.getKey())){
            System.out.println("对象属性完全相同无法添加！");
            int a=temp.value;
            temp.value=v;
            return  a;
        }
        temp1=new Node(k,v);
        temp1.setLeft(temp);
        temp1.setRight(temp.getRight());
        temp.getRight().setLeft(temp1);
        temp.setRight(temp1);
        i=0;

        while(rand.nextDouble()<0.5){    //进行随机，是否需要 在上层添加
            if(i>=h){    //若当前层数超出了高度，则需要另建一层
                Node p1 ,p2 ;
                h=h+1;
                p1=new Node(Node.tou,0);
                p2=new Node(Node.wei,0);

                p1.setRight(p2);
                p1.setDown(head);

                p2.setLeft(p1);
                p2.setDown(tail);

                head.setUp(p1);
                tail.setUp(p2);

                head=p1;
                tail=p2;
            }
            while(temp.getUp() == null){
                temp=temp.getLeft();
            }
            temp=temp.getUp();
            Node node=new Node(k,v);
            node.setLeft(temp);
            node.setRight(temp.getRight());
            node.setDown(temp1);

            temp.getRight().setLeft(node);
            temp.setRight(node);
            temp1.setUp(node);

            temp1=node;
            i=i+1;

        }

        size=size+1;
        return  0;
    }
    //节点查找
    public Node find(String k){
        Node temp=head;
        Node node;
        node=temp;
        System.out.println("查找路线"); //用于测试
        while(temp!=null){
            while(node.getRight().key!=Node.wei&&node.getRight().getKey().compareTo(k)<=0){//&&node.getRight().getValue()!=v
                node=node.getRight();
                System.out.print("--->"+node.getKey());
            }

            if(node.getDown()!=null){
                node=node.getDown();
                System.out.print("--->"+node.getKey());
            }else{
                if(node.key.equals(k)){//&&node.getRight().value==v
                    //node.setValue(111111111); //修改
                    System.out.println("--->"+node.getKey());
                    System.out.print("--->"+node.getValue());

                    return node;
                }
                return null;
            }


        }
        return null;
    }
    //节点删除
    public void delNode(String k){  //调用查找函数，删除最底层的某个节点，并把其节点的左右相连，和链表操作一样，只是其上方若有则都需要调整
        Node temp=find(k);
        while(temp!=null){
            temp.getLeft().setRight(temp.getRight());
            temp.getRight().setLeft(temp.getLeft());
            temp=temp.getUp();
        }
    }
    public void print(){
        Node node;
        Node node1=head;


        while(node1!=null){
            int k=0;
            node=node1;
            while(node!=null){
                System.out.print(node.getKey()+"\t");
                k++;
                node=node.getRight();
            }

            System.out.print("\t");
            System.out.print("("+k+")");
            //System.out.print(node.getKey());
            System.out.println();
            //node=node1.getDown();
            node1=node1.getDown();

        }
    }

}
class Node {
    public String key;
    public int value;
    public Node up, down, left, right;
    public static String tou = new String("--头--");
    public static String wei = new String("--尾--");

    public Node(String k, int v) {
        this.key = k;
        this.value = v;
        up = down = left = right = null;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getUp() {
        return up;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getDown() {
        return down;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setKey(String k) {
        this.key = k;
    }

    public String getKey() {
        return key;
    }

    public void setValue(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }


    public static void main(String[] args) {
        SkipList s = new SkipList();
//      s.add("AAA", 122);
        int i = 0;
        for (; i < 30; i++) {  //随机数字进行测试
            s.add(String.valueOf(i), i);
        }
        s.print();
        System.out.println("\n\n----------\n\n\n");
        if (s.find("22") != null) { //查找
            System.out.println("\nOK");
        } else {//找不到
            System.out.println("\nfalse");
        }
        s.delNode("0"); //删除
        s.print();
    }
}