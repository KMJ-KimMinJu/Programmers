import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] number;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수

        st = new StringTokenizer(bf.readLine());

        number = new int[N];

        for(int i = 0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        int M = Integer.parseInt(st.nextToken()); //찾아야 할 숫자의 개수

        Arrays.sort(number);
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i<M; i++){
            int find = Integer.parseInt(st.nextToken());

            binary(find);
        }
    }

    public static void binary(int find){

        int start = 0; //시작
        int end = number.length-1;

        boolean find_tf = false;

        while(start<=end){

            int mid = (start+end)/2; //중앙값

            if(number[mid] < find){
                start = mid+1;
            }else if(number[mid]>find){
                end = mid-1;
            }else if(number[mid]==find){
                find_tf = true;
                break;
            }
        }

        if(find_tf == true){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}