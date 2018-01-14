package LinkList;

/**
 * Created by lilei on 16/7/31.
 */
public class KNode {

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode first = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null)
                first = first.next;
            else {
                return null;
            }
        }
        while (first.next != null) {
            first = first.next;
            behind = behind.next;
        }
        return behind;
    }

    class ListNode implements Cloneable {

        public int value;
        //public ListNode pre;
        public ListNode next;


        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }

        public Object clone() {

            ListNode o = null;
            try {
                o = (ListNode) super.clone();
            } catch (Exception e) {

            }
            return o;
        }

    }
}
