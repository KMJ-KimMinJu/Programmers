import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]>[]edge;
    static boolean[] visited;
    static long[] dp; //재료의 질량을 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 재료 개수

        edge = new ArrayList[N+1];

        dp = new long[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            edge[i]=new ArrayList<>();
        }

        long lcm = 1; //모든 레시피 비율의 최소공배수

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            edge[a].add(new int[] {b,p,q}); //{자식 노드, p,q}
            edge[b].add(new int[] {a,q,p});

            lcm *= (p*q)/GCD(p,q);
        }

        dp[1] = lcm; //초기값 설정
        DFS(1);

        long AllLcm = dp[0];

        //재료의 질량을 더했을 때 최소가 되어야 해서
        //모든 재료 질량의 최대공약수를 구해줌
        for(int i = 1; i<= N; i++){
            if (dp[i] == 0) continue;
            AllLcm = GCD(AllLcm, dp[i]);
        }

        //최소를 만들기 위해 최대공약수로 나누어서 질량을 구해줌
        for (int i = 0; i < N; i++) {
            System.out.print(dp[i] / AllLcm + " ");
        }
    }

    static long GCD(long a, long b){
        while(b!=0){
            long t = a%b;
            a = b;
            b = t;
        }

        return a;
    }

    static void DFS(int x){

        visited[x] = true;

        for(int[] now : edge[x]){

            if(!visited[now[0]]){
                dp[now[0]] = (dp[x] * now[2]) / now[1]; // a: b = p : q
                DFS(now[0]);
            }
        }

    }
}