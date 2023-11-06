import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        private int index;
        private int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N;
    static List<Node>[] edge;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 테스트 케이스

        while(N > 0) {

            st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            edge = new ArrayList[n+1];

            for (int i = 0; i <= n; i++) {
                edge[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken()); //
                int b = Integer.parseInt(st.nextToken()); // a가 b를 의존
                int w = Integer.parseInt(st.nextToken()); // 감염 시간

                edge[b].add(new Node(a, w));
            }

            distance = new int[n + 1]; // 최단거리를 저장
            int time = 0;

            int cost = dijkstra(c, n);

            for(int j = 1; j <= n; j++) {
                if(distance[j] != Integer.MAX_VALUE) time = Math.max(time, distance[j]);
            }

            System.out.println(cost + " "+ time);

            N--;
        }

    }

    static int dijkstra(int a, int n){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[a] = 0;
        pq.offer(new Node(a, 0));
        boolean[] visited = new boolean[n+1];
        int count = 0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int nodeIndex = node.index; //꺼낸 노드의 인덱스
            int weight = node.weight; //꺼낸 노드의 가중치

            /**
             * 큐는 최단거리를 기준으로 오름차순 정렬
             * 만약 현재 꺼낸 노드의 거리가 최단거리테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드이므로,
             * 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냄.*/

            if(weight > distance[nodeIndex]) {
                continue;
            }

            count++;

            for (Node linkedNode : edge[nodeIndex]) {

                if(!visited[linkedNode.index] && (weight + linkedNode.weight < distance[linkedNode.index])) { //Min(선택 노드의 최단 거리 배열의 값 + 엣지 가중치 , 연결 노드의 최단거리 배열의 값)
                    //최단 테이블 갱신
                    distance[linkedNode.index] = weight + linkedNode.weight;
                    // 갱신 된 노드를 우선순위 큐에 넣어
                    pq.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }

            visited[nodeIndex] = true;
        }

        return count;
    }
}