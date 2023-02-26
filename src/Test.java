import base.ListNode;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Question1.numJewelsInStones("aaA", "aAbbb"));
//          System.out.println(Question2.isPowerOfThree(0));
//        Question1.singleNumber3(arrays);
        int[] array = {1, 2, 3, 6, 7, 8, 4, 5};
//        int[] t= Question2.plusOne(array);
//        for(int i=0;i<t.length;i++){
//            System.out.println(t[i]);
//        }
//        System.out.println(new Question2().findKthLargest3(array,3));

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//
//        node1.next = node3;
//        node3.next = node6;
//
//
//        node2.next = node4;
//        node4.next = node5;
//        node5.next = node7;
//
//        ListNode[] nodes = {node1, node2};
//        ListNode tmpNode = new Question2().mergeKLists(nodes);
//        System.out.println(tmpNode.val);
//        while (tmpNode.next != null) {
//            tmpNode = tmpNode.next;
//            System.out.println(tmpNode.val);
//        }
//        System.out.println(new Question3().numberOf2sInRange(30));

//        int l, r;
//        int a[] = new int[11];
//        int dp[][] = new int[11][10];
//        dp[0][0] = 1;
//        for (int i = 1; i <= 10; i++)
//            for (int j = 0; j <= 9; j++)
//                if (j != 4) {
//                    for (int k = 0; k <= 9; k++)
//                        dp[i][j] += dp[i - 1][k];
//                    if (j == 6)
//                        dp[i][j] -= dp[i - 1][2];
//                }
//
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[0].length;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println(" ");
//        }
        List<Integer> list = new Question4().findAnagrams("baa", "aa");
        System.out.println(" ");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }


    }

}
