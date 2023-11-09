function solution(arr, divisor) {
    let answer = [];
    
    for(const s of arr){
        
        if(s % divisor === 0){
            answer.push(s);
        }
    }
    
    if(answer.length === 0){
        answer.push(-1);    
    }
    
    
    return answer.sort(function(a,b) {return a-b});
}