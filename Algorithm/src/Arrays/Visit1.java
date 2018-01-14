package Arrays;

/**
 * Created by lilei on 16/8/2.
 * 蛇形遍历
 * 规律:左+1,斜下循环,下+1,邪上循环
 */
public class Visit1 {
    public static int[][] array = {
            {1,  2,  3,  4 ,5},
            {6,  7,  8,  9 ,10},
            {11, 12, 13, 14,15},
            {16, 17, 18, 19,20}
    };

    public static void outPut(int[][] data) {
        int left = 0;
        int right = 5;
        int top = 0;
        int bottom =4;
        int i = 0;
        int j = 0;
        System.out.print(data[i][j]+" ");
         int k=0;
        while ( !(i==3 && j==4)) {
            k=0;
            while(j<right && k==0){
                j++;
                k++;
                System.out.print(data[i][j]+" ");
            }
            System.out.println("1-------"+i+":"+j);

            while(j!=0){
                 i++;
                 j--;
                System.out.print(data[i][j]+" ");
            }
            System.out.println("2-------"+i+":"+j);
            k=0;
            while(i<=bottom-1 && k==0){
                i++;
                k++;
                System.out.print(data[i][j]+" ");
            }
            System.out.println("3-------"+i+":"+j);

            while(i>0){
                i--;
                j++;
                System.out.print(data[i][j]+" ");
            }
            System.out.println("4-------"+i+":"+j);

        }
    }

    public static void main(String[] args) {
        outPut(array);
    }
}
