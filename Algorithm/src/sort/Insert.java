package sort;

import javax.swing.*;
import java.lang.reflect.GenericArrayType;

public class Insert {

    public static int[] arrays = {-1, 0, 2, 5, 3, -2,4,12,6,-5,17};

    public static void main(String[] args) {
        shell(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    public static void insert(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[i] < arrays[j]) {
                    int temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }
    //插入排序优化。前面的是有序队列，，可以折半插入


    //希尔排序
    public static void shell(int[] arrays) {
        for (int gap = arrays.length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < arrays.length; j++) {
                if (arrays[j] < arrays[j - gap]) {
                    int temp = arrays[j];
                    int k = j - gap;
                    System.out.println(gap+":"+j+":"+k);
                    while (k >= 0 && arrays[k] > temp) {
                        arrays[k + gap] = arrays[k];
                        k -= gap;
                    }
                    arrays[k + gap] = temp;
                }
            }

        }
    }
}
