import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String dna = st.nextToken();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int result = 0;
        String dna_str = "";

        int[] count = new int[128]; // ASCII 문자를 가정합니다.

        for (int i = 0; i < P - 1; i++) {
            char ch = dna.charAt(i);
            count[ch]++;
        }

        for(int i= 0, j = i+(P-1); j<S; i++, j++){
            char ch = dna.charAt(j);
            count[ch]++;

            if (count['A'] >= A && count['C'] >= C && count['G'] >= G && count['T'] >= T) {
                result++;
            }

            ch = dna.charAt(i);
            count[ch]--;
        }

        sb.append(result).append("\n");

        System.out.println(sb.toString());
    }
}