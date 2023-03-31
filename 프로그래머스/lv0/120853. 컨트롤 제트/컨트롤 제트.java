class Solution {
    public int solution(String s) {
        
        //뒤에 있는 숫자가 Z인지 아닌지 판별하기
        //
        int answer = 0;
        String[] str = s.split(" ");
        for(int i = 0; i<str.length-1; i++){
            if((str[i+1].equals("Z")) || str[i].equals("Z")){
                continue;
            }else{
                answer += Integer.parseInt(str[i]);
            }
        }
               
        if(!(str[str.length-1].equals("Z"))){
            answer += Integer.parseInt(str[str.length-1]);
        }
            return answer;
    }
}