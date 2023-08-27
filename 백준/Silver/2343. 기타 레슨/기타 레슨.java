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
        int M = Integer.parseInt(st.nextToken()); //블루레이 개수

        st = new StringTokenizer(bf.readLine());

        number = new int[N];
        int end = 0; //모든 레슨의 합

        for(int i = 0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
            end += number[i];
        }

        int start = Arrays.stream(number).max().getAsInt();

        binary(start, end, M);

    }

    public static void binary(int start, int end, int M){

        int front = start;
        int back = end;

        while(front<=back){

            int mid = (front+back) / 2; //중앙값이 더하기임

            int sum = 0; //블루레이 크기
            int count = 0; //블루레이 수

            for (int j : number) {
                if (sum + j> mid) {
                    sum = 0;
                    count++;
                }
                sum += j;
            }

            if(sum != 0){
                count++;
            }

            if(count > M){ //저장할 수 없음(필요한 블루레이 수가 더 많음)
                front = mid+1;
            }else{ //저장할 수 있음(블루레이 수가 작거나 같음 )
                back = mid-1;
            }

        }

        System.out.println(front);
    }
}