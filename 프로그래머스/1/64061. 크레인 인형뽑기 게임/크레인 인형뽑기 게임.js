function solution(board, moves) {
    
        let answer = 0; //사라지는 인형 수
        let basket = []; //뽑은 인형 담는 바구니
        for(let i=0; i<moves.length; i++) {
            for(let j=0; j<board.length; j++) {
                if(board[j][moves[i]-1]!=0) { 
                    if(!(basket.length === 0)&& basket[basket.length-1]===board[j][moves[i]-1]) {
                        basket.pop();
                        answer += 2; //무조건 두 개씩 터지니까
                    }else {
                        basket.push(board[j][moves[i]-1]);//비구니에 인형이 하나도 없거나, 같은 인형이 없으면 바구니에 인형 추가
                    }
                    board[j][moves[i]-1]=0; //인형 빼감
                    break;
                }
            }
        }
        return answer;
}