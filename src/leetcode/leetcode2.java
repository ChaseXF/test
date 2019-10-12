package leetcode;

public class leetcode2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode c = new ListNode(7);
        ListNode a1 = new ListNode(6);
        ListNode c1 = new ListNode(7);
        a.next = a1;
        c.next = c1;
        ListNode d = addTwoNumbers2(a, c);
        while(d!=null){
        System.out.println(d.val);
        d=d.next;}
    }

    static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode answer = current;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int a=(x+y+carry)%10;
            carry=(x+y+carry)/10;
            current.next=new ListNode(a);
            current=current.next;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if(carry>0)
            current.next=new ListNode(carry);
        return answer.next;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode answer = temp;
        int carry = 0;
        while (l1 != null || l2 != null) {
            ListNode temp2 = new ListNode(0);
            if (l1 != null && l2 != null) {
                temp2.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
                temp.next = temp2;
                temp = temp.next;
            } else if (l1 == null) {
                temp2.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
                temp.next = temp2;
                temp = temp.next;
            } else {
                temp2.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                temp.next = temp2;
                temp = temp.next;
            }
        }
        if (carry != 0) {
            ListNode temp2 = new ListNode(1);
            temp.next = temp2;
        }
        return answer.next;

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}






