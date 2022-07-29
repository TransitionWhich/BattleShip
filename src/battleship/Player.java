package battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    Game game;
    private Scanner scanner = new Scanner(System.in);

    Player(String name) {
        this.name = name;
        System.out.println(this.name + ", place your ships on the game field");
        getInput();
    }

    public void getInput() {
        game = new Game();
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
    }

    public char[][] getPlayerGrid() {
        return game.getGrid();
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getPlayerArray() {
        return game.getShipArray();
    }

    public void setPlayerArray(ArrayList<ArrayList<ArrayList<Integer>>> newArray) {
        game.setArray(newArray);
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> playGame(char[][] playerGrid, char[][] oppGrid,
            ArrayList<ArrayList<ArrayList<Integer>>> oppArray) {
        return game.oneRound(playerGrid, oppGrid, this.name, oppArray);
    }

    public static boolean getFlag() {
        return Game.finished;
    }

}
