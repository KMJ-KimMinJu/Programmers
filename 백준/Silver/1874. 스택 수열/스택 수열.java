import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();

        int[] arr = new int[num];

        //1~n까지의 배열 만들어주기
        for(int i = 0; i<num; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int j = 1; //스택에 넣어주는 자연수

        for(int i = 0; i<num; i++){
            int number = arr[i]; //스택에서 빼와야 할 수

            if(number >= j){ //number가 자연수보다 클 경우(스택에 수가 number까지 수가 다 들어가지 않았다는 의미)
                for(int k = j; k<=number; k++, j++){
                    stack.add(k); //number수까지 push 진행
                    bf.append("+\n");
                }
                stack.pop(); //number에 해당하는 수 pop
                bf.append("-\n");
            }else{ //number가 자연수보다 작을 경우(스택에 이미 수가 다 들어간 상태. pop을 해줘야 함)
                int n = stack.pop();

                if(n<number){ //number보다 스택의 마지막 수가 더 작으면 pop을 해도 필요한 수를 가져오지 못함
                    bf.delete(0, bf.length());
                    System.out.println("NO");
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }

        if(bf.length() != 0) {
            System.out.println(bf.toString());
        }
    }
}