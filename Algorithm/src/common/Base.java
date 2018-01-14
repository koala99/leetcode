package common;

import java.util.Random;

public class Base {

    public static void main(String[] args) {
        Base base = new Base();
//        int[] array = {12, 10, 13, 12, 13, 13};
//        System.out.print(base.mostNum(array));
//        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8};
//        base.revertArray(arrays, 3);
        base.generateNK(10, 7);
    }

    //如何在O(n)的时间复杂度内找出数组中出现次数超过了一半的数。
    public int mostNum(int arr[]) {
        int num = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                num = arr[i];
                count++;
            } else {
                if (num == arr[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return num;
    }

    //将一个n元一维向量向左旋转i个单位。 当n=8，i=3时，向量abcdefg旋转为defgabc ,翻转求解
    public void revertArray(int[] arr, int key) {
        swap(arr, 0, key - 1);
        // cbadefg cbagfed defgabc
        swap(arr, key, arr.length - 1);
        swap(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        while (index1 <= index2) {
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
            index1++;
            index2--;
        }
    }

    //求公约数
    public int gcd(int len, int key) {
        int tmp = 0;
        while (key != 0) {
            tmp = len / key;
            len = key;
            key = tmp;
        }
        return len;
    }

    //生成小于n且没有重复的k个整数
    public void generateNK(int n, int k) {
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = i;
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                int tmp = x[i];
//                System.out.println(n-i);
                int index = i + new Random().nextInt(100) % (n - i);
//                System.out.println(index);
                x[i] = x[index];
                x[index] = tmp;
            }
        }
        for (int i : x) {
            System.out.print(i);
        }
    }
}
