import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Arrays.sort(arr);
        
        int result = arr[0];
        
        for(int i = 1; i<arr.length; i++){
            result = LCM(result, arr[i]);
        }
        
        return result;
    }
    
    //최대공약수
    public static int GCD(int a, int b){
        if(b == 0) {
            return a;
        }
        
        return GCD(b, a % b);
    }
    
    //최소공배수
    public static int LCM(int result, int arr){
        return (result * arr) / GCD(result, arr);
    }
    
}