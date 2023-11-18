function solution(n) {
    
    //parseInt('변환시키고자하는 문자열', 해당 수의 진수);
    //다른 진수의 수 -> 10진수
    const answer = parseInt(n.toString(3).split('').reverse().join(''),3)

    return answer;

}