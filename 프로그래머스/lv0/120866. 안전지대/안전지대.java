import java.util.Arrays;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        //전부 1일 경우
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                if(board[i][j] == 1){
                    answer += 1;
                }
            }
        }
        
        if(answer == board.length*board.length)
            return 0;
        
        //안쪽
        for(int i = 1; i<= board.length-2; i++){
            for(int j = 1; j<=board.length-2; j++){
                if(board[i][j] == 1){
                    board[i][j] = 2;
                    
                    board[i-1][j-1] = (board[i-1][j-1] == 0)? 2 : board[i-1][j-1];
                    board[i-1][j] = (board[i-1][j] == 0)? 2 : board[i-1][j];
                    board[i-1][j+1] = (board[i-1][j+1] == 0)? 2 : board[i-1][j+1];
                    board[i][j-1] = (board[i][j-1] == 0)? 2 : board[i][j-1];
                    board[i][j+1] = (board[i][j+1] == 0)? 2 : board[i][j+1];
                    board[i+1][j-1] = (board[i+1][j-1] == 0)? 2 : board[i+1][j-1];
                    board[i+1][j] = (board[i+1][j] == 0)? 2 : board[i+1][j];
                    board[i+1][j+1] = (board[i+1][j+1] == 0)? 2 : board[i+1][j+1];
                }
            }
        }
    
        
        //모서리 4개
        if(board[0][0] == 1){
            board[0][0] = 2;
            board[0][1] = (board[0][1] == 0)?2 : board[0][1];
            board[1][0] = (board[1][0] == 0)?2 : board[1][0];
            board[1][1] = (board[1][1] == 0)?2 : board[1][1];
        }
        
        if(board[board.length-1][0] == 1){
            board[board.length-1][0] = 2;
            board[board.length-1][1] = (board[board.length-1][1] == 0)?2 : board[board.length-1][1];
            board[board.length-2][0] = (board[board.length-2][0] == 0)?2 : board[board.length-2][0];
            board[board.length-2][1] = (board[board.length-2][1] == 0)?2 : board[board.length-2][1];
        }
        
        if(board[board.length-1][board.length-1] == 1){
            board[board.length-1][board.length-1] = 2;
            board[board.length-1][board.length-2] = (board[board.length-1][board.length-2] == 0)?2 : board[board.length-1][board.length-2];
            board[board.length-2][board.length-2] = (board[board.length-2][board.length-2] == 0)?2 : board[board.length-2][board.length-2];
            board[board.length-2][board.length-1] = (board[board.length-2][board.length-1] == 0)?2 : board[board.length-2][board.length-1];
        }
        
        if(board[0][board.length-1] == 1){
            board[0][board.length-1] = 2;
            board[0][board.length-2] = (board[0][board.length-2] == 0)?2 : board[0][board.length-2];
            board[1][board.length-2] = (board[1][board.length-2] == 0)?2 : board[1][board.length-2];
            board[1][board.length-1] = (board[1][board.length-1] == 0)?2 : board[1][board.length-1];
        }
        
        // 테두리 좌우상하 각각 3개
        
        //좌
        for(int i = 1; i<=board.length-2 ; i++){
            if(board[i][0] == 1){

                board[i][0] = 2;
                board[i-1][0] = (board[i-1][0] == 0)?2 : board[i-1][0];
                board[i-1][1] = (board[i-1][1] == 0)?2 : board[i-1][1];
                board[i][1] = (board[i-1][1] == 0)?2 : board[i-1][1];
                board[i+1][0] = (board[i+1][0] == 0)?2 : board[i+1][0];
                board[i+1][1] = (board[i+1][1] == 0)?2 : board[i+1][1];
            }
        }
        
        //우
        for(int i = 1; i<=board.length-2 ; i++){
            if(board[i][board.length-1] == 1){

                board[i][board.length-1] = 2;
                board[i-1][board.length-1] = (board[i-1][board.length-1] == 0)?2 : board[i-1][board.length-1];
                board[i-1][board.length-2] = (board[i-1][board.length-2] == 0)?2 : board[i-1][board.length-2];
                board[i][board.length-2] = (board[i-1][board.length-2] == 0)?2 : board[i-1][board.length-2];
                board[i+1][board.length-2] = (board[i+1][board.length-2] == 0)?2 : board[i+1][board.length-2];
                board[i+1][board.length-1] = (board[i+1][board.length-1] == 0)?2 : board[i+1][board.length-1];
            }
        }
        
        //상
        for(int i = 1; i<=board.length-2 ; i++){
            if(board[0][i] == 1){

                board[0][i] = 2;
                board[0][i-1] = (board[0][i-1] == 0)?2 : board[0][i-1];
                board[0][i+1] = (board[0][i+1] ==  0)?2 : board[0][i+1];
                board[1][i-1] = (board[1][i-1] == 0)?2 : board[1][i-1];
                board[1][i] = (board[1][i] == 0)?2 : board[1][i];
                board[1][i+1] = (board[1][i+1] == 0)?2 : board[1][i+1];
            }
        }
        
        //하
        for(int i = 1; i<=board.length-2 ; i++){
            if(board[board.length-1][i] == 1){

                board[board.length-1][i] = 2;
                board[board.length-1][i-1] = (board[board.length-1][i-1] == 0)?2 : board[board.length-1][i-1];
                board[board.length-1][i+1] = (board[board.length-1][i+1] == 0)?2 : board[board.length-1][i+1];
                board[board.length-2][i-1] = (board[board.length-2][i-1] == 0)?2 : board[board.length-2][i-1];
                board[board.length-2][i] = (board[board.length-2][i] == 0)?2 : board[board.length-2][i];
                board[board.length-2][i+1] = (board[board.length-2][i+1] == 0)?2 : board[board.length-2][i+1];
            }
        }
        
        int count = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if( board[i][j]==2){
                    count ++;
                }
            }
        }

  
        return (board.length * board.length)-count;

    }
}