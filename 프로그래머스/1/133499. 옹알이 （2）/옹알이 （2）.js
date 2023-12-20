function solution(babbling) {
    
    let count = 0;
    
    for(let str of babbling){
        
        if(str.includes('ayaaya') || str.includes('yeye') || str.includes('woowoo') || str.includes('mama')){
            continue;
        }
        
        str = str.replaceAll('aya', 'true');
        str = str.replaceAll('ye', 'true');
        str = str.replaceAll('ma', 'true');
        str = str.replaceAll('woo', 'true');
        str = str.replaceAll('true', '');
                
        if(str.length == 0){
            count++;
        }
    }
    
    return count;
}