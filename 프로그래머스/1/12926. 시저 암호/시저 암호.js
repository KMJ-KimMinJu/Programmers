function solution(s, n) {
    
    let str = [];
    
    for(let i = 0; i<s.length; i++){
        let num = s.charCodeAt(i);

        if(num === 32){
            str.push(String.fromCharCode(num));
            continue;
        }
        
        if(num >= 65 && num <= 90){
            num = (((num+n)-65)%26)+65;
        }else if(num >= 97 && num <= 122){
            num = (((num+n)-97)%26)+97;
        }

        str.push(String.fromCharCode(num));
    }
    
    return str.join("");
    
}