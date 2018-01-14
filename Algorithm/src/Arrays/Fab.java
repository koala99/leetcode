package Arrays;

/**
 * Created by lilei on 16/8/11.
 */
public class Fab {
    /**
     * 实现o(n)的时间复杂度算法
     * @param index
     * @return
     */
    public static int Fib5(int index)
    {
        if(index==1 || index==2)
            return 1;
        int n=index;
        int array[]=new int [n+1];
        array[0]=1;
        array[1]=1;
        for(int i=2;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[index];
    }
    public static void main(String args[]){
        System.out.println(Fib5(5));
    }
}
