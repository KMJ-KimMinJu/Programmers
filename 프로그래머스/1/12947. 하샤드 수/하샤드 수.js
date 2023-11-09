function solution(x) {
    
    let str = x.toString();
    
    let sum = 0;
    
    for(const s of str){
        sum += Number(s);
    }
    
    if(x % sum === 0){
        return true;
    }else {
        return false;
    }
    
}