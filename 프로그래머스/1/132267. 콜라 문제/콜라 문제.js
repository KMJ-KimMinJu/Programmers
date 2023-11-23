function solution(a, b, n) {
    
    let count = 0;
    
    while(true){
        let rest = (n%a);
        count += parseInt(n/a)*b;
        n = parseInt(n/a)*b + rest;
        
        if(n < a){
            break;
        }
    }
    
    return count;
}