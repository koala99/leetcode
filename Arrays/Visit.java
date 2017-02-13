package Arrays;

/**
 * Created by lilei on 16/8/2.
 * 回形遍历
 */
public class Visit {
    public static int[][] array = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
    };

    public static void outPut(int[][] data) {
        int width = data[0].length;
        int height = data.length;
        int i = 0;
        int j = 0;
        int right = width;
        int bottom = height;
        int top = 0;
        int left = 0;
        while (right >= 0 && bottom >= 0) {
            while (right > j) {
                System.out.print(array[i][j]+" ");
                j++;
            }
            j--;
            i++;
            top++;
            System.out.println();

            while (bottom > i) {
                System.out.print(array[i][j]+" ");
                i++;
            }
            i--;
            j--;
            right--;
            System.out.println();

            while (j >=left) {
                System.out.print(array[i][j] +" ");
                j--;
            }
            j++;
            i--;
            bottom--;
            System.out.println();

            while (i>=top) {
                System.out.print(array[i][j] +" ");
                i--;
            }
            i++;
            j++;
            left++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        outPut(array);
    }
}
