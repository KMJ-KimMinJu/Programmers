import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public Integer[] solution(int n) {
        
        /*
        int[] num = new [25];
        //약수 먼저 구해줌
        for(int i = 1; i<=n; i++){
            if(n%i == 0)
                num[i-1] = i;
        }
        
        String str = "";
        
        int count = 0;
        
        //구한 약수 중에서 소수를 
        for(int i = 0; i<num.length; i++){
            for(int j = 1; j<=num[i]; i++){
                if(num[i] % j == 0)
                    count += 1;
            }
            
            if(count == 2){
                str += String.valueOf(num[i]) + ",";
                count = 0;
            }
        }
        
        String[] arr = str. */

        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> prime = new ArrayList<>();
        
        int count = 0;
        
        for(int i = 1; i<=n ;i++){
            if(n%i == 0)
                num.add(i);
        }
        
        
        for(int i = 0; i<num.size(); i++){
            for(int j = 2; j<=n; j++){
                if(num.get(i)%j == 0)
                    count += 1;
            }
            
            if(count == 1){
                prime.add(num.get(i));
            }
            count = 0;
        }
        
        Integer[] array = prime.toArray(new Integer[prime.size()]);
        
        Arrays.sort(array);
        
        return array;
        
        
    }
}