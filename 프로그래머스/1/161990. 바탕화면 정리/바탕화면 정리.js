function solution(wallpaper) {
        
        //드래그 한 거리 |rdx - lux| + |rdy - luy|
        //lux < rdx, luy < rdy
        
        let rdx=-1; let rdy=-1; let lux = 100; let luy=100;
        
        for(let i= 0; i<wallpaper.length; i++){
            let wall = wallpaper[i];
            
            for(let j = 0; j<wall.length; j++){
                if(wall[j] === '#'){
                    
                    //드래그의 시작점(인덱스가 제일 작음)과 끝점(인덱스가 제일 큼)을 구해주기
                    lux = (lux > i)? i : lux;
                    luy = (luy > j) ? j : luy;;
                    
                    rdx = (rdx < i)? i : rdx
                    rdy = (rdy < j) ? j : rdy;
                }
            }
        }
        
        let answer = [lux, luy, rdx+1, rdy+1];
        
        return answer;
}