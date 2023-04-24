import java.util.regex.Pattern;

class Solution {
    public int solution(String[] babbling) {
        //정규표현식 사용
        int count = 0;
        
        for(int i = 0; i<babbling.length; i++){


                babbling[i] = babbling[i].replace("aya", "true");
        

                babbling[i] = babbling[i].replace("ye", "true");
            
     
                babbling[i] = babbling[i].replace("ma", "true");
            
                babbling[i] = babbling[i].replace("woo", "true");
            
            System.out.println(babbling[i]);
            babbling[i] = babbling[i].replace("true", "");
            
            if(babbling[i].length() == 0){
                count += 1;
            }
            
        }
        
        return count;
    }
}
