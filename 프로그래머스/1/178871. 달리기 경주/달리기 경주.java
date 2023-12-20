import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<Integer, String> score = new HashMap<>(); //등수
        HashMap<String, Integer> play = new HashMap<>(); //선수
        
        int val = 0; //현재 등수 
        
        for (String player : players){
            play.put(player, val);
            score.put(val, player);
            val++;
        }
        
        //몇 번 불리는지 확인
        for(String call : callings){

            int targetValue = play.get(call) - 1;  // 부른 이름 앞 등수
            String targetKey = score.get(targetValue); // 부른 사람 앞 이름

            play.put(targetKey, play.get(targetKey) + 1); // 부른 사람의 앞 등수 +1
            play.put(call, play.get(call) - 1); // 부른 사람 -1

            score.put(targetValue, call);
            score.put(targetValue + 1, targetKey);
        }
        
        String[] answer = new String[players.length];
        
        
        for(String key : play.keySet()) {
            answer[play.get(key)] = key;
        }
        
        return answer;
    }
}