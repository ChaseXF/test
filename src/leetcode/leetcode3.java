package leetcode;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode3 {
    public static void main(String[] args) {
        String str = "";
    }
}

class MySolution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")||s == null)
            return 0;
        if(s.equals(" "))
            return 1;
        String[] arr=s.split("",s.length());
        int len=1,maxLen=1,start=0,index=0;

        for(int i=1;i<arr.length;i++){
            if(join(start,i,arr))
                len++;
            else{
                index=index(start,i,arr);
                start=index+1;
                len=i-index;
            }
            if(len>maxLen)
                maxLen=len;
            // System.out.println(" start:"+start+"--"+i+" len:"+len+" maxlen:"+maxLen+" index:"+index);
        }
        return maxLen;
    }

    boolean join(int start, int end, String[] arr){
        for(int i=start;i<end;i++){
            if(arr[i].equals(arr[end]))
                return false;
        }
        return true;
    }

    int  index(int start, int end, String[] arr){
        for(int i=start;i<end;i++){
            if(arr[i].equals(arr[end]))
                return i;
        }
        return 0;

    }


}


class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}



