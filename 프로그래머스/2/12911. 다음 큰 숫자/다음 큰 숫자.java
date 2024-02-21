class Solution {
    public int solution(int n) {
        

        long n_count = Integer.bitCount(n);

        int number = n+1;
        
        while(true){
            
            long binary = Integer.bitCount(number);
            
            if(binary == n_count){
                break;
            }
            
            number++;
        }
        
        return number;
        
    }
}