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

        st = new StringTokenizer(br.readLine());

        int[] num = new int[count];
        int[] sum = new int[count + 1];

        for (int i = 1; i <= count; i++) {
            num[i-1] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + num[i-1];
        }

        for(int i= 1; i<= plus; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            System.out.println(sum[second] - sum[first-1]);
            }
    }
}