function solution(park, routes) {
    let robot=[-1,-1]
    let checker = 0;
    const rightEnd=park[0].length-1
    const downEnd=park.length
    
    park.forEach((item,index)=>{
        
        if(item.indexOf("S")!==-1){
            robot = [index,item.indexOf("S")] //로봇의 스타트 위치를 잡음
            return
        }
        
    })

    
    routes.forEach((item)=>{
        checker=1

        if(item[0]==="W"){
            
            if(robot[1]-parseInt(item[2]) > -1) {
                
                //넘어가는 경우를 걸러줌
                for(let i = 1 ; i <= item[2];i++){
                    if(park[robot[0]][robot[1]-i]==='X'){
                        //경로에 x있는지 체크해주고 
                        checker = -1
                        break;
                    }
                }
                
                if(checker===1){
                    robot=[robot[0],robot[1]-parseInt(item[2])]
                }
            } 
            
        }else if(item[0]==="E"){
            if(robot[1]+parseInt(item[2])<=rightEnd){
                for(let i = 1 ; i <= item[2];i++){
                    if(park[robot[0]][robot[1]+i]==='X'){
                        checker=-1
                        break;
                    }
                }
                if(checker===1){
                    robot=[robot[0],robot[1]+parseInt(item[2])]
                }
            } 
        }else if(item[0]==="N"){
            if(robot[0]-parseInt(item[2])>-1){
                for(let i = 1 ; i <= item[2];i++){
                    if(park[robot[0]-i][robot[1]]==='X'){
                        checker=-1
                        break;
                    }
                }
                if(checker===1){
                    robot=[robot[0]-parseInt(item[2]),robot[1]]
                }
            } 
        }else if(item[0]==="S"){
            if(robot[0]+parseInt(item[2])<downEnd){
                for(let i = 1 ; i <= item[2];i++){
                    if(park[robot[0]+i][robot[1]]==='X'){
                        checker=-1
                        break;
                    }
                }
                if(checker===1){
                    robot=[robot[0]+parseInt(item[2]),robot[1]]
                }
            } 
        }
        
                console.log(robot);
    })
    
    let answer = [robot[1], robot[0]];
    return robot;
}