class Solution {
    public int solution(int n) {
        int count = 0;
        int answer = 0;
        
        for(int j = 1; j<=n; j++){
            for(int i = 1; i<=j; i++){
                if(j%i == 0){
                    count += 1;
                }
            }
            
            if(count >= 3){
                answer += 1;
                count = 0;
            }
            else
                count = 0;
            
        }
        
        return answer;

    }
}