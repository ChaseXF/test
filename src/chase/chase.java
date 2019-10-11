package chase;

import java.util.Arrays;

public class chase {
    public static void main(String args[]){        //类初始化
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        House house=new House();
        house.f();
        
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2]=99;
        s.printScores();
        
        StringBuilder sb=new StringBuilder(10);
        sb.append("d");
        sb.append('s');
        System.out.println(sb);
    }
    public void print(){
        System.out.println("wdw");
    }
}


class Score {
    private int[] scores;
    public Score(int[] scores) {
        this.scores = scores;
    }
    
    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}

class Windows{
    Windows(int maker){
        System.out.println("Windows:"+maker);
    }
}

class House{
    Windows w1=new Windows(1);
    House(){
        Windows w1=new Windows(2);
        System.out.println("hhh");
        Windows w3=new Windows(1);
    }
    void f(){
        System.out.println("hhhhhhhhh");}
        void f2(){
            System.out.println("hhhhhhhhh");
    }
}

