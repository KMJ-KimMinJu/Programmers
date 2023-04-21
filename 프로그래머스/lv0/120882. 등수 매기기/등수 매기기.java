class Solution {
    public int[] solution(int[][] score) {
        
        double[] arr = new double[score.length];
        int[] result = new int[score.length];
        
        for(int i = 0; i<arr.length; i++){
            arr[i] = (score[i][0] + score[i][1])/2.0;
        }
        
        for(int i = 0; i<result.length; i++){
            result[i] = 1;
        }
        
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                if (arr[i] > arr[j])
                    result[j] += 1;
                else if(arr[j] > arr[i]) {
                    result[i] += 1;
                }else if(arr[j] == arr[i]){
                    result[j] = result[i];
                }
            }
        }
        
        return result;
    }
}