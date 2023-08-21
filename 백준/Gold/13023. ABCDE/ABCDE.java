import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean visited[];
    public static LinkedList<Integer>[] dfs;
    public static boolean friend; //친구 관계 존재 여부 확인
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //사람
        int M = Integer.parseInt(st.nextToken()); //친구 관계

        dfs = new LinkedList[N];
        visited = new boolean[N]; //방문 여부 확인

        for (int i = 0; i <N; i++) {
            dfs[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            dfs[start].add(end); //리스트에 그래프 추가
            dfs[end].add(start);
        }

        friend=false;
        for(int i = 0; i<N;i++){
            if(!visited[i]){ //if문이 실행된다는 건 이어진 간선이 없어 새로운 정점을 찾는다는 뜻. --> dfs 실행이 이루어진다.
                DFS(i, 1);
            }
            if(friend){
                break;
            }
        }

        if(friend){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }

    static void DFS(int num, int next){
        if(next == 5 || friend){
            friend = true;
            return;
        }

        visited[num] = true;
        for(int a:dfs[num]){
            if(visited[a] == false){ //다음 이어진 선이 아직 방문한 곳이 아니라면 DFS 함수 또 호출
                DFS(a, next+1);
            }
        }
        
        visited[num] = false;
    }
}