import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int result = arr[0];
        
        for(int i = 1; i<arr.length; i++){
            result = LCM(result, arr[i]);
        }
        
        return result;
    }
    
    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        
        return GCD(b, a % b);
    }
    
    public static int LCM(int result, int arr){
        return (result * arr) / GCD(result, arr);
    }
    
}