function solution(k, m, score) {
    
    //내림차순 정렬
    score.sort( (a,b) => b-a);
    let apple = [];
    let answer = 0;
    
    //가능한 많은 사과를 팔기 위해 m개의 사과가 담긴 박스가 만들어질 때까지 for문 돌리기
    for(let i = m-1; i < score.length; i+=m){
        answer += score[i]*m;
    }
    
    return answer;
}