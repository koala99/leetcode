import java.util.HashMap;
import java.util.Map;

public class Test {
    /**
     * 内分配了两个字节的内存空间
     */
    public static void alloc(){
        int[] array = new int[2];
        array[0] = 1;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        // 分配 100000000 个 alloc 分配的内存空间
//        for(int i = 0; i < 100000000; i++){
//            alloc();
//        }
//
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("语文", 1);
        map.put("数学", 2);
        map.put("英语", 3);
        map.put("历史", 4);
        map.put("政治", 5);
        map.put("地理", 6);
        map.put("生物", 7);
        map.put("化学", 8);
        map.put("体育", 9);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}