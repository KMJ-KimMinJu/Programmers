import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //횟수
        int[][] meeting = new int[N][2];

        int count = 0;
        int time = 0; //현재 시간

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());

            meeting[i][0] = Integer.parseInt(st.nextToken()); //시작시간
            meeting[i][1] = Integer.parseInt(st.nextToken()); //종료시간
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){ //종료시간이 같을 때
                    return o1[0]-o2[0]; //시작시간을 기준으로 정렬
                }
                return o1[1]-o2[1];
            }
        });

        for(int i= 0; i<N; i++){
            if(time <= meeting[i][0]){ //현재시간이 회의시작시간보다 작거나 같을 때
                count++;
                time = meeting[i][1];
            }
        }
        
        System.out.println(count);
    }
}