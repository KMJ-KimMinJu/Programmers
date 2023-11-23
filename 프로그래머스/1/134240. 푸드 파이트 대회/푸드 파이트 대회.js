function solution(food) {
    
    //물은 무조건 중간에
    //짝수인 음식은 /2 하면 됨
    //홀수 음식도 무조건 /2 하기 ==> 문자열로 해서 뒤집기 중간에는 0 포함
    
    
    let answer = '';
    
    for(let i = 1; i<food.length; i++){
        let temp = food[i];
        
        if(parseInt(temp/2) == 0){
            continue;
        }
        answer += String(i).repeat(parseInt(temp/2));
    }
    
    return answer+'0'+answer.split("").reverse().join("");
}