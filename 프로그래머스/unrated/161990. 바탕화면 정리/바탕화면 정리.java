class Solution {
    public int[] solution(String[] wallpaper) {
        
        //드래그 한 거리 |rdx - lux| + |rdy - luy|
        //lux < rdx, luy < rdy
        
        int rdx=-1; int rdy=-1; int lux = 100; int luy=100;
        
        for(int i= 0; i<wallpaper.length; i++){
            String wall = wallpaper[i];
            
            for(int j = 0; j<wall.length(); j++){
                if(wall.charAt(j) == '#'){
                    
                    lux = (lux > i)? i : lux;
                    rdx = (rdx < i)? i : rdx;
                    
                    luy = (luy > j)? j : luy;
                    rdy = (rdy < j) ? j : rdy;
                }
            }
        }
        
        int[] answer = {lux, luy, rdx+1, rdy+1};
        
        return answer;
    }
}