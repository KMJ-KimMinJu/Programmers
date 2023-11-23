function solution(name, yearning, photo) {
    
    let score = [];
    
    for(let i = 0; i<photo.length; i++){
        let sum = 0;
        
        for(let j = 0; j<name.length; j++){
            if(photo[i].includes(name[j])){
                sum += yearning[name.indexOf(name[j])];
            }else{
                sum += 0;
            }
        }
        
        score.push(sum);
    }
    
    return score;
}