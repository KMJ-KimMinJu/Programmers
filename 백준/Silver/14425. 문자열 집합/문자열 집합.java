import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        Set<String> set = new HashSet<>();

        //set에 문자열 저장
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(st.nextToken());
        }
        
        //문자열이 포함되어있는지 확인
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            answer = set.contains(st.nextToken()) == true ? answer+1 : answer;
        }
        
        System.out.println(answer);

    }
}