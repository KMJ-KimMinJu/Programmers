import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수


        for(int i= 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());

            int height = Integer.parseInt(st.nextToken());// 호텔 높이
            int weight = Integer.parseInt(st.nextToken()); // 호텔 가로
            int client = Integer.parseInt(st.nextToken()); // 손님 번호

            int now_h = 0;
            int now_w = 1;

            for(int j = 1; j<=client; j++){
                if(now_h<height){
                    now_h++;
                }else{
                    now_h = 1;
                    now_w++;
                }
            }

            if(now_w<10){
                System.out.println(now_h+"0"+now_w);
            }else{
                System.out.println(now_h+""+now_w);
            }
        }
    }
}