package battleship;

import java.util.List;
import java.util.Scanner;

public class Game extends Field {
    private final Scanner scanner = new Scanner(System.in);
    char[][] newField;
    static boolean finished = false;
    int sankShips = 0;
    String status = " ";

    Game() {
        super();
    }

    public List<List<List<Integer>>> oneRound(char[][] playerGrid, char[][] oppGrid, String playerName,
            List<List<List<Integer>>> oppArray) {
        newField = super.createGrid(10);
        System.out.print("---------------------\n");
        super.display(playerGrid);

        System.out.println("\n" + playerName + ", it's your turn:");
        super.newGrid = oppGrid;
        super.setArray(oppArray);

        playGame();
        status = " ";
        super.newGrid = playerGrid;
        return super.shipsCoordinates;
    }

    public void playGame() {
        int[] coordinates;
        do {
            coordinates = getInput();
        } while (!checkCoord(coordinates));

        char element = super.getElement(coordinates[0], coordinates[1]);
        hitMiss(element, coordinates[0], coordinates[1]);
        checkSunk();
        if (status.equals("Hit")) {
            System.out.println("You hit a ship!");
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
            scanner.nextLine();
        } else if (status.equals("Sunk")) {
            System.out.println("You sank a ship!");
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
            scanner.nextLine();
        } else if (status.equals("Finish")) {
            System.out.println("You sank the last ship. You won. Congratulations!");
        }
    }

    public void checkSunk() {
        for (int i = 0; i < super.shipsCoordinates.size(); i++) {
            if (super.shipsCoordinates.get(i).isEmpty()) {
                super.shipsCoordinates.remove(i);
                sankShips++;
            }
        }
        if (sankShips == 5) {
            status = "Finish";
            finished = true;
        }
    }

    public int[] getInput() {
        String input = scanner.next().toUpperCase();
        int rowNew = input.charAt(0) - 65;
        int colNew = Integer.parseInt(input.substring(1)) - 1;
        return new int[]{ rowNew, colNew };
    }

    public boolean checkCoord(int[] userIn) {
        if (userIn[0] < 0 || userIn[0] > 9 || userIn[1] < 0 || userIn[1] > 9) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return false;
        } else
            return true;
    }

    public void hitMiss(char element, int row, int col) {
        if (element == 'O' || element == 'X') {
            super.updateElement(row, col, 'X');
            newField[row][col] = 'X';
            if (element == 'X')
                status = "Hit";
            else
                removeHit(row, col);
        } else {
            super.updateElement(row, col, 'M');
            newField[row][col] = 'M';
            System.out.println("You missed!");
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void removeHit(int r, int c) {
        List<Integer> coor = List.of(r,c);

        for (List<List<Integer>> shipsCoordinate : super.shipsCoordinates) {
            for (int j = 0; j < shipsCoordinate.size(); j++) {
                if (shipsCoordinate.get(j).equals(coor)) {
                    shipsCoordinate.remove(j);
                    int size = shipsCoordinate.size();

                    if (size == 0) {
                        status = "Sunk";
                    } else
                        status = "Hit";
                }
            }

        }
    }

    public char[][] getGrid() {
        return super.newGrid;
    }

    public List<List<List<Integer>>> getShipArray() {
        return super.shipsCoordinates;
    }
}
