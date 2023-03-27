class Solution {
    public int solution(int[] numbers, int k) {
        
        /*
        int[] arr = new int[k];
        int idx = 0;
        int n_idx = 0;
        for(int i = 0; i<k; i++){
            idx += 2;
            arr[i] = idx;
        }
        
        if(arr[k-2] > numbers.length)
            n_idx = (arr[k-2]-numbers.length);
        else
            n_idx = (numbers.length-arr[k-2]);
        
        if(n_idx >= numbers.length){
            n_idx = (n_idx/numbers.length)-1;
        }
            
            */
        return numbers[((k-1)*2)%numbers.length]; 
        
        
    }
}