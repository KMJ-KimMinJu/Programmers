import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    static Integer in[];
    static int post [];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드 개수

        in = new Integer[N];
        post = new int[N];

        //인오더
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            in[i] = Integer.parseInt(st.nextToken());
        }

        //포스트오더
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            post[i] = Integer.parseInt(st.nextToken());
        }

        search(0, N-1, 0, N-1);
    }

    static void search(int instart, int inend, int psstart, int psend){

        if(instart > inend || psstart > psend){
            return;
        }

        int root = post[psend]; //루트 노드를 구해줌 --> 제일 첫 번
        System.out.print(root+" ");

//        int root_index = (Arrays.asList(in)).indexOf(root); --> 이거 쓰면 시간복잡도 높아짐
        int root_index = 0;

        for(int i = instart; i<= inend; i++){
            if(in[i] == root){
                root_index = i;
                break;
            }
        }

        int leftNode = root_index-instart; // 포스트 오더 왼쪽 자식 수

        //왼쪽
        search(instart,root_index-1,psstart, psstart+leftNode-1);

        //오른쪽
        search(root_index+1, inend, psstart+leftNode, psend-1);

    }
}