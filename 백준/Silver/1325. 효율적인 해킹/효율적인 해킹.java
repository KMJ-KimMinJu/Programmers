import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int[] answer; //방문 횟수 배열
    public static boolean[] visited; //방문 확인 배열
    public static ArrayList<Integer>[] node;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken()); //컴퓨터 개수
        int M = Integer.parseInt(st.nextToken()); //M개

        node = new ArrayList[N+1];
        visited = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 1; i<= N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(bf.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            node[s].add(e);
        }

        for(int i = 1; i <= N; i++){
            BFS(i); //각 노드를 돌면서 신뢰관계 확인
            visited = new boolean[N+1];
        }

        int max = Arrays.stream(answer).max().getAsInt(); //answer에서 max값 찾기


        for(int i = 1; i<= N; i++){
            if(answer[i] == max){
                System.out.print(i+" ");
            }
        }

    }

    //너비우선
    public static void BFS(int X){

        Queue<Integer> queue = new LinkedList<>();

        queue.add(X); //시작 지점
        visited[X]= true;

        while(queue.size() != 0){
            int now = queue.poll();
            for(int i : node[now]){
                if(!visited[i]){
                    visited[i] = true; //누적 거리
                    answer[i] ++;
                    queue.add(i);
                }
            }
        }
    }
}