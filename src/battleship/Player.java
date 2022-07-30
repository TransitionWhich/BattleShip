package battleship;

import java.util.List;
import java.util.Scanner;

public class Player {
    final String name;
    Game game;
    private final Scanner scanner = new Scanner(System.in);

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

    public List<List<List<Integer>>> getPlayerArray() {
        return game.getShipArray();
    }

    public void setPlayerArray(List<List<List<Integer>>> newArray) {
        game.setArray(newArray);
    }

    public List<List<List<Integer>>> playGame(char[][] playerGrid, char[][] oppGrid,
            List<List<List<Integer>>> oppArray) {
        return game.oneRound(playerGrid, oppGrid, this.name, oppArray);
    }

    public static boolean getFlag() {
        return Game.finished;
    }

}
