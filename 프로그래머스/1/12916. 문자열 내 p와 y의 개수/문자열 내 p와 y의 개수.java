class Solution {
    boolean solution(String s) {
        
        boolean answer = true;

        int p_count = 0;
        int y_count = 0;
        
        s = s.toLowerCase();
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == 'p'){
                p_count++;
            }
            
            if(s.charAt(i) == 'y'){
                y_count++;
            }
        }
        
        if((p_count == y_count)){
            answer = true;
        }else if(p_count == 0 && y_count == 0){
            answer = true;
        }else{
            answer = false;
        }

        return answer;
    }
}