import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int current_health = health;
        
        int count =1; //현재 시간

        for(int i=0; i < attacks.length; i++){
            
            int rest = attacks[i][0]-count-1;
            
//             System.out.println(rest);
            
            if(rest > 0){
                current_health += (int)rest/bandage[0] * bandage[2];
                current_health += (rest*bandage[1]);
            }
            
            if(current_health >= health){
                current_health = health;
            }
            
            count = attacks[i][0];
            current_health -= attacks[i][1];
                
            if(current_health <= 0){
                return -1;
            }
            
            // System.out.println(current_health + "b");
        }

        return current_health;
    }
}