function solution(d, budget) {
    
    d.sort((a, b) => a - b);
    
    let sum = 0;
    let answer = 0;
    
    for(const a of d){
        sum += a;
        answer++;
        
        if(sum > budget){
            answer--;
            break;
        }
    }
    
    return answer;
}