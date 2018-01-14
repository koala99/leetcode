package huiwen;


public class Demo1 {
    public static void main(String args[]) {

//        String[] array = {"1", "2", "3", "4", "4", "3", "2", "1"};
//        System.out.print(isHuiwen(0, array.length - 1, array, array.length));
    }

    public static boolean isHuiwen(int lower, int high, String[] str, int len) {
        if (len == 0 || len == 1)
            return true;
        if (!str[lower].equals(str[high]))
            return false;
        else return isHuiwen(lower + 1, high - 1, str, len - 2);
    }

}
