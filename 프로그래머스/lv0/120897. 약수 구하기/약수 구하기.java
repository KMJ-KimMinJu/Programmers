import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public Integer[] solution(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(n%i == 0){
                al.add(i);
            }
        }
        
        Integer[] array = al.toArray(new Integer[al.size()]);
        
        Arrays.sort(array);
        
        return array;
    }
}