import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(bf.readLine());

          int number = Integer.parseInt(st.nextToken());
          int[] dp = new int[number+1];

          int[] kg = new int[] {5,3};

          for(int i = 1; i<=number; i++){

               //정확하게 봉지를 만들 수 없는 경우.
               if(i % 3 != 0 || i % 5 != 0){
                    dp[i] = -1;
               }

               if(i % 3 == 0 && i % 5 != 0){ //3의 배수인 경우(5의 배수는 아님)에 3 단위의 무게만 확인
                    dp[i] = dp[i-kg[1]]+1;
               }else if (i % 3 != 0 && i % 5 == 0){ //5의 배수인 경우(3의 배수는 아님)에 5 단위의 무게만 확인
                    dp[i] = dp[i-kg[0]]+1;
               }else if(i % 3 == 0 && i % 5 == 0){ //3과 5의 배수인 경우에 두 개를 비교해서 최소만 추가
                    dp[i] = Math.min(dp[i-kg[0]]+1, dp[i-kg[1]]+1);
               }else if(i % 3 != 0 && i % 5 != 0){ //3과 5의 배수가 아닌 경우
                    try{
                         if(dp[i-kg[0]] == -1 || dp[i-kg[1]] == -1){
                              dp[i] = -1;
                         }else{
                              dp[i] = Math.min(dp[i-kg[0]]+1, dp[i-kg[1]]+1);
                         }
                    }catch(ArrayIndexOutOfBoundsException e){
                         if(i < 3){
                              dp[i]  = -1;
                         }else if(i < 5 && dp[i-kg[1]] != -1){
                              dp[i] = dp[i-kg[1]]+1;
                         }
                    }
               }

          }

          System.out.println(dp[number]);
     }
}
