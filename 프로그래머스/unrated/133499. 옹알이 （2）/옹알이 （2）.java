class Solution {
    public int solution(String[] babbling) {
        
        int count = 0;
        
        for(int i=0; i<babbling.length; i++){
            
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye")||babbling[i].contains("mama")||babbling[i].contains("woowoo")){
                continue;
            }
            babbling[i] = babbling[i].replace("aya", "true");
            babbling[i] = babbling[i].replace("ye", "true");
            babbling[i] = babbling[i].replace("ma", "true");
            babbling[i] = babbling[i].replace("woo", "true");
            babbling[i] = babbling[i].replace("true", "");
            
            
            if(babbling[i].length() == 0){
                count += 1;
            }
        }
        
        
        return count;
    }
}