function solution(new_id) {
    
    //1단계
    new_id = new_id.toLowerCase();
    
    //2단계
    let type = /^[a-z0-9\-\_\.]*$/;
    new_id = new_id.split("").filter((id) => type.test(id)).join(""); 
    
    //3단계
    while(new_id.includes('..')){
        new_id = new_id.replaceAll('..', '.');
    }
    
    //4단계
    if(new_id.startsWith('.')){ //앞에 위치
        new_id = new_id.substr(1);
    }
    
    if(new_id.endsWith('.')){ //뒤에 위치
        new_id = new_id.substring(0, new_id.length-1);
    }
    
    //5단계
    if(new_id.length === 0){
        new_id = 'a';
    }
    
    //6단계
    if(new_id.length >= 16){
        new_id = new_id.substr(0, 15);
        
        if(new_id.endsWith('.')){
            new_id = new_id.substring(0, new_id.length-1);
        }
    }
    
    //7단계
    if(new_id.length <= 2){
        let last = new_id.substr(new_id.length-1);
        
        while(new_id.length < 3){
            new_id += last;
        }
    }
    
    return new_id;
    
}