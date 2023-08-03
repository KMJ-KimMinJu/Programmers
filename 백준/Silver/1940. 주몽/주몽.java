import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        int start = 0;
        int end = num.length-1;

        while(start<end){
            if(num[start] + num[end]> M){
                end--;
            }else if(num[start] + num[end] == M){
                end--;
                start++;
                count++;
            }else if(num[start] + num[end] < M){
                start++;
            }
        }

        System.out.println(count);
    }
}