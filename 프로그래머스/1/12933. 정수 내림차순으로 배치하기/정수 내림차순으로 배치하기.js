function solution(n) {
    
    n = n+'';
    
    const str = n.split("");
    
    let answer = '';
    
    str.sort(function(a, b) {return b-a})
    for(const i of str){
        answer += i;
    }
    
    return Number(answer);
}