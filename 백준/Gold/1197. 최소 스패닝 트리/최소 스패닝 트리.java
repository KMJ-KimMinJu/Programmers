import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    // 간선 정보 클래스
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        // 우선 순위 큐 활용
        @Override
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        parent = new int[N+1];

        //대표노드 초기화
        for(int i = 1; i<= N; i++){
            parent[i] = i;
        }

        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            queue.offer(new Edge(s,e,w));
        }

        //사이클을 확인하기 위해 union-find 사용하기

        int weight = 0;

        while(!queue.isEmpty()){
            Edge edge = queue.poll(); //가중치가 제일 작은 간선 가져오기

            //시작노드와 끝 노드의 부모가 같으면 --> 싸이클 연결된 거
            if(find(edge.start) != find(edge.end)){
                union(edge.start, edge.end);
                weight += edge.weight;
            }
        }

        System.out.println(weight);
    }

    //대표노드 합치기
    public static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    // 부모 노드 찾기
    public static int find(int n) {
        if(parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}