import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        int index = 0;
        
        int people = 1;
        int turn = 1;
        
        HashMap<String, Integer> word = new HashMap<>();
        
        boolean check = true;
        
        while(index < words.length){
            
            if(people > n){
                people = 1;
                turn++;
            }
            
            //끝말잇기가 안 될 때
            if(index > 0){
                char current = words[index].charAt(0);
                char before = words[index-1].charAt(words[index-1].length()-1);
                
                if(current != before){
                    check = false;
                    break;
                }
            }
            
            //중복된 단어를 말했을 때
            if(word.containsKey(words[index])){ 
                check = false;
                break;
            }else{
                word.put(words[index], 0);
            }
            
            index++;
            people++;
        }

        if(!check){
            return new int[] {people, turn};
        }else{
            return new int[] {0,0};
        }

    }
}