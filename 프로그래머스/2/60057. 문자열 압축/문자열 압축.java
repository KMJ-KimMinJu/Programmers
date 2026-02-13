class Solution {
public static int solution(String s) {

        //가장 작은 문자열의 길이를 return

        int min = s.length(); //우선 제일 최소 길이는 s 자체의 길이임

        for(int i = s.length(); i > 0; i--){

            int test = zipper(i, s);

            if(min > test){
                min = test;
            }
        }

        return min;
    }

    public static int zipper(int i, String s){

        //계속해서 저장과 수정을 해야 하기 때문에 StringBuilder 사용
        StringBuilder sb = new StringBuilder(s); //원본 문자열 저장
        StringBuilder answer = new StringBuilder(); //압축 문자열 저장 

        int start = 0;
        int end = 0+i;
        int count = 1;

        while(true) {
            
            if (end + i > s.length()) { //만약 +i가 문자열의 최대 길이를 넘어간다면
                end = s.length();

                //바로 전에 검사한 문자열과 지금 검사하는 문자열이 같은지
                if (sb.substring(start, end-i).equals(sb.substring(start, end))) {
                    // 같을 때
                    count++;
                }

                if (count == 1) { //문자열 더하기
                    answer.append(sb.substring(start, end));
                } else{
                    answer.append(count + sb.substring(start, end));
                }

                break;
            }
            
            //abcabcab 이렇게 있을 때 abc와 abc가 같은지 확인하는 것.
            if (sb.substring(start, end).equals(sb.substring(end, end + i))) {
                // 같을 때
                count++;
            }else {
                if (count == 1) {
                    answer.append(sb.substring(start, end));

                } else {
                    answer.append(count + sb.substring(start, end));
                }

                count = 1; //문자열을 이미 추가했다면 count 추가
            }

            start += i;
            end += i;

        }

        return answer.length();
    }
}