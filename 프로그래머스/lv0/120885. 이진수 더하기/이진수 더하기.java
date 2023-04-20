class Solution {
    public String solution(String bin1, String bin2) {
        
        
        int bin_1 = Integer.parseInt(bin1, 2);
        int bin_2 = Integer.parseInt(bin2, 2);
        
        return Integer.toBinaryString(bin_1 + bin_2);
        
    }
}