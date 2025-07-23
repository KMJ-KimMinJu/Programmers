import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();

            try {
                switch (command) {
                    case "push":
                        Integer X = Integer.parseInt(st.nextToken());
                        stack.push(X);
                        break;
                    case "top":
                        System.out.println(stack.peek());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "pop":
                        System.out.println(stack.pop());
                        break;
                }
            } catch (EmptyStackException e){
                System.out.println(-1);
            }
        }
    }
}