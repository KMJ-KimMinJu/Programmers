function solution(array, commands) {
    
    //[i,j,k] i번째에서 j번째까지 array 자르고, 자른 배열에서 k번째 수 가져오기
    
    let result = [];
    
    for(let a = 0; a < commands.length; a++){
        let i = commands[a][0]; 
        let j = commands[a][1];
        let k = commands[a][2];
        
        if(i == j){
            result.push(array[i-1]);
        }else{
            let temp = array.slice(i-1, j);
            temp.sort((a,b) => a-b);
            result.push(temp[k-1]);
        }
    }
    
    return result;
}