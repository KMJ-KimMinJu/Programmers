function solution(keymap, targets) {
    
    let answer = [];
    
    for(let target of targets){
        
        let count = 0;
        
        for(let key of target.split("")){
            let min = 1000000000;
            
            for(let board of keymap){
                if(board.includes(key)){
                    min = Math.min(min, board.indexOf(key)+1); //keymap 중에서 가장 작은 번호의 자판만 가져옴
                }
            }
            
            if(min === 1000000000){ //min값이 변하지 않았다는 건 keymap에 자판이 존재하지 않음
                count = -1;
                break;
            }
        
            count+= min;
        }
        
        answer.push(count);

    }
    
    return answer
}