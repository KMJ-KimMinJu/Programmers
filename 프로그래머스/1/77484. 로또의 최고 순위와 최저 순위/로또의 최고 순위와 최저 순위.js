function solution(lottos, win_nums) {
    const score = [6,6,5,4,3,2,1]; //등수 표현
    
    let same_number = 0;
    let zero_count = 0;
    
    for(let i = 0; i<lottos.length; i++){
        
        if(lottos[i] === 0){
            zero_count++;
            continue;
        }
        
        for(let j = 0; j<win_nums.length; j++){
            if(lottos[i] === win_nums[j]){
                same_number++;
            }
        }

    }
    
    let answer = [score[same_number+zero_count], score[same_number]];
    
    return answer;
}