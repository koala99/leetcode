package Arrays;

/**
 * Created by lilei on 16/7/31.
 * 二维升序数组寻数
 * 区域划分
 */
public class Demo {
    public static int[][] array = {
            {1, 3, 8, 13},
            {10, 13, 18, 23},
            {12, 23, 28, 45},
            {15, 33, 38, 93},
    };

    public static boolean findNumber(int number) {
        boolean found = false;
        int columns = array[0].length;
        int rows = array.length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (array[row ][column] == number) {
                found = true;
                System.out.println(row  + ":" + column);

                break;
            } else if (array[row ][column] > number) {
                column--;
            } else {
                row++;
            }
        }
        return found;
    }

    public static void main(String args[]) {
        if (findNumber(12)) {
            System.out.println("找到位置");

        } else {
            System.out.println("找不到位置");
        }
    }
}
