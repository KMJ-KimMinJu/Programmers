function solution(answers) {
    
    const number = [[1,2,3,4,5], [2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]; //수포자들의 답
    
    let sum = [0,0,0]
    
    for(let i= 0; i<3; i++){
        let length = number[i].length;
        for(let j = 0; j<answers.length; j++){
            if(answers[j] === number[i][j%length]){
                sum[i]++;
            }
        }
    }
    
    const max = Math.max(...sum);
    let student = [];
    
    if(max === sum[0]){
        student.push(1);
    }
    
    if(max === sum[1]){
        student.push(2);
    }
        if(max === sum[2]){
        student.push(3);
    }
    
    return student;
}