package sort;

public class Quick {
    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1, -3, -12, 3, -4, 8, -7, 1, 9};

    public static  void quickSort(int[] array,int min,int max){
        if(min >= max || array == null)
            return;
        int mid = partition(array,min,max);
        System.out.println("mid:"+mid);
        quickSort(array,min,mid-1);
        quickSort(array,mid+1,max);
    }
    private static int partition(int[] array, int beg, int end) {
        int first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
                int tmp =array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        if (j != beg) {
            int tmp = array[j];
            array[j] = array[beg];
            array[beg] = tmp;
        }
        return j;
    }
   public static void main(String[] args){
       quickSort(arrays,0,arrays.length-1);
       for(int i=0;i<arrays.length;i++){
           System.out.print(arrays[i]+" ");
       }
   }
}
