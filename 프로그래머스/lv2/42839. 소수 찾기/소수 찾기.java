import java.util.*;

class Solution {
    Set<Integer> num = new HashSet<>();

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

        requr(num_str, sb, idx, visited);
    }

    public void requr(char[] num_str, StringBuilder sb, int idx, boolean[] visited) {
        if (sb.length() == idx) {
            num.add(Integer.valueOf(sb.toString()));
            return;
        }

        for (int i = 0; i < num_str.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(num_str[i]);
                requr(num_str, sb, idx, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

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
