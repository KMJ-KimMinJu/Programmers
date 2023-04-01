import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        
         Arrays.sort(array);
         int[] n_sub = new int[array.length];
        
        //n과 array 요소끼리 빼서 절댓값으로 저장
        for(int i =0; i<array.length; i++){
            n_sub[i] = Math.abs(n-array[i]);
        }
        
        int min = 100;
        int idx = 0;
        
        //n_sub 배열의 최소값을 구해줌
        for(int i = 0; i<n_sub.length; i++){
            if(min > n_sub[i]){
                min = n_sub[i];
                idx = i;
                }
            if(min == n_sub[i])
                continue;
        }
        
        
        return array[idx];
    }
}


