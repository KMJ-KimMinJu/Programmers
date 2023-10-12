import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int[] people; //모든 사람들의 대표노드
    static int[] True; //진실을 아는 사람 번호
    static ArrayList<Integer>[] party; //파티 참석한 사람들의 번호

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //사람의 수
        people = new int[N + 1];

        int M = Integer.parseInt(st.nextToken()); //파티의 수
        party = new ArrayList[M];

        //대표노드 설정
        for (int i = 0; i <= N; i++) {
            people[i] = i;
        }

        st = new StringTokenizer(bf.readLine());

        int person = Integer.parseInt(st.nextToken()); //진실의 아는 사람의 수

        True = new int[person];
        if (person != 0) {
            //비밀을 아는 사람의 번호 저장 저장
            for (int i = 0; i < person; i++) {
                True[i] = Integer.parseInt(st.nextToken());
            }
        }
        
        //파티 참석한 사람둘 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            party[i] = new ArrayList<Integer>();

            int temp = Integer.parseInt(st.nextToken()); //파티에 참석한 사람 수

            for (int j = 0; j < temp; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        //파티 참석한 사람들끼리 한 개의 집합으로 만들기
        for (int i = 0; i < M; i++) {
            int temp = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(temp, party[i].get(j));
            }
        }

        int answer = 0;

        //거짓말 할 수 있음
        // --> 파티에 참석한 사람의 대표노드와 진실을 아는 사람의 대표노드가 달라야 함
        for(int i = 0; i<M; i++){

            int temp = party[i].get(0);
            int check = 0;

            for(int j = 0; j< True.length; j++){
                if(find(temp) == find(True[j])){
                    check++;
                    break;
                }
            }

            if(check == 0){
                answer++;
            }
        }

        System.out.println(answer);
    }

    //한 개의 집합으로 묶기
    public static void union(int a, int b){

        //두 노드가 같은 집합에 속해 있는지 확인
        a = find(a);
        b = find(b);

        //두 노드가 같은 집합이 아니라면 한 개의 집합으로 만들어주기 위해 대표 노드 변경
        if(a != b){
            people[b] = a;
        }
    }

    public static int find(int a){
        if(a == people[a]){
            return a;
        }else{
            people[a] = find(people[a]); //people[a]값이 가리키는 index 위치로 가서 확인
            return people[a];
        }
    }
}