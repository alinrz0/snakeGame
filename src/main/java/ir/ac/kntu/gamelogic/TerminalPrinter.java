package ir.ac.kntu.gamelogic;

public class TerminalPrinter extends DiceController{
    private int length;

    public TerminalPrinter(int length){
        super(length);
        this.length=length;
    }

    public void printDice(){
        rollDice(length);
        System.out.println("DICE: "+getDice());
    }

    public void printLife(){
        System.out.println("Health: "+getPerson().getLife());
    }

    public void printBoard(){
        for (int i=length-1;i>=0;i--){
            for (int j=0;j<length;j++){
                if (getGameBoard().getBoard()[i][j].equals("")) {
                    System.out.print("|   |");
                }else {
                    System.out.print("|"+getGameBoard().getBoard()[i][j]+"|");
                }
            }
            System.out.print("\n");
        }
        if (getPerson().getLife()==0){
            System.out.println("YOU LOSE!");
            System.exit(0);
        }
        if (getGameBoard().getBoard()[length-1][length-1].contains("P")){
            System.out.println("YOU WIN!");
            System.exit(0);
        }
    }
}
