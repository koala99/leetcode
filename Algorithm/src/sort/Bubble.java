package sort;

public class Bubble {
    public static int[] arrays = {-1, 0, 2, 5, 3, -3, 9, -2};

    public static void sort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
                for (int k = 0; k < arrays.length; k++) {
                    System.out.print(arrays[k] + " ");
                }
                System.out.println("");

            }
            System.out.println("------------");

        }
    }

    public static void main(String[] args) {
        sort(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }


    /*冒泡优化
      * 设置一个标记来标志一趟比较是否发生交换
     * 如果没有发生交换，则数组已经有序
     * */
    public static void sort1(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    flag = true;
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            if (!flag) {
                System.out.print("has sort");
                break;
            }
        }
    }

    /*
      冒泡排序优化2
     */
    public static void sort2(int[] a) {
        int size = a.length;
        int lastSwapPos = 0, lastSwapPosTemp = 0;
        for (int i = 0; i < size - 1; i++) {
            lastSwapPos = lastSwapPosTemp;
            for (int j = size - 1; j > lastSwapPos; j--) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                    lastSwapPosTemp = j;
                }
            }
            if (lastSwapPos == lastSwapPosTemp)
                break;

        }
    }

    /*
     * 双向冒泡
     */
    private void core(int[] array) {
        int arrayLength = array.length;

        int preIndex = 0;
        int backIndex = arrayLength - 1;
        while (preIndex < backIndex) {
            preSort(array, arrayLength, preIndex);
            preIndex++;

            if (preIndex >= backIndex) {
                break;
            }

            backSort(array, backIndex);
            backIndex--;
        }
    }

    // 从前向后排序
    private void preSort(int[] array, int length, int preIndex) {
        for (int i = preIndex + 1; i < length; i++) {
            if (array[preIndex] > array[i]) {
                int tmp = array[i];
                array[i] = array[preIndex];
                array[preIndex] = tmp;
            }
        }
    }

    // 从后向前排序
    private void backSort(int[] array, int backIndex) {
        for (int i = backIndex - 1; i >= 0; i--) {
            if (array[i] > array[backIndex]) {
                int tmp = array[i];
                array[i] = array[backIndex];
                array[backIndex] = tmp;
            }
        }
    }
}

