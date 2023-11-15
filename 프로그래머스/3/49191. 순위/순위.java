class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] wins = new int[n+1][n+1];
        
        for(int[] edge : results){
            //진 사람이 1, 이긴 사람이 -1
            wins[edge[0]][edge[1]] = 1;
            wins[edge[1]][edge[0]] = -1;
        }
    
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i에서 k, k에서 j
                    if (wins[i][k] == 1 && wins[k][j] == 1) {
                        wins[i][j] = 1;
                        wins[j][i] = -1;
                    }else if(wins[i][k] == -1 && wins[k][j] == -1){
                        wins[i][j] = -1;
                        wins[j][i] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int[] edge: wins){
            int count = 0;
            for(int i = 1; i< edge.length; i++){
                if(edge[i] != 0){
                    count++;
                }
            }
            
            if(count == n-1){ //자기 자신을 제외한 모두
                answer++;
            }
        }
        
        return answer;
    }
}