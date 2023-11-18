function solution(left, right) {
    
    let sum = 0;
    
    for(let a = left; a<= right; a++){
        let count = 0;
        
        //약수 개수 구하기
        for(let i = 1; i<= a; i++){
            if(a % i == 0){
                count++;
            }
        }
        
        if(count % 2 == 0){
            sum += a;
        }else{
            sum -= a;
        }
    }
    
    return sum;
}