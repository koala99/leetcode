package MaxSub;

/**
 * Created by lilei on 16/6/27.
 */
public class Demo {
    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1,
            -3, -12, 3, -4, 8, -7, 1, 9};

    public static class Data {
        public int start;
        public int end;
        public int sum;
    }

    private static Data find(int[] array, int low, int high) {
        Data data = new Data();
        if (low == high) {
            data.start = low;
            data.end = high;
            data.sum = array[low];
        } else {
            int mid = (low + high) / 2;
            Data data1 = find(array, low, mid);
            Data data2 = find(array, mid + 1, high);
            Data data3 = findCenter(array, low, high, mid);

            if (data1.sum >= data2.sum && data1.sum >= data3.sum) {
                data = data1;
            } else if (data2.sum >= data1.sum && data2.sum >= data3.sum) {
                data = data2;
            } else {
                data = data3;
            }
        }
        return data;
    }

    private static Data findCenter(int[] array, int low, int high, int mid) {
        Data data = new Data();
        int leftSum = array[mid]; //左部最大和
        int maxLeft = mid; //左边界
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += array[i];
            if (sum >= leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = array[mid+1];
        int maxRight = mid + 1;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += array[i];
            if (sum >= rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        data.start = maxLeft;
        data.end = maxRight;
        data.sum = rightSum + leftSum;
        return data;
    }

    public static void main(String[] Argus) {
        long time = System.currentTimeMillis();
        Data data = find(arrays, 0, arrays.length - 1);

        System.out.println("sum:" + data.start + ":" + data.end + ":" + data.sum);

    }
}
