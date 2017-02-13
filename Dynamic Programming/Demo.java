package 动态规划;

/**
 * Created by lilei on 16/7/30.
 * 买卖股票问题
 */
public class Demo {
    static int array[] = {1, 4, 9, 2, 7, 3};
//            {4, 9, 2, 7, 3,12,4,8,19,1};

    //一买一卖获利最大
    public static int getMaxSell(int index) {
        int max = -1100000;
        if (index >= 0 && index < array.length - 1) {
            System.out.println();
            max = Math.max(array[index + 1], getMaxSell(index + 1));
        } else if (index == array.length - 1) {
            return max;
        }
        return max;
    }

    public static int getMaxSell1(int index) {
        if (index == array.length - 1)
            return -1000000;
        int val1 = -10000, val2 = 0;
        int val3=0;
        for (int i = array.length - 1 - index; i >= 0; i--) {
            val1 = array[i];
            val3 = Math.max(val1, val2);
            val2 = val3;
        }
        return val3;
    }

    //多次买卖获利最大
//    public static int getMaxTrade(int i){
//        boolean flag =false;
//        int sum=0;
//       while(i<array.length-1){ //遍历完成,并且不持有股票
//           if(flag){ //持仓
//               sum=sum-array[i];
//               flag = false;
//               getMaxTrade(i+1);
//           }else{
//               sum=0;
//               i++;
//           }
//       }
//
//    }


    static int flag = 0;

    public static void main(String args[]) {
        int sum = 0;
        long begin=System.currentTimeMillis();
        for(int i= 0;i<array.length;i++){
           if(sum<getMaxSell(i)-array[i]){
               sum = getMaxSell(i)-array[i];
           }
        }
        System.out.println("time1:"+(System.currentTimeMillis()-begin));
        System.out.println("sum1:" + sum);

         sum = 0;
         begin=System.currentTimeMillis();
        for(int i= 0;i<array.length;i++){
            if(sum<getMaxSell1(i)-array[i]){
                sum = getMaxSell1(i)-array[i];
            }
        }
        System.out.println("time2:"+(System.currentTimeMillis()-begin));
        System.out.println("sum2:" + sum);
//        for(int i=0;i<array.length;i++) {
//            if() {
//                System.out.println(getMaxTrade(i) - array[i]);
//            }else{
//                System.err.println(array[i]-getMaxTrade(i) );
//
//            }
//        }
    }
}
