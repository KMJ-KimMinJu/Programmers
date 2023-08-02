import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int plus = Integer.parseInt(st.nextToken());
        int hap = 0;
        int[][] sum = new int[count+1][count+1];
        int[][] num = new int[count][count];

        for (int i = 1; i <= count; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= count; j++){
                num[i-1][j-1] = Integer.parseInt(st.nextToken());
                hap += num[i-1][j-1];
                sum[i][j] = sum[i][j-1]+sum[i-1][j] - sum[i-1][j-1] + num[i-1][j-1];
            }
        }

        for(int i= 1; i<= plus; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sum[x2][y2]-sum[x2][y1-1]-sum[x1-1][y2]+sum[x1-1][y1-1]);

            }
    }
}