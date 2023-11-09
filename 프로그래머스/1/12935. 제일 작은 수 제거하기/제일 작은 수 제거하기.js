function solution(arr) {
    
    let minValue = Math.min(...arr);
    
    arr.splice(arr.indexOf(minValue),1);
    
    if(arr.length === 0){
        arr.push(-1);
    }
    
    return arr
}