public class Test {
    public static void main(String[] args) {
//        System.out.println(Question1.numJewelsInStones("aaA", "aAbbb"));
//          System.out.println(Question2.isPowerOfThree(0));
//        Question1.singleNumber3(arrays);
        int[] array ={1,2,3,4,5};
        int[] t= Question2.plusOne(array);
        for(int i=0;i<t.length;i++){
            System.out.println(t[i]);
        }
    }
}
