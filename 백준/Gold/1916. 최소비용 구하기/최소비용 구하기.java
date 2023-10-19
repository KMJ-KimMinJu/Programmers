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

        int N = Integer.parseInt(st.nextToken()); // 도시 개수

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken()); // 버스 개수

        for (int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발지
            int v = Integer.parseInt(st.nextToken()); // 도착지
            int w = Integer.parseInt(st.nextToken()); // 버스 비용

            edge.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken()); //출발 도시
        int B = Integer.parseInt(st.nextToken()); //도착 도시

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N+1]; // 최단거리를 저장

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[A] = 0;
        pq.offer(new Node(A, 0));
        boolean[] visited = new boolean[N+1];

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

        System.out.print(distance[B]);
    }
}