package ir.ac.kntu;

import ir.ac.kntu.gamelogic.TerminalPrinter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("write length of board:");
        int length=scanner.nextInt();
        TerminalPrinter terminalPrinter = new TerminalPrinter(length);
        String roll=scanner.nextLine();
        while (!roll.equals("EXIT")) {
            terminalPrinter.printDice();
            terminalPrinter.printLife();
            terminalPrinter.printBoard();
            roll=scanner.nextLine();
        }
    }
}