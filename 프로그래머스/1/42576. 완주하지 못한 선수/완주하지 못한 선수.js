function solution(participant, completion) {
    
    let people = new Map();
    
    for(let a of participant){
        if(!people.has(a)){
            people.set(a, 1);
        }else{
            people.set(a, people.get(a)+1); //중복되는 이름 체크
        }
    }
    
    
    for(let a of completion){
        people.set(a, people.get(a)-1);
    }
    
    let answer = '';
    
    people.forEach((value, key) => {

        if(value > 0){
            answer = key;
        }
    });
    
    return answer;
}