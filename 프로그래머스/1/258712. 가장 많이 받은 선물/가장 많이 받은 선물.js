function solution(friends, gifts) {
    
    let gift = new Map(); //선물 주고 받은 사람 기록
    let giftPoint = new Map();
    let result = new Map();
    
    for(let name of friends){
        gift.set(name, new Map());
        giftPoint.set(name, 0);
        result.set(name, 0);
    }
    
    for(let i = 0; i<friends.length; i++){
        
        let friend = gift.get(friends[i]);
        
        for(let j = 0; j<friends.length; j++){
            if(i === j){
                continue;
            }
            
            friend.set(friends[j], 0);
        }

    }
    
    for(let a of gifts){
        let history = a.split(" ");
        let giver = history[0];
        let taker = history[1];
        
        giftPoint.set(giver, giftPoint.get(giver)+1);
        giftPoint.set(taker, giftPoint.get(taker)-1);
        
        let takerInfo = gift.get(giver);
        takerInfo.set(taker, takerInfo.get(taker)+1);

    }
    
    for(let i = 0; i<friends.length; i++){
        let giver = friends[i];
        
        for(let j = i+1; j < friends.length; j++){
            let taker = friends[j];
            
            let giverInfo = gift.get(giver);
            let takerInfo = gift.get(taker);

            let countGiver = giverInfo.get(taker);
            let countTaker = takerInfo.get(giver);
            
            if(countGiver > countTaker){
                result.set(giver, result.get(giver)+1);
            }else if(countGiver < countTaker){
                result.set(taker, result.get(taker)+1);
            }else {
                let giverPoint = giftPoint.get(giver);
                let takerPoint = giftPoint.get(taker);
                
                if(giverPoint > takerPoint){
                   result.set(giver, result.get(giver)+1);
                }else if(giverPoint < takerPoint){
                    result.set(taker, result.get(taker)+1);
                }else {
                    continue;
                }
            }
        }
    }

    let max = Math.max(...result.values());
    
    return max;
}