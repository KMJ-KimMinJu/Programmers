function solution(dartResult) {
    
    const check = /[0-9]/;
    let sum = 0;
    let result = [];
    let count = -1;
    
    for(let i = 0; i<dartResult.length; i++){
        
        if(check.test(dartResult[i])){
            
            if(dartResult[i+1] === '0'){
                sum += 10;
                i++
            }else{
                sum += (dartResult[i]);
            }
            result.push(sum);
            sum = 0;
            count++;
            continue;
        }
        
        if(dartResult[i] === 'D'){ //2제곱
            result[count] = Math.pow(result[count], 2);
        }else if(dartResult[i] === 'T'){ //3제곱
            result[count] = Math.pow(result[count], 3);
        }else if(dartResult[i] === '*'){ //스타상 --> 해당 점수와 바로 전에 얻은 점수 2배
            if(count === 0){
                result[count] *= 2;
            }else{
                result[count-1] *= 2;
                result[count] *= 2;
            }
        }else if(dartResult[i] === '#'){ //아차상 --> 해당 점수 -1배, 스타상과 중첩 가능
            result[count] *= -1;
        }
        
        
    }
    
    let answer = 0;
    
    for(let i of result){
        answer += parseInt(i);
    }
    
    return answer;
}