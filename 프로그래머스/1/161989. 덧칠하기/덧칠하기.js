function solution(n, m, section) {
    
    let wall = Array(n+1);
    
    wall.fill(false);
     
    let index = 0;
    let count = 0;
    
    for(let i = 0; i<section.length; i++){
        let number = section[i];
        
        if(!wall[number]){
            count++;
            wall.fill(true, number, number+m);
        }
    }
    
    
    return count;
}