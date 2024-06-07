package ir.ac.kntu.gamelogic;

public class GameBoard {
    private int length;

    private Snake snake;

    private String[][] board;

    public GameBoard(int length){
        this.length=length;
        board=new String[length][length];
        snake =new Snake(length);
        setBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    private void setBoard(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j< board.length;j++){
                board[i][j]="";
            }
        }
        board[0][0]=" * ";
        board[length-1][length-1]=" F ";
        for (int i = 0; i< snake.getLocationOfNormalSnake().size(); i+=4){
            board[snake.getLocationOfNormalSnake().get(i+1)][snake.getLocationOfNormalSnake().get(i)]+="NH"+(i+1)/4;
            board[snake.getLocationOfNormalSnake().get(i+3)][snake.getLocationOfNormalSnake().get(i+2)]+="NT"+(i+1)/4;
        }
        for (int i = 0; i< snake.getLocationOfWildSnake().size(); i+=4){
            board[snake.getLocationOfWildSnake().get(i+1)][snake.getLocationOfWildSnake().get(i)]+="WH"+(i+1)/4;
            board[snake.getLocationOfWildSnake().get(i+3)][snake.getLocationOfWildSnake().get(i+2)]+="WT"+(i+1)/4;
        }
        for (int i = 0; i< snake.getLocationOfKindSnake().size(); i+=4){
            board[snake.getLocationOfKindSnake().get(i+1)][snake.getLocationOfKindSnake().get(i)]+="KH"+(i+1)/4;
            board[snake.getLocationOfKindSnake().get(i+3)][snake.getLocationOfKindSnake().get(i+2)]+="KT"+(i+1)/4;
        }
    }

    private void deleteWildSnake(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j< board.length;j++){
                board[i][j]=board[i][j].replaceAll("WH(\\d+)","");
                board[i][j]=board[i][j].replaceAll("WT(\\d+)","");
            }
        }
    }

    public void resetWildSnake(){
        deleteWildSnake();
        snake.setWildSnake();
        for (int i = 0; i< snake.getLocationOfWildSnake().size(); i+=4){
            board[snake.getLocationOfWildSnake().get(i+1)][snake.getLocationOfWildSnake().get(i)]+="WH"+(i+1)/4;
            board[snake.getLocationOfWildSnake().get(i+3)][snake.getLocationOfWildSnake().get(i+2)]+="WT"+(i+1)/4;
        }
    }
}
