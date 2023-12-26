function solution(N, stages) {
    
    let map = new Map();
    let fail = [];
    
    for(let i = 1; i<= N; i++){
        let stage_clear = 0;
        let stage_fail = 0;
        
        for(let j of stages){
            
            //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            if(j === i ){
                stage_fail++;
            }
            
            //스테이지에 도달한 플레이어 수
            if(i < j){
                stage_clear++;
            }
        }
        
        map.set(i, stage_fail/stage_clear);
    }

    let sortedMap = new Map([...map].sort((a, b) => b[1] - a[1])); //실패율 기준으로 내림차순 정렬
    
    //내림차순 정렬된 key값 가져오기
    for(let a of sortedMap){
        fail.push(a[0]);
    }
    
    return fail;
    
}