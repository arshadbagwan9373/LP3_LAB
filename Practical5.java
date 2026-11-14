public class Practical5 {

    static int N = 4;

    static boolean issafe(int board[][] , int row , int col){

        //check same row
        for(int i = 0 ; i<N;i++){
            if (board[row][i] == 1){
                return false;
            }
        }

        //check upper left
        for(int i=row,j=col;i >=0 && j>=0 ; i--,j--){

            if(board[i][j]==1){
                return false;
            }
        }

        //check upper right
        for(int i=row,j=col;i < N && j>=0 ; i++,j--){

            if(board[i][j]==1){
                return false;
            }
        }
        //check lower left
        for(int i=row,j=col;i >=0 && j<N ; i--,j++){

            if(board[i][j]==1){
                return false;
            }
        }

        //check lower right
        for(int i=row,j=col;i < N && j < N ; i++,j++){

            if(board[i][j]==1){
                return false;
            }
        }


        return true;
    }

    static boolean solve(int[][] board , int col){

        if(col >= N){
            return true;
        }

        //check for already placed queen in column
        for(int i=0;i<N;i++){
            if(board[i][col] == 1){
                return solve(board,col +1);
            }
        }

        //find pos in the column
        for(int row=0;row<N;row++){

            if(issafe(board,row,col)){
                board[row][col] = 1;
                if(solve(board,col+1)){
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;

    }



    static void printboard(int board[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        System.out.println("N-Queens Problem Solution:");
        int[][] board = new int[N][N];

        //already placed queen
        board[0][2] = 1;

        

        if (solve(board, 0)) {
            printboard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
        
    }

    






    

