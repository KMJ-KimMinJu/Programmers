import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, cnt;

        Node(int y, int cnt) {
            this.y = y;
            this.cnt = cnt;
        }

    }
    static ArrayList<ArrayList<Node>> edge;
    static long[] distance;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        /**
         * 테스트 케이스 개수
         *
         * 지점 개수, 도로 개수, 웜홀 개수
         * 도로 정보 후
         * 웜홀 정보
         *
         * 웜홀은 마이너스로 처리해서 하기
         */

        int TC = Integer.parseInt(st.nextToken());

        int count = 1;

        while(count <= TC){
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken()); // 지점의 수
            M = Integer.parseInt(st.nextToken()); // 도로 개수
            int W = Integer.parseInt(st.nextToken()); // 웜홀 개수


            edge = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edge.add(new ArrayList<Node>());
            }

            for(int i = 0; i<M+W; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if(i<M){ //도로는 양방향
                    edge.get(s).add(new Node(t,w));
                    edge.get(t).add(new Node(s,w));
                }else{
                    edge.get(s).add(new Node(t,-w)); //웜홀은 단방향
                }
            }

                if (Bellman()) {
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }

            count++;
        }
    }

    static boolean Bellman(){

        boolean min = false;
        distance = new long[N+1];

        for(int j = 1; j<=N; j++) {
            min = false;

            for (int i = 1; i <= N; i++) {
                for (Node node : edge.get(i)) {

                    if (distance[node.y] > distance[i] + node.cnt) {
                        distance[node.y] = distance[i] + node.cnt;
                        min = true;
                    }
                }
            }

            if (!min) {
                break;
            }
        }

        return min;
    }

}