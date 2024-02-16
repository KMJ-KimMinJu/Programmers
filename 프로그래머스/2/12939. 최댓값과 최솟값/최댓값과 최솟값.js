function solution(s) {
    
    let str_num = s.split(" ");
    
    let number = str_num.map(Number);
    
    let max = Math.max(...number);
    let min = Math.min(...number);
    
    return min + " " + max
}