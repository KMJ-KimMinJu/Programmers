import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        char[] b_arr = before.toCharArray();
        char[] a_arr = after.toCharArray();
        
        Arrays.sort(b_arr);
        Arrays.sort(a_arr);
        
        before = new String(b_arr);
        after = new String(a_arr);
        
        if(before.equals(after)){
            return 1;
        }else{
            return 0;
        }
        
        
    }
}