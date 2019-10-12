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


}


