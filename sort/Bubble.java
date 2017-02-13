package sort;

public class Bubble {
    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1, -3, -12, 3, -4, 8, -7, 1, 9};

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int tmp;
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }
}
