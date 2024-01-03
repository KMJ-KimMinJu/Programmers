function solution(keymap, targets) {
    
    let answer = [];
    
    for(let target of targets){
        
        let count = 0;
        
        outloop: for(let key of target.split("")){
            let min = 1000000000;
            
            for(let board of keymap){
                if(board.includes(key)){
                    min = Math.min(min, board.indexOf(key)+1);
                }
            }
            
            if(min === 1000000000){
                count = -1;
                break;
            }
        
            count+= min;
        }
        
        answer.push(count);

    }
    
    return answer
}