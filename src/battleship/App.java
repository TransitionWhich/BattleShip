package battleship;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        boolean finishFlag = false;
        int counter = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> updatedArray;

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        char[][] player1G = player1.getPlayerGrid();
        char[][] player2G = player2.getPlayerGrid();

        ArrayList<ArrayList<ArrayList<Integer>>> player2Array = player2.getPlayerArray();
        ArrayList<ArrayList<ArrayList<Integer>>> player1Array = player1.getPlayerArray();

        do {
            if (counter % 2 == 0) {
                updatedArray = player1.playGame(player1G, player2G, player2Array);
                updateArray(updatedArray, player2);
                player2Array = player2.getPlayerArray();
                counter++;
            } else {
                updatedArray = player2.playGame(player2G, player1G, player1Array);
                updateArray(updatedArray, player1);
                player1Array = player1.getPlayerArray();
                counter++;
            }
            finishFlag = Player.getFlag();
        } while (!finishFlag);

        /*
         * Inputs for player 1 - f3 f7 <enter> a1 d1 <enter> j10 j8 <enter> b9 d9 <enter> i2 j2
         * Press enter once again
         * Inputs for player 2 - h2 h6 <enter> f3 f6 <enter> f8 h8 <enter> d4 d6 <enter> c8 d8
         * Press enter to start the game
         * 
         * player 1 chance -> h4  (hit message should show)
         * player 2 chance -> a1  (hit message should show) 
         * 
         * player 2 - f3, f4, f5, f6, f7, a1, b1, c1, d1, j8. j9, j10, b9, c9, d9, i2, j2
         * player 1 - h2, h4, h3, h5, h6, f3, f4, f5, f6, f8, g8, h8, d4, d5, d6, c8, d8
         */
    }

    public static void updateArray(ArrayList<ArrayList<ArrayList<Integer>>> update, Player player) {
        player.setPlayerArray(update);
    }
}
