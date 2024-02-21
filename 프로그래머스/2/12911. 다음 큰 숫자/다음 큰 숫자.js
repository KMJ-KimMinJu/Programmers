function solution(n) {
    
    let n_count = (n.toString(2)).match(/1/g).filter(item => item !== '').length;
    
    let number = n+1;
    
    while(true){
        let count = (number.toString(2)).match(/1/g).filter(item => item !== '').length;
        
        if(count === n_count){
            break;
        }
        
        number++;
    }
    
    return number;
}