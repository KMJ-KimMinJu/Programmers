function solution(t, p) {
    
    const length = t.length-p.length;
    const p_length = p.length;
    const t_length = t.length;
    
    let arr = [];
    
    for(let i = 0; i <= length; i++){
        arr.push(t.slice(i, i+p_length));
    }
    
    let count = 0;
    let int_p = Number(p);

    for(let i = 0; i < arr.length; i++){
        if(Number(arr[i]) <= int_p){
            count++;
        }
    }
    
    return count;
}