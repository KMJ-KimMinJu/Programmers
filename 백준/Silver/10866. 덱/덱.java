import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();

            try {
                switch (command) {
                    case "push_front":
                        Integer x = Integer.parseInt(st.nextToken());
                        deque.addFirst(x);
                        break;
                    case "push_back":
                        Integer X = Integer.parseInt(st.nextToken());
                        deque.addLast(X);
                        break;
                    case "pop_front":
                        System.out.println(deque.removeFirst());
                        break;
                    case "pop_back":
                        System.out.println(deque.removeLast());
                        break;
                    case "size":
                        System.out.println(deque.size());
                        break;
                    case "empty":
                        System.out.println(deque.isEmpty() ? 1 : 0);
                        break;
                    case "front":
                        System.out.println(deque.getFirst());
                        break;
                    case "back":
                        System.out.println(deque.getLast());
                        break;
                }
            } catch (NoSuchElementException e){
                System.out.println(-1);
            }
        }
    }
}