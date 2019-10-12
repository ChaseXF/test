package leetcode;

import java.lang.reflect.Array;

public class leetcode3 {
    public static void main(String[] args) {
        String str="pwwkew";
       System.out.println(lengthOfLongestSubstring(str));
    }

    static int lengthOfLongestSubstring(String s) {
        String[] arr=s.split("",s.length());
        int count=0,max=0;

        for(int i=0;i<arr.length-1;i++){




            if(!arr[i].equals(arr[i + 1]))
                count++;
            if(count>max)
                max=count;
            if(arr[i].equals(arr[i + 1]))
                count=0;
        }
        return max+1;
    }

}
