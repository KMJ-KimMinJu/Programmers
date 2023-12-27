import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        int[] DP = new int[T]; //수열의 길이 저장

        int[] arr = new int[T];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < T; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < T; i++){
            DP[i] = 1;

            for(int j = 0; j < i; j++){
                if(arr[i]>arr[j] && DP[i] <= DP[j]){ //앞에서부터 자기 자신보다 작은 수를 확인해줌
                    DP[i] = DP[j]+1;
                }
            }
        }

        int answer = 0;

        for(int i : DP){
            answer = Math.max(answer, i);
        }

        System.out.println(answer);
    }
}