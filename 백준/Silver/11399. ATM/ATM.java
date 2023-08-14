import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] str = bf.readLine().strip().split(" "); //인출하는데 걸리는 시간
        int[] sum = new int[N+1];

        for(int i=1; i<N; i++){

            int target = Integer.parseInt(str[i]); //선택한 데이터

            //이진탐색
            int start = 0; //타겟이 될 위치
            int end = i;
            int mid;

            while(start<end){
                mid = (start+end)/2; //중간 위치

                //str[mid]가 target보다 클 경우 탐색선을 중간 위치로
                if(target < Integer.parseInt(str[mid])){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }

            int j = i-1;

            //한 칸씩 뒤로 밀기
            while(j>= start){
                str[j+1] = str[j];
                j--;
            }

            str[start] = String.valueOf(target);
        }

        for(int i = 1; i<=N; i++){
            sum[i] = sum[i-1]+Integer.parseInt(str[i-1]);
        }

        int result = 0;

        for(int a:sum){
            result += a;

        }

        System.out.println(result);
    }
}