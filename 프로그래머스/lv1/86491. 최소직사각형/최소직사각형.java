class Solution {
    public int solution(int[][] sizes) {

        int max_width = 0;
        int max_height = 0;
        
        for(int i = 0; i<sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            max_width = Math.max(max_width, w);
            max_height = Math.max(max_height, h);
        }
        
        
        return max_width * max_height;
    }
}