import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] distances = new PriorityQueue[N + 1];
        List<Node>[] edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            distances[i] = new PriorityQueue<>(Collections.reverseOrder());
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken()); // 출발지
            int v = Integer.parseInt(st.nextToken()); // 도착지
            int w = Integer.parseInt(st.nextToken()); // 시간

            edges[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distances[1].add(0);
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int index = current.index;
            int time = current.distance;

            for (Node node : edges[index]) {
                int nextNode = node.index;
                int weight = node.distance;

                //K개의 최단경로를 저장해주기
                if (distances[nextNode].size() < K) {
                    distances[nextNode].add(time + weight);
                    pq.add(new Node(nextNode, time + weight));
                }else if(distances[nextNode].size() == K && distances[nextNode].peek()> time + weight){ //K개까지 저장했고, k번째의 최단경로보다 현재 경로가 더 작으면 최단경로를 갱신
                    distances[nextNode].poll();
                    distances[nextNode].add(weight+time);

                    pq.add(new Node(nextNode, weight+time));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distances[i].size() == K) System.out.println(distances[i].peek());
            else System.out.println(-1);
        }
    }
}