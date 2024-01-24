function toDay(date) {
        let day = date.split(".");
        
        let year = parseInt(day[0]);
        let month = parseInt(day[1]);
        let dayOfMonth = parseInt(day[2]);

        let totalDays = (year * 12 + month) * 28 + dayOfMonth;

        return totalDays;
}

function solution(today, terms, privacies) {
    
        let answer = [];
        
        for(let i = 0; i<privacies.length; i++){
            let pri = privacies[i].split(" ");
            
            let start_date = toDay(pri[0]); //개인정보 수집 일자
            for(let term of terms){
                
                let te = term.split(" "); // te[0] 약관 종류, te[1] 유효기간
                
                if (te[0]===(pri[1]) && ((start_date + parseInt(te[1]) * 28) <= toDay(today))){
                    answer.push(i+1);
                }
            }
            
        }
        return answer;
}

