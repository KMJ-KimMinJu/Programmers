import java.util.*;
public class Main {
    static final long INF = (long) 1e18;
    static int N, M;
    static List<Pair>[] adj;
    static long[] dist;
    static int[] pnode; //정점 저장

    static class Pair {
        int first;
        long second;

        public Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        adj = new ArrayList[N+1];
        dist = new long[N+1];
        pnode = new int[N+1];

        // 각 정점에 대한 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 간선 정보 입력 및 인접 리스트 구성
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            long c = scanner.nextLong();
            adj[a].add(new Pair(b, -c)); // 양수를 음수로 바꿔주어 음수 싸이클을 찾도록 저장
        }

        solve();
    }

    static void solve() {
        // 거리 배열 초기화
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 벨만-포드
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Pair p : adj[j]) {
                    // 간선을 따라 이동할 때 최단 거리 갱신
                    if (dist[j] != INF && dist[p.first] > dist[j] + p.second) {
                        dist[p.first] = dist[j] + p.second;
                        pnode[p.first] = j; //최단경로가 되는 정점 저장
                        // 음수 사이클이 있는 경우
                        if (i == N - 1) {
                            dist[p.first] = -INF;
                        }
                    }
                }
            }
        }

        // 결과 출력
        if (dist[N] == INF || dist[N] == -INF) {
            System.out.println(-1);
        } else {
            int x = N;
            List<Integer> v = new ArrayList<>();
            // 역추적을 통해 최단 경로 구성
            while (x != 0) {
                v.add(x);
                x = pnode[x];
            }
            // 결과 출력
            for (int i = v.size() - 1; i >= 0; i--) {
                System.out.print(v.get(i) + " ");
            }
        }
    }
}