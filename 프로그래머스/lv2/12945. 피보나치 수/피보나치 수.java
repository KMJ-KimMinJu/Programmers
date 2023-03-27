class Solution {
    
    public static int fibo(int n){
        int last1 = 0;
        int last2 = 1;
        int result = 0;
        
        for(int i = 1;i<n; i++){
            result = ((last1+last2)%1234567);
            last1 = last2;
            last2 = result;
        }
        return result;
    }
    
    public int solution(int n) {

        return fibo(n);
    }
}