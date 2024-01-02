function solution(X, Y) {
    
    let arr = [];
    let number = Array(10).fill(0);
    
    for(let j of Y){ //Y에서 각 숫자가 몇 번 나타나는지 확인
        number[Number(j)]++;
    }
    
    for(let a of X){ //X와 중복되는 숫자 확인
        if(number[Number(a)] === 0){
            continue;
        }
        
        arr.push(a);
        number[Number(a)]--;
    }

    if(arr.length != 0){
        let answer = arr.sort((a,b) => b > a ? 1 : -1).join(""); //내림차순 정렬
        
        answer = answer.replace(/(^0+)/, "");
        
        if(answer.length === 0){
            return "0"
        }
        
        return answer;
    }else{
        return "-1";
    }

}