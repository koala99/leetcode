package sort;

/**
 * Created by lilei on 16/7/29.
 */
public class Select {

    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1, -3, -12, 3, -4, 8, -7, 1, 9};

    public static void main(String[] args) {
        insertSort(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    private static void insertSort(int a[]) {
        int tmp;
        for (int i = 1; i < arrays.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
