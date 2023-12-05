import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static ArrayList<Integer>[] tree,list;
    static int parent[], size[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //트리 정점의 수
        int R = Integer.parseInt(st.nextToken()); //루트 번호
        int Q = Integer.parseInt(st.nextToken()); //쿼리의 수

        parent = new int[N+1]; //부모 정보 저장
        tree = new ArrayList[N+1]; //R을 루트로 만든 트리
        size = new int[N+1]; //서브트리 개수 저장
        list = new ArrayList[N+1]; //간선 정보 저장

        for(int i= 0; i<=N; i++){
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());

            System.out.println(size[U]);
        }
    }

    static void makeTree(int node, int parent_check){
        for(int now : list[node]){
            if(now != parent_check){ //-1은 부모가 없음
                tree[node].add(now); //node라는 부모 노드에 now라는 자식 노드 추가
                parent[now] = node; //now라는 자식 노드에 node라는 부모 노드추가
                makeTree(now, node);
            }
        }
    }

    static void countSubtreeNodes(int node){
        size[node] = 1; //자신도 자신을 루트로 하는 서브트리에 포함되므로 0이 아닌 1에서 시작
        for(int now : tree[node]){
            countSubtreeNodes(now);
            size[node] += size[now];
        }
    }
}