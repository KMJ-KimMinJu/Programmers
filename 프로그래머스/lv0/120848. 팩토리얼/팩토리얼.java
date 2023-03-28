class Solution {
    
    public static int fac(int n){
        if(n == 1)
            return 1;
        return n * fac(n-1);
    }
    
    
    public int solution(int n) {
        
        int idx = 0;
        for(int i = 1; i<=10 ; i++){
            if(n < fac(i)){
                idx = i-1;
                break;
            }
            if(n == fac(i)){
                idx = i;
                break;
                
            }
            
        }
        
        return idx;
    }
}