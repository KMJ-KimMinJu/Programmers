import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] parent; //부모 노드 저장 배열
    static boolean[] visited;
    static ArrayList<Integer> tree[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        visited = new boolean[N+1];
        parent = new int[N+1];

        for(int i = 0; i<= N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        DFS(1); //1번 노드부터 시작

        for(int i = 2; i<= N; i++){
            System.out.println(parent[i]);
        }
    }

    static void DFS(int number){
        visited[number] = true;

        for(int i : tree[number]){
            if(!visited[i]){
                parent[i] = number;
                DFS(i);
            }
        }
    }
}