import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int[] node;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int length = (int) Math.pow(2,N)-1;

        tree = new ArrayList[length];
        node = new int[length];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < length; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < length ;i++){
            node[i] = Integer.parseInt(st.nextToken());
        }

        search(0, length-1, 0);

        for(int i= 0; i<N; i++){
            for(int a : tree[i]){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }

    //왼쪽, 루트, 오른쪽 ==> 중위순회
    static void search(int start, int end, int depth){

        if(depth == N){ // N이 깊이가 됨
            return;
        }
        //부모노드
        int parent = (start+end)/2;

        tree[depth].add(node[parent]);

        //왼쪽
        search(start,parent-1,depth+1);

        //오른쪽
        search(parent+1, end, depth+1);

    }
}