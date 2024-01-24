function solution(players, callings) {
        
        let score = new Map(); //등수
        let play = new Map(); //선수
        
        let val = 0; 
        
        for (let player of players){
            play.set(player, val);
            score.set(val, player);
            val++;
        }
        
        //몇 번 불리는지 확인
        for(let call of callings){

            let targetValue = play.get(call) - 1;  // 부른 이름 앞 등수
            let targetKey = score.get(targetValue); // 부른 사람 앞 이름

            play.set(targetKey, play.get(targetKey) + 1); // 부른 사람의 앞 등수 +1
            play.set(call, play.get(call) - 1); // 부른 사람 -1

            score.set(targetValue, call);
            score.set(targetValue + 1, targetKey);
        }
        
        let answer = [];
        
        
        for(let key of play.keys()) {
            answer[play.get(key)] = key;
        }
        
        return answer;
}