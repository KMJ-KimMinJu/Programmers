import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    static ArrayList<Node>[] node;
    static boolean visited[];

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i= 1; i<= N; i++){
            node[i] = new ArrayList<>();
        }

        for(int i = 1; i< N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            node[s].add(new Node(e, w));
            node[e].add(new Node(s, w));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //노드 개수
            int e = Integer.parseInt(st.nextToken()); //노드 개수

            dfs(s,e,0);
            System.out.println(answer);

            visited = new boolean[N+1];
            answer = 0;
        }

    }

    static void dfs(int start, int end, int dist){

        if(start == end){
            answer = dist;
            return;
        }

        visited[start] = true;

        for(Node node : node[start]){

            if(!visited[node.end]){

                dfs(node.end, end, dist + node.weight);
            }
        }
    }
}