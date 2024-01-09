import java.util.*;

class Solution {
    public String solution(String s) {

    
        s = s.toLowerCase();
        String[] str = s.split("");
        
        for(int i = 0; i<str.length; i++){

            if(i == 0){
                if(s.charAt(0) >= 48 && s.charAt(0)<=57){ //첫글자가 숫자라면
                    continue;
                }else{
                    str[0] = String.valueOf((char)(s.charAt(0)-32));
                }
            }else{
                if(s.charAt(i-1) == 32){ //공백 다음 
                    if(s.charAt(i) == 32){
                        continue;
                    }else{
                        if(s.charAt(i) >= 48 && s.charAt(i)<=57){ //첫글자가 숫자라면
                            continue;
                        }else{
                            str[i] = String.valueOf((char)(s.charAt(i)-32));
                        }
                    }
                }
            }

        }
        
        return String.join("", str);
    }
}