import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        tree = new int[N][2];

        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            String alpha = st.nextToken();
            String left = st.nextToken();
            String right= st.nextToken();

            if(left.equals(".")){
                tree[alpha.charAt(0)-'A'][0] = -1; //처음 입력받은 문자를 인덱스로 변경해주기
            }else {
                tree[alpha.charAt(0)-'A'][0] =left.charAt(0)-'A';
            }

            if(right.equals(".")){
                tree[alpha.charAt(0)-'A'][1] = -1;
            }else {
                tree[alpha.charAt(0)-'A'][1] = right.charAt(0)-'A';
            }
        }

        pre(0);
        System.out.println();
        in(0);
        System.out.println();
        post(0);
        System.out.println();

    }

    //루트, 왼쪽, 오른쪽 ==> 전위 순회
    static void pre(int node){


        if(node == -1){
            return;
        }

        System.out.print((char) (node+'A'));
        pre(tree[node][0]); //왼쪽
        pre(tree[node][1]); //오른쪽

    }

    //왼쪽, 루트, 오른쪽 ==> 중위 순회
    static void in(int node){

        if(node == -1){
            return;
        }

            in(tree[node][0]); //왼쪽
            System.out.print((char) (node+'A'));
            in(tree[node][1]); //오른쪽

    }

    //왼쪽, 오른쪽, 루트 ==> 후휘 순위
    static void post(int node){

        if(node == -1){
            return;
        }

            post(tree[node][0]); //왼쪽
            post(tree[node][1]); //오른쪽
            System.out.print((char) (node+'A'));
    }
}