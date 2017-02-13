package sort;

/**
 * Created by lilei on 16/7/31.
 */
public class BackMerge {
    /**
     * 从后面开始插入数据,
     */
    public static int[] merge(int[] array1, int[] array2, int length1, int length2) {
        int i = length1 - 1;
        int j = length2 - 1;
        for (int k = length1 + length2 - 1; k >= 0; k--) {
            System.out.println(i + ":" + j);
            if (array1[i] > array2[j]) {
                array1[k] = array1[i];
                i--;
            } else {
                array1[k] = array2[j];
                j--;
            }
            while (i < 0 && j >= 0) { //数组2还没排序完
                array1[k] = array2[j];
                j--;
            }
            if (j < 0)
                break;
        }
        return array1;
    }

    public static void main(String args[]) {
        int[] array1 = {1, 4, 12, 16, 19, 25, 0, 0, 0, 0, 0, 0};
        int[] array2 = {2, 13, 15, 18, 22, 27};
        int[] array = merge(array1, array2, 6, 6);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
