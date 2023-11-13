class Solution {
    public int solution(String dartResult) {
    int answer = 0;
      
      char[] dart = dartResult.toCharArray();
      int[] result = new int[3];
      
      int sum = 0; // 각 다트 점수 합
      int dartCnt = 0; // 다트 수 1 2 3
      
      for(int i=0; i<dartResult.length(); i++) {
          if(Character.isDigit(dart[i])) { // 숫자일 경우
              if(i!=0) {
                  result[dartCnt++] = sum;
              }
              if((int)dart[i+1] == '0') { // 10일 경우
                  sum = 10;
                  i++; // 다음 단계 pass
                  continue;
              }
              else
                  sum = dart[i] - '0';
          }
          
          if(dart[i] == 'S') {
              ;
          }
          else if(dart[i] == 'D') {
              sum *= sum;
          }
          else if(dart[i] == 'T') {
              sum = (int)Math.pow(sum, 3); // Math.pow의 리턴형은 double
          }
          else if(dart[i] == '*') {
              sum *= 2;
              if(dartCnt != 0) { // 바로 앞에꺼도 2배
                  result[dartCnt-1] *= 2;
              }
          }
          else if(dart[i] == '#') {
              sum *= -1;
          }
          
          if(i==dartResult.length()-1 && dartCnt==2) // 마지막
              result[dartCnt] = sum;
      }
        
      // 다 더함
      for(int i : result) {
          answer += i;
      }
      return answer;
    }
}