import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] DP = new int[N+1];// 최대 점수

        int[] score = new int[N+1];

        for(int i= 1; i <= N; i++){
            st = new StringTokenizer(bf.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        DP[1] = score[1]; //N이 1일 경우

        if(N >= 2)DP[2] = DP[1] + score[2]; //N이 2일 경우

        for(int i = 3; i <= N ; i++){
            if(i == 3){
                DP[3] = Math.max(score[1]+score[3], score[2]+score[3]); //N이 3일 경우
                continue;
            }

            DP[i] = Math.max(DP[i-2], DP[i-3]+score[i-1])+score[i]; //3칸 아래, 2칸 아래를 확인해서 3칸 연속으로 올라오는 일이 없게 함

        }

        System.out.println(DP[N]);
    }
}