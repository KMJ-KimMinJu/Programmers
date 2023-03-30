/*class Solution {

    //분자
    public static long nume(long balls, long share){
        
        long num = 1;
        for(long i = (balls-share)+1; i<=balls; i++){
            num *= i;
            System.out.println(num);
        }
            
        return num;
    }
    
    //분모
    public static long fact(long n){
        if(n<=1)
            return n;
        
        return fact(n-1)*n;
    }
    
    public long solution(long balls, long share) {
        if(balls == share)
            return 1;
        
        long answer = 0L;
        long demo = fact(share);
        long nume_num = nume(balls, share);
        
        answer = (nume_num/demo);
        return answer;
    }   
    
    
}
    
       /*이렇게 했을 때, long을 뛰어넘는 수가 나옴. 더 큰 자료형을 쓰거나,나누기를 같이 해주거나*/
    /*biginteger를 사용했을 때 문자열로 바꿔줘야 하는 불편함과 for문을 사용하여 나눗셈을 하기에 어려움.*/
 
class Solution {
    public int solution(int balls, int share) {
        return combination(balls, share);
    }

    public static int combination(int balls, int share) {
        if (balls == share || share == 0) return 1;
        return combination((balls - 1), (share - 1)) + combination(balls - 1, share);
    }
}