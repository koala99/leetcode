package sort;

import java.util.HashSet;

/**
 * Created by lilei on 16/7/30.
 */
public class HappyNumber {
    private static HashSet sets = new HashSet();

    public static void main(String[] args) {
        System.out.print((new HappyNumber()).isHappy(19));
    }
    public boolean isHappy(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        int temp=0;
        boolean flag[]=new boolean[811];
        int yushu=0;

        while(true){
            while(n!=0){
                yushu=n%10;
                n=n/10;
                temp+=yushu*yushu;
            }

            if(temp==1){
                return true;
            }

            if(flag[temp]){
                return false;
            }else{
                flag[temp]=true;
            }

            n=temp;
            temp=0;
        }
    }  }
