import base.ListNode;

import java.util.*;

public class Question2 {
    //231. 2的幂
    public static boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        int result = (n) & (n - 1);
        return result == 0;
    }

    //326. 3的幂
    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        double tmp = Math.log10(n) / Math.log10(3.0);
        if (Math.round(tmp) - tmp == 0)
            return true;
        else
            return false;
    }

    //   342. 4的幂
    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        double tmp = Math.log10(n) / Math.log10(4.0);
        if (Math.round(tmp) - tmp == 0)
            return true;
        else
            return false;
    }

    //709. 转换成小写字母
    public static String toLowerCase(String str) {
        if (null == str) {
            return null;
        }
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }
        }
        String s = new String(ch);
        return s;
    }

    //961. 重复 N 次的元素
    public static int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1])
                return A[i];
        }
        return 0;
    }

    // 929. 独特的电子邮件地址
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            //本地名称
            String name = email.substring(0, email.indexOf("@"));
            //域名
            String domain = email.substring(email.indexOf("@"));
            //根据指定规则解析后的本地名称，先按加号切割字符串，然后替换'.'
            String newName = name.substring(0, name.indexOf("+")).replaceAll(".", "");
            //使用HashSet去重
            set.add(newName + domain);
        }
        return set.size();
    }

    //118 杨辉三角
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> listItem = new ArrayList<>();
            int number = 1;
            for (int j = 0; j <= i; j++) {
                listItem.add(number);
                number = number * (i - j) / (j + 1);
            }
            lists.add(listItem);
        }
        return lists;
    }

    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    continue;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    continue;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    continue;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    continue;
            }
        }
        return stack.isEmpty();
    }

    //66. 加一
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    //234. 回文链表
    public boolean isPalindrome(ListNode head) {
        // 要实现 O(n) 的时间复杂度和 O(1) 的空间复杂度，需要翻转后半部分
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 根据快慢指针，找到链表的中点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        // 递归到最后一个节点，返回新的新的头结点
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //415. 字符串相加
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int res = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            if (res >= 10) carry = 1;
            else carry = 0;
            res = res % 10;
            str.append(res);
            i--;
            j--;
        }
        while (j >= 0) {
            int res = num2.charAt(j) - '0' + carry;
            if (res >= 10) carry = 1;
            else carry = 0;
            res = res % 10;
            str.append(res);
            j--;
        }
        while (i >= 0) {
            int res = num1.charAt(i) - '0' + carry;
            if (res >= 10) carry = 1;
            else carry = 0;
            res = res % 10;
            str.append(res);
            i--;
        }
        if (carry == 1) str.append("1");
        return str.reverse().toString();
    }


    //38. 报数
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }

    //23. 合并K个升序链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;




            tail = minNode;

            if (minNode.next != null) {
                pq.offer(minNode.next);
//                for (ListNode node:pq) {
//                    System.out.print(node.val + " ");
//                }
//                System.out.println("---------- ");
            }

        }

        return dummyHead.next;
    }

    // topK问题是指：从海量数据中寻找最大的前k个数据，比如从1亿个数据中，寻找最大的1万个数。
    public int findKthLargest3(int[] nums, int k) {   //时间复杂度：O(NlogK)，遍历数据 O(N)，堆内元素调整 O(K)，空间复杂度：O(K)
        int len = nums.length;
        // 使用一个含有 k 个元素的最小堆
        // k 堆的初始容量，(a,b) -> a -b 比较器
        PriorityQueue<Integer> minTop = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minTop.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer topEle = minTop.peek();  // 返回队头元素（不删除），失败时前者抛出null
            // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
            if (nums[i] > topEle) {
                minTop.poll();  // 获取队头元素并删除，并返回，失败时前者抛出null，再调整堆结构
                minTop.offer(nums[i]);  // 在队尾插入元素，插入失败时抛出false，并调整堆结构
            }
        }
        return minTop.peek();
    }


}


