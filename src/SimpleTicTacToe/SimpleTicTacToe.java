package SimpleTicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleTicTacToe {

    private char[][] gameGrid;
    private char activePlayer;
    private boolean won;
    private int pos;
    private int row;
    private int col;


    public SimpleTicTacToe() {
        row = -1;
        col = -1;
        activePlayer = 'X';
        won = false;
        pos = 0;
        gameGrid = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
    }

    private void printBoard() {
        System.out.println("---------");
        for (char[] row : gameGrid) {
            System.out.print("| ");
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private void enterInput() {
        System.out.println("Enter the coordinates: ");

        try {
            Scanner scanner = new Scanner(System.in);
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row > 3 || col > 3) {
                System.out.println("Coordinates should be from 1 to 3");
                enterInput();
            }
        } catch (InputMismatchException e) {
            System.out.println("You should enter a number!");
            enterInput();

        }
    }

    private boolean executeMove(char[][] gameGrid, char activePlayer) {
        enterInput();

        if (gameGrid[row - 1][col - 1] == ' ') {
            gameGrid[row - 1][col - 1] = activePlayer;
            return true;
        }
        checkOccupied();
        executeMove(gameGrid, activePlayer);
        return true;
    }

    private void checkOccupied() {
        if (gameGrid[row - 1][col - 1] == 'X' || gameGrid[row - 1][col - 1] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
        }
    }

    private boolean checkFirstDiagonal(char[][] gameGrid, char activePlayer) {
        return gameGrid[0][0] == activePlayer && gameGrid[1][1] == activePlayer && gameGrid[2][2] == activePlayer;
    }

    private boolean checkSecondDiagonal(char[][] gameGrid, char activePlayer) {
        return gameGrid[0][2] == activePlayer && gameGrid[1][1] == activePlayer && gameGrid[2][0] == activePlayer;
    }

    private boolean checkRows(char[][] gameGrid, char activePlayer) {
        for (char[] chars : gameGrid) {
            if (chars[0] == activePlayer && chars[1] == activePlayer && chars[2] == activePlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[][] gameGrid, char activePlayer) {
        for (int j = 0; j < gameGrid[0].length; ++j) {
            if (gameGrid[0][j] == activePlayer && gameGrid[1][j] == activePlayer && gameGrid[2][j] == activePlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinner(char[][] gameGrid, char activePlayer) {
        return checkFirstDiagonal(gameGrid, activePlayer) || checkSecondDiagonal(gameGrid, activePlayer) ||
                checkRows(gameGrid, activePlayer) || checkColumns(gameGrid, activePlayer);
    }

    public void playGame() {
        pos = 0;
        while (pos < 9 && !won) {
            printBoard();
            boolean move = executeMove(gameGrid, activePlayer);

            if (move) {
                pos++;
                won = checkWinner(gameGrid, activePlayer);
                if (won) {
                    printBoard();
                    printWinner();
                    break;
                }
                changePlayer();
            }
        }
        if (!won) {
            printBoard();
            System.out.println("Draw");
        }
    }

    private void printWinner() {
        System.out.println(activePlayer + " wins");
    }

    private void changePlayer() {
        activePlayer = activePlayer == 'O' ? 'X' : 'O';
    }
}
