function solution(n) {
    let watermelon = '';
    
    for(let i = 0; i<n; i++){
        if(i%2 === 1){
            watermelon += '박';
        }else{
            watermelon += '수';
        }
    }
    
    return watermelon;
}