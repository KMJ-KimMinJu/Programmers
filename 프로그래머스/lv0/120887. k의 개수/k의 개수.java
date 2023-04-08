class Solution {
    public int solution(int i, int j, int k) {
        String number = String.valueOf(k);
        int count = 0;
        
        for(int q = i; q<=j; q++){
            String compare = String.valueOf(q);
            
            for(int a = 0; a<compare.length(); a++){
                String sa = String.valueOf(compare.charAt(a));
                if(sa.equals(number)){
                    count ++;
                }
            }
            
        }
        
        return count;
    }
}