package leetcode;

import java.lang.reflect.Array;

public class leetcode3 {
    public static void main(String[] args) {
        String str="";
       System.out.println(lengthOfLongestSubstring(str));
    }
        static int lengthOfLongestSubstring(String s) {

            if(s.length()<=0)
                return 0;
            String[] arr=s.split("",s.length());
            int len=1,maxLen=1,start=0;

            for(int i=1;i<arr.length;i++){
                if(join(start,i,arr))
                    len++;
                else{
                    start=i;
                    len=1;
                }
                if(len>maxLen)
                    maxLen=len;
                System.out.println("i:"+i+" len:"+len+" start:"+start+" maxlen:"+maxLen);
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

