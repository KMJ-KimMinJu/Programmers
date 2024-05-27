import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); 
        
        for (int i = 0; i < citations.length; i++) {
            
            //인덱스만큼 지났다면 이미 i번 이상 인용된 논문이 있다는 것
            int h = citations.length - i;
            
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}