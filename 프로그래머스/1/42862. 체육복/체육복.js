function solution(n, lost, reserve) {
    
    let clothes = Array(n+2).fill(0); //체육복이 모두 있는 상태
    
    lost.sort((a,b) => a-b);
    reserve.sort((a,b) => a-b);
    
    for(let i of lost){ //도난
        clothes[i]--;
    }
    
    for(let i of reserve){ //여벌
        clothes[i]++;
    }
    
        
    let answer = 0;
    
    for(let i = 1; i<=n; i++){
        if(clothes[i] === -1){ //도난당한 학생       
            if(clothes[i-1] === 1){ //앞번호
                clothes[i]++;
                clothes[i-1]--;
            }else if(clothes[i+1] === 1){ //뒷번호
                clothes[i]++;
                clothes[i+1]--;
            }
        }

        if(clothes[i] >= 0){
            answer++;
        }
    }

    
    return answer;
}