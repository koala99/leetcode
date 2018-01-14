package sort;

/**
 * Created by lilei on 16/7/29.
 */
public class Merge {
    public static int[] array1 = {-10, -3, 2, 6, 12, 34, 36};
    public static int[] array2 = {-12, -4, -2, 5, 11, 16, 26, 45};

    public static void mergeSort(int[] arr, int[] arr1) {
        int size1 = arr.length;
        int size2 = arr1.length;
        int[] arrays = new int[size1 + size2];
        int i = 0, j = 0, k = 0;
        while (i < size1 && j < size2) {
            if (arr[i] < arr1[j])
                arrays[k++] = arr[i++];
            else
                arrays[k++] = arr1[j++];
        }
        while (i < size1) {
            arrays[k++] = arr[i++];
        }
        while (j < size2) {
            arrays[k++] = arr1[j++];
        }
        for(int m=0;m<arrays.length;m++){
            System.out.print(arrays[m]+" ");
        }
    }

    public static void main(String[] args) {
        mergeSort(array1, array2);
    }
}
