function solution(sizes) {
    
    let max_width = 0, max_height = 0;
    
    for(let i= 0; i<sizes.length; i++){
        let width = Math.max(sizes[i][0], sizes[i][1]);
        let height = Math.min(sizes[i][0], sizes[i][1]);
        
        max_width = Math.max(width, max_width);
        max_height = Math.max(height,max_height);
    }
    
    return max_height * max_width;
}