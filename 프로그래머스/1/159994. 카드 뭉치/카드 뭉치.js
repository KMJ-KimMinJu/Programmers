function solution(cards1, cards2, goal) {
    
    //goal에 있는 문자열을 카드로 인덱스 확인을 하고
    //앞에 있는 문자열이 똑같은 카드 배열이고, 더 뒤의 인덱스 번호를 가지고 있다면 no

    let index = 0; //이전 인덱스
    let isCheck = false;

    for(let i = 0; i < cards1.length; i++){
        let msg = cards1[i];
        
        if(!goal.includes(msg)){
            isCheck = true;
            continue;
        }
        
        if(!isCheck){
            if(goal.indexOf(msg) < index){
                return "No";       
            }
            index = goal.indexOf(msg);
        }else{
            return "No"
        }
        
    }
    
    index = 0;
    isCheck = false;
    
    for(let i = 0; i < cards2.length; i++){
        let msg = cards2[i];
        
            if(!goal.includes(msg)){
                isCheck = true;
                continue;
        }
        
        if(!isCheck){
            if(goal.indexOf(msg) < index){
                return "No";       
            }
            index = goal.indexOf(msg);
        }else{
            return "No"
        }
    }
    
    return "Yes";
}