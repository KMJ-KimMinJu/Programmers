import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int result = 0;
        
        //sides에 있는 수가 가장 큰 변일 경우
        int max = (sides[0]> sides[1])?sides[0]:sides[1];
        int min = (sides[0]> sides[1])?sides[1]:sides[0];

        for(int i=1; i<max; i++){
            if(max < (i+min))
                result ++;
        }  

        //sides에 있는 수가 작은 두 변일 경우
        for(int i = max ; i< (sides[0] + sides[1]) ; i++){
            if((sides[0]+sides[1]) > i)
                result ++ ;
        }
 
        return result;
    }
}