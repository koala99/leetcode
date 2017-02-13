package Arrays;

/**
 * Created by lilei on 16/7/31.
 * 旋转数组
 */
public class Demo1 {
    public static int[] array = {4, 5, 6, 7, 8, 9,-3,-2, -1, 1, 2, 3};

    public static int resverArray(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                mid = index2;
                break;
            }
            mid = (index1 + index2) / 2;

            if (array[mid] > array[index1]) {
                index1 = mid;
            } else if (array[mid] <= array[index2]) {
                index2 = mid;
            }
        }
        return array[mid];
    }

    public static void main(String args[]) {
        System.out.println("最小数是: "+resverArray(array));
    }
}
