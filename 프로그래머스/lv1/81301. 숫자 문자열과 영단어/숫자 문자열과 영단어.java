class Solution {
    public int solution(String s) {
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
            
            for(int i = 0; i<eng.length; i++){
                s = s.replaceAll(eng[i], num[i]);
            }
        
        return Integer.parseInt(s);
    }
}