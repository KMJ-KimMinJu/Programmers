import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N, M, S, T;
    static Pair[] adj;
    static long[] dist;
    static long[] money;
    static class Pair {
        int first;
        int second;
        long weight;

        Pair(int first, int second, long weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //도시의 수
        S = Integer.parseInt(st.nextToken()); // 시작 도시 번호
        T = Integer.parseInt(st.nextToken()); // 도착 도시 번호
        M = Integer.parseInt(st.nextToken()); //교통수단의 개수

        adj = new Pair[M];
        dist = new long[N];
        money = new long[N];

        // 간선 정보 입력 및 인접 리스트 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj[i] = new Pair(a,b, c); //음수 싸이클을 구해주기 위해 음수로 가중치를 음수로 설정
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            money[i] = Integer.parseInt(st.nextToken());
        }

        bellman();
    }

    static void bellman() {
        // 거리 배열 초기화
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[S] = money[S];

        // 벨만-포드
        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int start = adj[j].first;
                int end = adj[j].second;
                long price = adj[j].weight;

                if(dist[start] == Long.MIN_VALUE){ //아직 방문 ㄴ
                    continue;
                }else if(dist[start] == Long.MAX_VALUE){ //시작 노드가 싸이클에 연결된어 있는 노드라면
                    dist[end] = Long.MAX_VALUE; //도착 노드도 싸이클에 연결
                }else if (dist[end] < dist[start] + money[end]- price) {//더 많은 수입을 얻는 경로 발견
                    dist[end] = dist[start] + money[end]- price;
                    // N-1개를 다 확인한 후인데 경로가 발견되면 --> 싸이클 존재
                    if (i  >= N-1) {
                        dist[end] = Long.MAX_VALUE;
                    }
                }
            }
        }

        // 결과 출력
        if (dist[T] == Long.MAX_VALUE) { //돈 무한대
            System.out.println("Gee");
        } else if (
                dist[T] == Long.MIN_VALUE){ //도착 불가
            System.out.println("gg");
        } else {
            System.out.println(dist[T]);
        }
    }
}