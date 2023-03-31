class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        int idx = code-1;
        
        for(int i = idx; i<cipher.length(); i+= code){
            answer += String.valueOf(cipher.charAt(i));
        }
        return answer;
    }
}