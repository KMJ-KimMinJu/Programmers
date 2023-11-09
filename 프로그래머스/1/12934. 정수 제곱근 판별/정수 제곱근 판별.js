function solution(n) {
    
    
    const answer = Math.floor(Math.sqrt(n));
    
    if(Math.pow(answer, 2) === n){
        return Math.pow(answer+1, 2);
    }else{
        return -1;
    }
}