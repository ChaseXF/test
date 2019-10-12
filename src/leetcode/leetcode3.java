package leetcode;

import java.lang.reflect.Array;

public class leetcode3 {
    public static void main(String[] args) {
        String str="sdvasdfadadadcaxzvasd";
       System.out.println(lengthOfLongestSubstring(str));
    }
        static int lengthOfLongestSubstring(String s) {
            String[] arr=s.split("",s.length());
            int len=0,maxLen=0,start=0;

            for(int i=1;i<arr.length;i++){
                if(join(start,i,arr))
                    len++;
                else
                    start=i;
                if(len>maxLen)
                    maxLen=len;
            }
            return maxLen;
        }

        static boolean join(int start, int end, String[] arr){
            for(int i=start;i<end;i++){
                if(arr[i].equals(arr[end]))
                return false;
            }
            return true;
        }

}

