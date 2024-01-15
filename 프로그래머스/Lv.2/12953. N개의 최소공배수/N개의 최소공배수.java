import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Stack<Integer> pq = new Stack<>();
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }

        if(pq.size() == 1){
            return pq.peek();
        }

        while(pq.size() > 1){
            int num1 = pq.pop();
            int num2 = pq.pop();

            long gcd = 1;

            for(int i=1; i<=num1; i++){
                if(num1 % i == 0 && num2 % i == 0){
                    gcd = i;
                }
            }

            gcd = (num1 * num2) / gcd;
            pq.add((int)gcd);
        }

        return pq.peek();
    }
}