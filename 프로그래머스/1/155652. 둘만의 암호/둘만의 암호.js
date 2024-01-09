function solution(s, skip, index) {
    
    let answer = [];
    
    for(let str of s){
        
        let char = str.charCodeAt();
        let count = 0;
        
        while(count < index){
            
            char+=1;
            
            if(char > 122){
                char = 97;
            }
            
            let char_str = String.fromCharCode(char);
            
            if(skip.includes(char_str)){
                continue;
            }else{
                count++;
            }
        }
        
        answer.push(String.fromCharCode(char));
    }
    
    return answer.join("");
}