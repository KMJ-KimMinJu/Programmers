import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[] DP = new int[T];

        int[] arr = new int[T];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < T; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //초기화
        DP[0] = arr[0];
        int max = arr[0];

        for(int i = 1; i < T; i++){
            DP[i] = Math.max(DP[i-1]+arr[i], arr[i]); //연속으로 더할지 새로운 연속을 만들지

            max = Math.max(max, DP[i]); //최댓값 갱신
        }

        System.out.println(max);
    }
}