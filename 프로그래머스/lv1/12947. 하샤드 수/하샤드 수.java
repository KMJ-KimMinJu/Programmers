class Solution {
    public boolean solution(int x) {
        String str_x = String.valueOf(x);
        
        String[] arr_x = str_x.split("");
        int sum = 0;
        
        for(int i = 0; i<arr_x.length; i++){
            sum += Integer.parseInt(arr_x[i]);
        }
        
        if(x%sum== 0){
            return true;
        }else {
            return false;
        }
    }
}
