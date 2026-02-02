class Solution {
    //처음엔 재귀함수를 썼으나, n이 큰 수가 들어오게 된다면 범위를 넘어서서 문제가 생김.
    //그리고 시간초과가 생겨남.
    
//     public static int fibo(int n){
//         int num1 = 0;
//         int num2 = 1;
//         int result = 0;
        
//         for(int i = 1;i<n; i++){
//             result = ((num1+num2)%1234567); //n번째의 그래서 피보나치 수를 구할 때까지 1234567로 계속 나눠주면서 수를 작게 만들어야 함.
//             num1 = num2;
//             num2 = result;
//         }
//         return result;
//     }
    
    public int solution(int n) {

        // return fibo(n);
        
        int[] fibo = new int[n];
        
        fibo[0] = 1;
        fibo[1] = 1;
        
        for(int i = 2; i < n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        
        return fibo[n-1];
    }
}