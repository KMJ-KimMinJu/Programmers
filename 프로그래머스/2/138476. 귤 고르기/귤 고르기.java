import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        HashMap<Integer, Integer> tanger = new HashMap<>();
        
        // 종류별 개수 확인
        for(int i : tangerine){
            if(tanger.containsKey(i)){
                tanger.put(i, tanger.get(i)+1);
            }else{
                tanger.put(i, 1);
            }
        }
        
        //value 값을 기준으로 정렬
        List<Integer> valueSet = new ArrayList<>(tanger.keySet());
        
        valueSet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return tanger.get(o2).compareTo(tanger.get(o1));
            }
        });
        
        int answer = 0;
        
        // 만약 해당 종류의 귤 개수가 k개보다 작다면 모두 넣기.
        // k개보다 많다면 값이 음수가 되기 때문에 break
        for(Integer value : valueSet){
            
            if(k <= 0){
                break;
            }
            
            if(k != 0){
                k = (k - tanger.get(value));
                answer++;
            }
        
        }
        
        return answer;
    }
}