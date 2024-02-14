function solution(bandage, health, attacks) {

    let current_health = health;
    let time = 1;
    
    for(let i of attacks){
        
        let count = i[0]-time-1;
        
        if(count > 0){
            current_health += parseInt((count/bandage[0])) * bandage[2];
            current_health += (count * bandage[1]);
        }
        
        if(current_health> health){
            current_health = health;
        }
        
        current_health -= i[1];
        
        if(current_health <= 0){
            return -1;
        }
        
        time = i[0];
    }
    
    return current_health;
}