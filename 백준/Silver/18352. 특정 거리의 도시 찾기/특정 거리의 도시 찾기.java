import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int[] visited;
    public static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); //도시의 개수
        int M = Integer.parseInt(st.nextToken()); //도로의 개수
        int K = Integer.parseInt(st.nextToken()); //거리 정보
        int X = Integer.parseInt(st.nextToken()); //출발 도시 번호

        node = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i = 1; i<= N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            node[s].add(e);
        }

        //방문 배열 초기화
        for(int i = 0; i<N+1; i++){
            visited[i] = -1;
        }

        BFS(X);

        for(int i = 0; i<visited.length; i++){
            if(visited[i] == K){
                sb.append(i + "\n");
            }
        }

        if(sb.length() == 0){
            System.out.println(-1);
        }else {
            System.out.println(sb.toString());
        }
    }

    //너비우선
    public static void BFS(int X){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(X); //시작 지점
        visited[X]++;

        while(queue.size() != 0){
            int now = queue.poll();
            for(int i : node[now]){
                if(visited[i] == -1){
                    visited[i] = visited[now]+1; //누적 거리
                    queue.add(i);
                }
            }
        }
    }
}