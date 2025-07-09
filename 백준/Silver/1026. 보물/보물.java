import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        Integer[] A_arr = new Integer[N];

        Integer[] B_list = new Integer[N];

        st = new StringTokenizer(bf.readLine());
         for(int i = 0; i<N; i++){ //a 배열 입력
            A_arr[i] = Integer.parseInt(st.nextToken());
         }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++){ //b 배열 입력
            B_list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A_arr); //오름차순 정렬
        Arrays.sort(B_list, Collections.reverseOrder()); //내림차순 정렬

        int sum = 0;

        for(int i = 0; i<N; i++){
            sum += A_arr[i] * B_list[i];
        }

        System.out.println(sum);
    }
}