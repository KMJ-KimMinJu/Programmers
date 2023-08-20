import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean visited[];
    public static LinkedList<Integer>[] dfs;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수

        dfs = new LinkedList[N+1];
        visited = new boolean[N+ 1]; //방문 여부 확인

        for (int i = 1; i <= N; i++) {
            dfs[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dfs[start].add(end); //리스트에 그래프 추가
            dfs[end].add(start);
        }

        int count = 0;

        for(int i = 1; i<N+1;i++){
            if(!visited[i]){ //이 if문이 실행된다는 건 이어진 간선이 없어 새로운 정점을 찾는다는 뜻. --> dfs 실행이 이루어진다.
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int next){
        if(visited[next]){
            return; //이미 방문했으면 돌아가서 정점 바꿔주기
        }

        visited[next] = true;

        for(int a:dfs[next]){
            if(visited[a] == false){ //다음 이어진 선이 아직 방문한 곳이 아니라면 DFS 함수 또 호출
                DFS(a);
            }
        }
    }
}