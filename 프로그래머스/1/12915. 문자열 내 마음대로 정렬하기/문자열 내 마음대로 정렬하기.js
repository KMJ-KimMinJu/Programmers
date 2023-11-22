function solution(strings, n) {
    
    strings.sort();
    
     strings.sort((a,b) => {
       if(a[n].charCodeAt() == b[n].charCodeAt()){

           return a.charCodeAt()-b.charCodeAt();
       }else{
           return a[n].charCodeAt() - b[n].charCodeAt();
       } 
    });
    
    return strings;
}