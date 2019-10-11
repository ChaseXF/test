package chase;

public class Leet2 {
    public static void main(String[] args){
        ListCode list=new ListCode(2);
        ListCode head=list;
        list.next=new ListCode(4);
        House house=new House();
    }
}
class ListCode{
    int val;
    ListCode next;
    ListCode(int x){
        this.val=x;
    }
}
