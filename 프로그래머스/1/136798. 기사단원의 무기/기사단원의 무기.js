function divisor(number){ //약수의 개수 구해주기
    let count = 0;
    
    for(let i = 1; i <= Math.sqrt(number); i++){

        if(i * i == number){
            count++;
            continue;
        }
        
        if(number % i == 0){
            count+=2;
        }
        
    }
    
    return count;
}

function solution(number, limit, power) {
    
    let sum = 0; //무기 공격력의 합
    
    for(let i = 1; i <= number; i++){
        let d = divisor(i);
        
        if(d > limit){
            sum += power;
        }else{
            sum += d;
        }
    }
    
    return sum;
}