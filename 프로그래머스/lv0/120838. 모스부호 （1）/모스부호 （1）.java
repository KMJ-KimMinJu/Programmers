import java.util.Arrays;

class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...", "-.-.", "-..",".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",                 "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    
        String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        String answer[] = letter.split(" ");
        String str = "";
        for(int i = 0 ; i <answer.length; i++){
            int index = Arrays.asList(morse).indexOf(answer[i]);
            str += alpha[index];
        }
        
        return str;
    
    }
}