class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if(direction.equals("left")){
            //왼쪽
            answer[numbers.length-1] = numbers[0];
            for(int i = 1; i<numbers.length; i++)
                answer[i-1] = numbers[i];
        }
        else if(direction.equals("right")){
            //오른쪽
            answer[0] = numbers[numbers.length-1];
            for(int i = 1; i<numbers.length; i++)
                answer[i] = numbers[i-1];
        }
        
        return answer;
        }
    
        
    
    }