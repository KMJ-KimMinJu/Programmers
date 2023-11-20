function solution(s) {
    
    let s_arr = s.split("");
    let arr = [];
    let answer = [];
    
    for(let i = 0; i<s.length; i++){
        let temp = s_arr[i];
        
        if(arr.lastIndexOf(temp) != -1){
            answer.push(i-arr.lastIndexOf(temp));
        }else{
            answer.push(-1);
        }
        
        arr.push(temp);
    }
    
    return answer;
};