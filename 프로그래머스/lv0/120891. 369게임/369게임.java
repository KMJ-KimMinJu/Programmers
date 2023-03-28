class Solution {
    public int solution(int order) {
        String od = String.valueOf(order);    
        int answer = 0;
        for(int i = 0; i<od.length(); i++){
            if(od.charAt(i) == '3' || od.charAt(i) == '6' || od.charAt(i) == '9')
                answer += 1;
        }
        return answer;
    }
}