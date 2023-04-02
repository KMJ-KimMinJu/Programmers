class Solution {
    public int solution(String str1, String str2) {
        
        String ori = str1;
        
        str1 = str1.replace(str2, "");
        
        if(ori.equals(str1))
            return 2;
        else
            return 1;
    }
}