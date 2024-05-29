import java.util.*;

class Solution {
    
    Set<Integer> num = new HashSet<>(); //HashSet말고 Set을 사용해서 메모리 사용량 줄이기
    
    public int solution(String numbers) {
        char[] num_str = numbers.toCharArray();
        int count = 0;

        for (int i = 1; i <= num_str.length; i++) {
            set(num_str, i);
        }

        for (int a : num) {
            if (isPrime(a)) {
                count++;
            }
        }

        return count;
    }

    
    public void set(char[] num_str, int idx) {
        boolean[] visited = new boolean[num_str.length];
        StringBuilder sb = new StringBuilder(); 
        //String은 불변이기 때문에 StringBuilder를 사용해서 메모리 줄여주기. 
        //즉, String에 + 연산을 사용할 때마다 String이 새로 생성된다는 뜻

        requr(num_str, sb, idx, visited);
    }

    
    public void requr(char[] num_str, StringBuilder sb, int idx, boolean[] visited) {
        if (sb.length() == idx) { //만들어야 하는 자릿수의 숫자가 생성되었으면 저장해주기
            num.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0; i < num_str.length; i++) {
            if (!visited[i]) { //방문하지 않은 것부터 찾아보기
                visited[i] = true;
                sb.append(num_str[i]);
                requr(num_str, sb, idx, visited);
                // sb라는 문자열에 가장 최근에 넣은 숫자를 삭제. 
                //그래야 다음에 넣을 땐 그 수를 제외한 수가 들어감.
                sb.deleteCharAt(sb.length() - 1); 
                //삭제한 다음 삭제된 문자의 인덱스에는 
                //또 다른 문자가 들어오고 그 문자에 접근할 수 있도록 false로 변경.
                visited[i] = false;
            }
        }
    }

    //소수인지 아닌지 판별해주기
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
