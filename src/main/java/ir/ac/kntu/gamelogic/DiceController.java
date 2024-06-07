package ir.ac.kntu.gamelogic;

import java.util.Random;

public class DiceController{
    private int length;

    private Dice dice;

    private GameBoard gameBoard;

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Dice getDice() {
        return dice;
    }

    private Person person=new Person();

    public DiceController(int length){
        this.length=length;
        gameBoard=new GameBoard(length);
    }

    public void rollDice(int length){
        this.length=length;
        Random random=new Random();
        int temp=random.nextInt(Dice.values().length);
        dice=Dice.values()[temp];
        checkDice();
        getGameBoard().resetWildSnake();
        setPersonLocation();
        checkSnakes();
        setPersonLocation();
    }

    public Person getPerson() {
        return person;
    }

    private void checkDice(){
        if (dice.equals(Dice.left_1)&&person.getX()>0){
            person.setX(person.getX()-1);
        }else if (dice.equals(Dice.left_2)&&person.getX()>1){
            person.setX(person.getX()-2);
        }else if (dice.equals(Dice.right_1)&&person.getX()<length-1){
            person.setX(person.getX()+1);
        }else if (dice.equals(Dice.right_2)&&person.getX()<length-2){
            person.setX(person.getX()+2);
        }else if (dice.equals(Dice.up_1)&&person.getY()<length-1){
            person.setY(person.getY()+1);
        }else if (dice.equals(Dice.up_2)&&person.getY()<length-2){
            person.setY(person.getY()+2);
        }else if (dice.equals(Dice.down_1)&&person.getY()>0){
            person.setY(person.getY()-1);
        }else if (dice.equals(Dice.down_2)&&person.getY()>1){
            person.setY(person.getY()-2);
        }else if (dice.equals(Dice.upLife)){
            person.setLife(1 + (person.getLife()));
        }
    }

    public void checkSnakes(){
        String tail ="z";
        String[][] tempBoard=new String[length][length];
        tempBoard=gameBoard.getBoard();
        for (int i=0;i< length;i++){
            for (int j=0;j<length;j++){
                if (gameBoard.getBoard()[i][j].contains("P")&&gameBoard.getBoard()[i][j].contains("H")){
                    if(gameBoard.getBoard()[i][j].contains("W")){
                        person.setLife((person.getLife())-1);
                    }
                    tempBoard[i][j]=tempBoard[i][j].replace("P","");
                    gameBoard.setBoard(tempBoard);
                    tail=tempBoard[i][j].replace("H","T");
                }
            }
        }
        for (int i=0;i< length;i++){
            for (int j=0;j< length;j++){
                if (gameBoard.getBoard()[i][j].contains(tail)){
                    person.setX(j);
                    person.setY(i);
                }
            }
        }
    }

    public void setPersonLocation(){
        String[][] boardTemp=new String[length][length];
        boardTemp=gameBoard.getBoard();
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                boardTemp[i][j]=boardTemp[i][j].replace("P","");
            }
        }
        boardTemp[person.getY()][person.getX()]+="P";
        gameBoard.setBoard(boardTemp);
    }
}
