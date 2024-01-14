function solution(ingredient) {
    
    let hamburger = [];
    
    let answer = 0;
    
    for(let a of ingredient){
        
        hamburger.push(a);
        
        if(hamburger.length >= 4){ //햄버거를 만들 수 있을만큼 재료가 쌓였을 때
            let len = hamburger.length
            if(hamburger[len-1] === 1 && hamburger[len-2] === 3 && hamburger[len-3] === 2 && hamburger[len-4] === 1){ //빵, 야채, 고기, 빵
                answer++;
                hamburger.pop();hamburger.pop();hamburger.pop();hamburger.pop(); //햄버거 만든 재료는 삭제
            }
        }
    }
    
    return answer;
}