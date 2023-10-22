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
    static int N,K;
    static List<List<Node>> edge = new ArrayList<>();
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        distance = new int[1000001]; // 최소시간 저장

        if(N>K){ //같을 경우에 -1만 가능하기 때문에 빼기
            System.out.println(N-K);
        }else if(N==K){
            System.out.println("0");
        }else{
            int answer = dijkstra(N);
            System.out.println(answer);
        }
        
    }

    static int dijkstra(int a){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[a] = 0;
        pq.offer(new Node(a, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int nodeIndex = node.index; //꺼낸 노드의 인덱스
            int weight = node.weight; //꺼낸 노드의 가중치

            if(weight > distance[nodeIndex]) {
                continue;
            }
            
            //x-1, x+1, 2*x로 각각 이동했을 때의 시간을 현재 이동한 시간과 비교해서 최소의 시간이 될 수 있도록 if문 실행
            //--> 저 if문 중 시간이 가장 짧은 것으로 현재 시간이 바뀜

            //Min(선택 노드의 최단 거리 배열의 값 + 엣지 가중치 , 연결 노드의 최단거리 배열의 값)

            //x-1
            if((nodeIndex-1 >= 0 && nodeIndex-1 <= 100000) && weight + 1 < distance[nodeIndex-1]){ //가중치 비교 --> 이동했을 때의 시간 + 현재 이동한 시간
                distance[nodeIndex-1] = weight+1;
                pq.offer(new Node(nodeIndex-1, distance[nodeIndex-1]));
            }

            //x+1
            if((nodeIndex+1 >= 0 && nodeIndex+1 <= 100000)&&weight + 1 < distance[nodeIndex+1]){
                distance[nodeIndex+1] = weight+1;
                pq.offer(new Node(nodeIndex+1, distance[nodeIndex+1]));
            }

            //2*x
            if((nodeIndex*2 >= 0 && nodeIndex*2 <= 100000)&& weight  < distance[nodeIndex*2]){
                distance[nodeIndex*2] = weight;
                pq.offer(new Node(nodeIndex*2, distance[nodeIndex*2]));
            }

        }

        return distance[K];
    }
}