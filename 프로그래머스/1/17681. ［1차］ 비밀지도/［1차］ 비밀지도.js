function solution(n, arr1, arr2) {
    
    let arr1_binary = [];
    let arr2_binary = [];
    let map = [];
    
    //2진수로 변환
    for(let i = 0; i < n; i++){
        arr1_binary.push(arr1[i].toString(2).padStart(n,'0'));
        arr2_binary.push(arr2[i].toString(2).padStart(n,'0'));
    }

    for(let i = 0; i < n ; i++){
        let temp1 = arr1_binary[i].split("");
        let temp2 = arr2_binary[i].split("");
        let str = '';
        
        for(let j = 0; j < n; j++){ //0 --> 공백, 1 --> 벽
            if(temp1[j] === '0' && temp2[j] === '0'){
                str += " ";
            }else{
                str += "#";
            }
        }
        map.push(str);
    }
    
    return map;
}