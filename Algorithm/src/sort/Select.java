package sort;

import java.awt.image.AreaAveragingScaleFilter;

//stable sort：插入排序、冒泡排序、归并排序、计数排序、基数排序、桶排序。
//        unstable sort：选择排序(5 8 5 2 9)、快速排序、堆排序。
public class Select {

    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1, -3, -12, 3, -4, 8, -7, 1, 9};

    public static void main(String[] args) {
        selectionSort1(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    /*
     选择排序
     */
    private static void selectionSort(int arrays[]) {
        int tmp;
        for (int i = 0; i < arrays.length; i++) {
            int k = i;
            for (int j = k + 1; j < arrays.length; j++) {
                if (arrays[j] < arrays[k]) {
                    k = j;
                }
            }
            if (i != k) {
                tmp = arrays[i];
                arrays[i] = arrays[k];
                arrays[k] = tmp;
            }
        }
    }

    /**
     * 选择排序优化
     */
    private static void selectionSort1(int arrays[]) {
        int left = 0;
        int right = arrays.length - 1;
        int min = left;
        int max = left;
        int temp;
        while (left <= right) {
            min = left;
            max = left;
            for (int i = left; i <= right; i++) {
                if (arrays[i] < arrays[min]) {
                    min = i;
                }
                if (arrays[i] > arrays[max]) {
                    max = i;
                }
            }
            //交换最小值
            temp = arrays[left];
            arrays[left] = arrays[min];
            arrays[min] = temp;

            if (left == max)
                max = min;
            //交换最小值
            temp = arrays[right];
            arrays[right] = arrays[max];
            arrays[max] = temp;
            left++;
            right--;
        }
    }
}
