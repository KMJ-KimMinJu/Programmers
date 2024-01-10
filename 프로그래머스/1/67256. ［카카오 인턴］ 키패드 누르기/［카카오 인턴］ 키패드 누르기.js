function solution(numbers, hand) {
  
        let answer = [];
        
        let left = 10; //왼손 시작 위치
        let right = 12; //오른손 시작 위치

        for(let i= 0; i<numbers.length; i++){
            
            //147은 무조건 왼
            if(numbers[i] === 1 || numbers[i] === 4 || numbers[i] === 7){
                answer.push('L');
                left = numbers[i];

            //369는 무조건 오
            }else if(numbers[i] === 3 || numbers[i] === 6 || numbers[i] === 9){
                answer.push('R');
                right = numbers[i];

            }else {
                if(numbers[i] === 0){
                    numbers[i] += 11;
                }
                
                //숫자로부터 왼손과 오른손의 거리
                let l_hand = parseInt((Math.abs(numbers[i]-left))/3 + (Math.abs(numbers[i]-left))%3); 
                let r_hand = parseInt((Math.abs(numbers[i]-right))/3 + (Math.abs(numbers[i]-right))%3);
                
                if(l_hand === r_hand){ //왼손과 오른손의 거리가 같다면
                    if(hand === 'right'){ //오른손잡이
                        answer.push('R');
                        right = numbers[i];
                    }else{
                        answer.push('L'); //왼손잡이
                        left = numbers[i];
                    }
                }else if(l_hand > r_hand){
                        answer.push('R') ;
                        right = numbers[i];
                }else{
                        answer.push('L');
                        left = numbers[i];
                }
            }
        }
        
        return answer.join("");
}