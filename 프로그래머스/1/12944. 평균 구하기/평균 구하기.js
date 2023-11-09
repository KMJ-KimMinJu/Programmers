function solution(arr) {
    
    let sum = 0;
    
    arr.forEach(number => sum = sum + number);
    
    return sum/arr.length;
}