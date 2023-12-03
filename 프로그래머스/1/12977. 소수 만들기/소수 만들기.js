let sum = [];

function plus(nums, idx, number){
    
    for(let i = idx+1; i < nums.length; i++){
        
        if(nums.length - i < 2){
            break;
        }
        
        for(let j = i+1; j<nums.length; j++){
            sum.push(nums[i]+nums[j]+number);
        }
    }
}

function isPrime(a){
    if(a <= 3){
        return true;
    }
    
    let count = 0;
    
    for(let i = 1; i <= a; i++){
        if(a % i == 0){
            count++;
        }
    }
    
    if(count == 2){
        return true;
    }else{
        return false;
    }
}

function solution(nums) {
    
    for(let i = 0; i<nums.length; i++){
        
        if(nums.length-i < 3){
            break;    
        }
        
        plus(nums, i, nums[i]);
    }
    
    let answer = 0;
    
    for(let a of sum){
        if(isPrime(a))
            answer++;
    }
    
    
    return answer;
}

