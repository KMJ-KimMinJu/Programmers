function coke(a,b,n,bottle){ //a,b,남은 콜라,바꿔마신 콜라
    
    if(n < a){
        return bottle;
    }
    
    bottle += parseInt(n/a)*b;
    n = parseInt(n/a)*b+(n%a);
    
    return coke(a,b,n,bottle);
}

function solution(a, b, n) {
    
    return coke(a,b,n,0)
}