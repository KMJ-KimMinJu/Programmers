function solution(survey, choices) {
    
    let score = [3,2,1,0,1,2,3];
    
    let test = new Map();
    
    for(let i = 0; i<survey.length; i++){
        let a = survey[i].split("");
        
        for(let s of a){
            if(!test.has(s)){
                test.set(s,0);
            }
        }
        
        if(choices[i] > 4){
            test.set(a[1], test.get(a[1])+score[choices[i]-1]);

        }else if(choices[i] < 4){
            test.set(a[0], test.get(a[0])+score[choices[i]-1]);
        }
    }
    
    let key = test.keys();

    let temp = '';
    
    for(let a of key){
        
        if(a === 'T'){
            
            if(temp.includes('R') || temp.includes('T')){
                continue;
            }
            
            if(test.get('T') < test.get('R')){
                temp+='R';
            }else if(test.get('T') > test.get('R')){
                temp+='T';
            }else {
                temp+='R';
            }
            
        }else if(a === 'R'){
            
            if(temp.includes('R') || temp.includes('T')){
                continue;
            }
            
            if(test.get('T') < test.get('R')){
                temp+='R';
            }else if(test.get('T') > test.get('R')){
                temp+='T';
            }else {
                temp+='R';
            }
            
        }else if(a === 'C'){
            
            if(temp.includes('F') || temp.includes('C')){
                continue;
            }
            
            if(test.get('C') < test.get('F')){
                temp+='F';
            }else if(test.get('C') > test.get('F')){
                temp+='C';
            }else {
                temp+='C';
            }
            
            
        }else if(a === 'F'){
            
            if(temp.includes('C') || temp.includes('F')){
                continue;
            }
            
            if(test.get('C') < test.get('F')){
                temp+='F';
            }else if(test.get('C') > test.get('F')){
                temp+='C';
            }else {
                temp+='C';
            }
            
            
        }else if(a === 'M'){
            
            if(temp.includes('J') || temp.includes('M')){
                continue;
            }
            
            if(test.get('M') < test.get('J')){
                temp+='J';
            }else if(test.get('M') > test.get('J')){
                temp+='M';
            }else {
                temp+='J';
            }
            
            
        }else if(a === 'J'){
            
            if(temp.includes('J') || temp.includes('M')){
                continue;
            }
            
            if(test.get('M') < test.get('J')){
                temp+='J';
            }else if(test.get('M') > test.get('J')){
                temp+='M';
            }else {
                temp+='J';
            }
            
            
        }else if(a === 'N'){
            
            if(temp.includes('A') || temp.includes('N')){
                continue;
            }
            
            if(test.get('N') < test.get('A')){
                temp+='A';
            }else if(test.get('N') > test.get('A')){
                temp+='N';
            }else {
                temp+='A';
            }
            
            
        }else if(a === 'A'){
            
            if(temp.includes('A') || temp.includes('N')){
                continue;
            }
            
            if(test.get('N') < test.get('A')){
                temp+='A';
            }else if(test.get('N') > test.get('A')){
                temp+='N';
            }else {
                temp+='A';
            }
        }
        
    }
    
    
    let answer = Array(4).fill(null);
    
    //정렬
    for(let string of temp){
        if(string === 'R' || string === 'T'){
            answer[0] = string;
        }else if(string === 'C' || string === 'F'){
            answer[1] = string;
        }else if(string === 'M' || string === 'J'){
            answer[2] = string;
        }else if(string === 'A' || string === 'N'){
            answer[3] = string;
        }
    }
    
    //null값 채워주기
    for(let i = 0; i<answer.length; i++){
        if(answer[i] === null){
            if(i === 0){
                answer[i] = 'R'
            }else if(i === 1){
                answer[i] = 'C'
            }else if(i === 2){
                answer[i] = 'J'
            }else if(i === 3){
                answer[i] = 'A'
            }
        }
    }
    return answer.join("");
}