package base;

public class Test {
    public static void main(String args[]) {
        printStr("ab#d#ee");
//        ab
//        ab#d#
    }

    /*
    字符串移位，给出字符串abc##dfg##gh，实现将所有#移至字符串串头。
    输出####abcdfggh
     */

    public static void printStr(String str) {
        if (str == null || str.length() == 0)
            return;
        char[] chaArray = str.toCharArray();
        int index1 = 0;
        int index2 = chaArray.length - 1;
        while (index1 < index2) {
            while (index1 < index2 && chaArray[index1] >= 'a' && chaArray[index1] <= 'z') {
                index1++;
            }
            while (index1 < index2 && chaArray[index2] >= 'a' && chaArray[index1] <= 'z') {
                index2--;
            }
            System.out.println("index:" + index1 + ":" + index2);

            if (index1 <= index2) {
                System.out.println("输出3");
                for (int i = index1; i <= index2; i++) {
                    System.out.print(str.charAt(i));
                }
                for (int i = 0; i < index1; i++) {
                    System.out.print(str.charAt(i));
                }
                for (int i = index2 + 1; i < str.length(); i++) {
                    System.out.print(str.charAt(i));
                }
            }
        }
//        System.out.println("输出" + str);
    }
}
