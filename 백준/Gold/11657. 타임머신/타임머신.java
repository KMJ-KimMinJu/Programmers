import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
    static ArrayList<Node> edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        edge = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edge.add(new Node(s,t,w));
        }

        Bellman(N,M);
    }

    static void Bellman(int n, int m){
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;

        //모든 노드와 모든 간선을 확인해주기 위해서 이중 for문 사용
        //N-1개의 경로를 확인해줌
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                Node node = edge.get(j); //현재 간선

                if(distance[node.x] != Long.MAX_VALUE && distance[node.y]>distance[node.x]+node.cnt){
                    distance[node.y] = distance[node.x]+node.cnt;
                }
            }
        }

        //음수 가중치 확인
        for(int i = 0; i<m; i++){
            Node node = edge.get(i);
            if(distance[node.x] != Long.MAX_VALUE && distance[node.y]>distance[node.x]+node.cnt){
                System.out.println("-1");
                return;
            }
        }


        for (int i = 2; i < distance.length; i++) {
            if (distance[i] == Long.MAX_VALUE)
                System.out.println("-1");
            else
                System.out.println(distance[i]);
        }
    }

}