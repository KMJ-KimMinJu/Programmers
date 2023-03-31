class Solution {
    public String solution(String my_string) {
        
        //한 문자씩 읽어와서 아스키코드 사용한 다음 
        //스트링으로 대문자인지 아닌지 확인하고
        //toLowerCase(), toUpperCase() 사용해서 바꿔주기
        //65-90 A-Z
        //97-122 a-z
        
        String answer = "";
        
        for(int i = 0; i<my_string.length(); i++){
            char str = my_string.charAt(i);
            
            if(str >= 65 && str <= 90){
                answer += String.valueOf(str).toLowerCase();
            }
            else if (str >= 97 && str <= 122){
                answer += String.valueOf(str).toUpperCase();
            }
        }
        
        return answer;
    }
}