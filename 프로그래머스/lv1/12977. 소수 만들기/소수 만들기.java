import java.util.*;

class Solution {
    
    ArrayList<Integer> num = new ArrayList<>();
    public int solution(int[] arr) {
        int count = 0;
    
        for(int i = 0; i<arr.length; i++){
            if(arr.length-i >= 3){
                plus(arr, i, arr[i]);
            }else{
                break;
            }
        }

        for (int a : num) {
            if (isPrime(a)) {
                count++;
            }
        }
        
        return count;
    }
    
    public void plus(int[] arr, int idx, int n){
        int number = n;
        
        for(int j = idx+1; j<arr.length; j++){
            if(arr.length-idx >= 3){
                
            }else{
                break;
            }
            
            for(int k = j+1; k<arr.length; k++){
                    number += arr[j]+arr[k];
                    num.add(number);
                    number = n;
            }
        }        
        
    }

    //소수인지 아닌지 판별해주기
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
