import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean visited[];
    public static LinkedList<Integer>[] dfs;
    public static LinkedList<Integer>[] bfs;

    public static String root;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점개수
        int M = Integer.parseInt(st.nextToken()); //간선개수
        int V = Integer.parseInt(st.nextToken()); //시작번호

        dfs = new LinkedList[N+1];
        bfs = new LinkedList[N+1];
        visited = new boolean[N+ 1]; //방문 여부 확인
        root = "";
        for (int i = 1; i <= N; i++) {
            dfs[i] = new LinkedList<Integer>();
        }

        for (int i = 1; i <= N; i++) {
            bfs[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dfs[start].add(end); //리스트에 그래프 추가
            dfs[end].add(start);
            bfs[start].add(end); //리스트에 그래프 추가
            bfs[end].add(start);
        }

        //작은 숫자부터 방문하기 위해 정렬
        for(int i = 1; i<=N; i++){
            Collections.sort(dfs[i]);
            Collections.sort(bfs[i]);
        }

        //DFS 시작
        DFS(V);

        System.out.println(root);

        visited = new boolean[N+ 1]; //방문 기록 초기화
        root = "";

        //BFS 시작
        BFS(V);

        System.out.println(root);
    }

    static void DFS(int next){
        root += (next+" ");
        visited[next] = true;

        for(int a:dfs[next]){
            if(visited[a] == false){ //다음 이어진 선이 아직 방문한 곳이 아니라면 DFS 함수 또 호출
                DFS(a);
            }
        }
    }

    static void BFS(int next){

        Queue<Integer> que = new LinkedList<>();

        que.add(next);

        visited[next] = true;

        while(que.size() != 0) {
            int node = que.poll();
            root += (node+" ");

            for (int a : bfs[node]) {
                if (visited[a] == false) {
                    visited[a] = true;
                    que.add(a);
                }
            }
        }
    }
}