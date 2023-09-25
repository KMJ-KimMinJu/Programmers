import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int answer;
    public static boolean[] visited; //방문 확인 배열
    public static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드의 개수

        st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); //에지 개수

        node = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = 0;

            for(int j = 1; j<=N; j++){
                node[j] = new ArrayList<Integer>();
            }

            for(int j = 0; j<M; j++){
                st = new StringTokenizer(bf.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());

                node[S].add(E);
                node[E].add(S);
            }

            DFS(1);

            System.out.println(answer);
    }

    public static void DFS(int index) {
            visited[index] = true;
            if(index != 1)
                answer++;

            for(int i : node[index]){

                if(!visited[i]){

                    DFS(i);
                }
            }
    }

}