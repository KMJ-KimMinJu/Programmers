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

    static List<List<Node>> edge = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken()); // 출발 노드 번호

        for (int i = 0; i <= V; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 가중치

            edge.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[V+1]; // 최단거리를 저장

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        pq.offer(new Node(K, 0));
        boolean[] visited = new boolean[V+1];

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

            for (Node linkedNode : edge.get(nodeIndex)) {
                if(!visited[linkedNode.index] && (weight + linkedNode.weight < distance[linkedNode.index])) { //Min(선택 노드의 최단 거리 배열의 값 + 엣지 가중치 , 연결 노드의 최단거리 배열의 값)
                    //최단 테이블 갱신
                    distance[linkedNode.index] = weight + linkedNode.weight;
                    // 갱신 된 노드를 우선순위 큐에 넣어
                    pq.offer(new Node(linkedNode.index, distance[linkedNode.index]));
                }
            }

            visited[nodeIndex] = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                result.append("INF\n");
            } else {
                result.append(distance[i]).append("\n");
            }
        }
        System.out.print(result);
    }
}