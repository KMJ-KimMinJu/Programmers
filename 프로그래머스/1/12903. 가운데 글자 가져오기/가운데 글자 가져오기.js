function solution(s) {
    
        if(s.length % 2 === 1){
            return s.substr(s.length/2,1);
        }else{
            return s.substr(s.length/2-1,2);
        }
}