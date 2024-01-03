function solution(s) {
    
    let same_count = 0; //x와 같은 문자 개수
    let different_count = 0; //x와 다른 문자 개수
    let answer = 0;
    
    let x = '';
    let check = true;
    
    for(let a of s.split("")){
        
        if(check){
            x = a;
            check = false;
        }
        
        if(x === a){
            same_count++;
        }else{
            different_count++;
        }
        
        if(same_count === different_count){ //개수가 같을 때
            check = true;
            same_count = 0;
            different_count = 0;
            answer++;
        }
    }
    
    return (same_count === 0 && different_count ===0)? answer: answer+1;
}