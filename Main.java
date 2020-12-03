package tictactoe;

import java.util.*;

public class Main {
    public static void main(String[] args) {
            menu();
    }

    private static void menu() {

        char[] elements = new char[9];
        char[][] board = new char[3][3];

        Scanner scanner = new Scanner(System.in);

        ArrayList sb = new ArrayList();

        while (true) {

            System.out.println("Input command: ");

            String input = scanner.nextLine();

            String[] words = input.split("\\s+");

            if(words[0].equals("exit")) {
                break;
            }
            if (words.length < 3) {
                System.out.println("Bad parameters");
            } else {
                if (words[0].equals("start") && (words[1].equals("easy") || words[1].equals("user") || words[1].equals("medium") || words[1].equals("hard"))
                    && (words[2].equals("easy") || words[2].equals("user")) || words[2].equals("medium") || words[2].equals("hard")) {

                    sb.add(words[1]);
                    sb.add(words[2]);

                    break;

                } else {
                    System.out.println("Bad parameters");
                }
            }
        }

        String playsX = (String) sb.get(0);
        String playsO = (String) sb.get(1);

        switch (playsX) {
            case "user" : switch (playsO) {
                case "easy" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                    printBoard(board, elements);
                    playWithComputerEasy(board, elements);
                    break;
                case "medium" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                    printBoard(board, elements);
                    playWithComputerMedium(board, elements);
                    break;
                case "user" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                playUserVsUser(board, elements);
                break;
                case "hard" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } printBoard(board, elements);
                 playWithComputerHard(board,elements);
            } break;
            case "easy" : switch (playsO) {
                case "easy" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                playOnlyComputerEasy(board, elements);
                break;
                case "medium" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerEasyMedium(board, elements);
                break;
                case "user" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                    printBoard(board, elements);
                    playWithComputerMedium(board, elements);
                    break;
                case "hard" :for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerEasyHard(board, elements);
            } break;
            case "medium" : switch (playsO) {
                case "medium" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerMedium(board, elements);
                    break;
                case "user" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                    printBoard(board, elements);
                    playWithComputerMedium(board, elements);
                    break;
                case "easy" :for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerMediumEasy(board, elements);
                    break;
                case "hard" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerMediumHard(board, elements);
            } break;
            case "hard" : switch (playsO) {
                case "medium" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerHardMedium(board, elements);
                    break;
                case "user" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                }
                    printBoard(board, elements);
                    playWithComputerHard(board, elements);
                    break;
                case "easy" :for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerEasyHard(board, elements);
                    break;
                case "hard" : for (int i=0; i<elements.length; i++) {
                    elements[i] = ' ';
                } playOnlyComputerHard(board, elements);
            }
        }

    }
    private static void playOnlyComputerMediumEasy(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                mediumMoveComp2(board, elements);
                //EasyMoveComp1(board, elements);
            } else {
                EasyMoveComp1(board, elements);
               // mediumMoveComp1(board, elements);
            }

            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }

            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }
            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }

            start++;
        }
    }
    private static void playOnlyComputerHardMedium(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                hardMoveComp2(board, elements);
            } else {
                mediumMoveComp2(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }
    }
    private static void playOnlyComputerMediumHard(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                mediumMoveComp2(board, elements);
            } else {
                hardMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }
    }
    private static void playOnlyComputerEasyHard(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                EasyMoveComp2(board, elements);
            } else {
                hardMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }
    }
    private static void playOnlyComputerEasyMedium(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                EasyMoveComp2(board, elements);
            } else {
                mediumMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }

    }

    private static void playOnlyComputerMedium(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                mediumMoveComp2(board, elements);
            } else {
                mediumMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }

    }
    private static void playOnlyComputerHard(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                hardMoveComp2(board, elements);
            } else {
                hardMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }
    }
    private static void playOnlyComputerEasy(char[][] board, char[] elements) {

        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                EasyMoveComp2(board, elements);
            } else {
                EasyMoveComp1(board, elements);
            }


            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }

    }

    private static void playUserVsUser(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

//
//            if (start % 2 == 0) {
//                Move(board, elements, start);
//            } else {
//                EasyMoveComp1(board, elements);
//            }
            Move(board, elements, start);
            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }

    }
    private static void playWithComputerMedium(char[][] board, char[] elements){
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {

            if (start % 2 == 0) {
                Move(board, elements, start);
            } else {
                mediumMoveComp2(board, elements);
            }

            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }

    }
    private static void playWithComputerEasy(char[][] board, char[] elements){

        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start<9) {


            if (start % 2 == 0) {
                Move(board, elements, start);
            } else {
                EasyMoveComp1(board, elements);
            }

            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j=0; j<elements.length; j++) {
                if (elements[j] == ' '){
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O'){
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;
        }


    }

    private static void playWithComputerHard(char[][] board, char[] elements) {
        int start = 0;
        int count = 0;
        int nrOfX = 0;
        int nrOfO = 0;

        while (start < 9) {
            if (start % 2 == 0) {
                Move(board, elements, start);
            } else {
                hardMoveComp1(board, elements);
            }

            String solution = checkSolution(board, elements);

            if (solution.equals("X wins") || solution.equals("O wins")) {
                break;
            }


            for (int j = 0; j < elements.length; j++) {
                if (elements[j] == ' ') {
                    count++;
                } else if (elements[j] == 'X') {
                    nrOfX++;
                } else if (elements[j] == 'O') {
                    nrOfO++;
                }
            }

            if (nrOfO + nrOfX == 9) {
                System.out.println("Draw");
                break;
            }


            start++;

        }
    }


    private static void EasyMoveComp1(char[][] board, char[] elements) {

        System.out.println("Making move level \"easy\"");

        boolean flag = true;

        while (flag) {
            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'O';
                flag = false;
            }
            printBoard(board, elements);
        }
    }
    private static void EasyMoveComp2(char[][] board, char[] elements) {

        System.out.println("Making move level \"easy\"");

        boolean flag = true;

        while (flag) {

            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'X';
                flag = false;
            }
            printBoard(board, elements);
        }
    }

    private static void mediumMoveComp2(char[][] board, char[] elements){

        System.out.println("Making move level \"medium\"");

        boolean flag = true;

        while (flag) {

            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (( board[0][0] == 'X' && board[0][1] == 'X') ||( board[0][0] == 'O' && board[0][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O')) {
                    elements[2] = 'O';
                    flag = false;

            } else if ( (board[0][1] == 'X' && board[0][2] == 'X') || (board[0][1] == 'O' && board[0][2] == 'O') && (elements[0] != 'X' && elements[0] != 'O')) {

                    elements[0] = 'O';
                    flag = false;

            } else if (((board[0][0] == 'X' && board[0][2] == 'X') || (board[0][0] == 'O' && board[0][2] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                    elements[1] = 'O';
                    flag = false;

            } else if (((board[1][0] == 'X' && board[1][1] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                    elements[5] = 'O';
                    flag = false;

            } else if (((board[1][0] == 'X' && board[1][2] == 'X') || (board[1][0] == 'O' && board[1][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                    elements[4] = 'O';
                    flag = false;

            } else if (((board[1][1] == 'X' && board[1][2] == 'X') || (board[1][1] == 'O' && board[1][2] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                    elements[3] = 'O';
                    flag = false;

            } else if (((board[2][0] == 'X' && board[2][1] == 'X') || (board[2][0] == 'O' && board[2][1] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                    elements[8] = 'O';
                    flag = false;

            } else if (((board[2][0] == 'X' && board[2][2] == 'X') || (board[2][0] == 'O' && board[2][2] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                    elements[7] = 'O';
                    flag = false;

            } else if  (((board[2][1] == 'X' && board[2][2] == 'X') || (board[2][1] == 'O' && board[2][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                    elements[6] = 'O';
                    flag = false;

            } else if (((board[0][0] == 'X' && board[1][0] == 'X') || (board[0][0] == 'O' && board[1][0] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                    elements[6] = 'O';
                    flag = false;

            } else if (((board[0][0] == 'X' && board[2][0] == 'X') || (board[0][0] == 'O' && board[2][0] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                    elements[3] = 'O';
                    flag = false;

            } else if (((board[1][0] == 'X' && board[2][0] == 'X') || (board[1][0] == 'O' && board[2][0] == 'O') && (elements[0] != 'X' && elements[0] != 'O'))) {

                    elements[0] = 'O';
                    flag = false;

            } else if (((board[0][1] == 'X' && board[1][1] == 'X') || (board[0][1] == 'O' && board[1][1] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                    elements[7] = 'O';
                    flag = false;

            } else if (((board[0][1] == 'X' && board[2][1] == 'X') || (board[0][1] == 'O' && board[2][1] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                    elements[4] = 'O';
                    flag = false;

            } else if (((board[1][1] == 'X' && board[2][1] == 'X') || (board[1][1] == 'O' && board[2][1] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                    elements[1] = 'O';
                    flag = false;

            } else if (((board[0][2] == 'X' && board[1][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                    elements[8] = 'O';
                    flag = false;

            } else if (((board[0][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[2][2] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                    elements[5] = 'O';
                    flag = false;

            } else if (((board[1][2] == 'X' && board[2][2] == 'X') || (board[1][2] == 'O' && board[2][2] == 'O')) && (elements[3] != 'X' && elements[3] != 'O') ) {

                    elements[3] = 'O';
                    flag = false;

            } else if (((board[0][0] == 'X' && board[1][1] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O')) && (elements[8] != 'X' && elements[8] != 'O')) {

                    elements[8] = 'O';
                    flag = false;

            } else if (((board[0][0] == 'X' && board[2][2] == 'X') || (board[0][0] == 'O' && board[2][2] == 'O')) && (elements[4] != 'X' && elements[4] != 'O')) {

                    elements[4] = 'O';
                    flag = false;

            } else if (((board[1][1] == 'X' && board[2][2] == 'X') || (board[1][1] == 'O' && board[2][2] == 'O')) &&  (elements[0] != 'X' && elements[0] != 'O')) {

                    elements[0] = 'O';
                    flag = false;

            } else if (((board[2][0] == 'X' && board[1][1] == 'X') || (board[2][0] == 'O' && board[1][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O'))) {

                    elements[2] = 'O';
                    flag = false;

            } else if (((board[2][0] == 'X' && board[0][2] == 'X') || (board[2][0] == 'O' && board[0][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                    elements[4] = 'O';
                    flag = false;

            } else if (((board[1][1] == 'X' && board[0][2] == 'X') || (board[1][1] == 'O' && board[0][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                    elements[6] = 'O';
                    flag = false;

            } else if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'O';
                flag = false;
            }
            printBoard(board, elements);

        }

    }

    private static void mediumMoveComp1(char[][] board, char[] elements){

        System.out.println("Making move level \"medium\"");

        boolean flag = true;

        while (flag) {

            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (( board[0][0] == 'X' && board[0][1] == 'X') ||( board[0][0] == 'O' && board[0][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O')) {
                elements[2] = 'X';
                flag = false;

            } else if ( (board[0][1] == 'X' && board[0][2] == 'X') || (board[0][1] == 'O' && board[0][2] == 'O') && (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[0][2] == 'X') || (board[0][0] == 'O' && board[0][2] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][1] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][2] == 'X') || (board[1][0] == 'O' && board[1][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[1][2] == 'X') || (board[1][1] == 'O' && board[1][2] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][1] == 'X') || (board[2][0] == 'O' && board[2][1] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][2] == 'X') || (board[2][0] == 'O' && board[2][2] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'X';
                flag = false;

            } else if  (((board[2][1] == 'X' && board[2][2] == 'X') || (board[2][1] == 'O' && board[2][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][0] == 'X') || (board[0][0] == 'O' && board[1][0] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][0] == 'X') || (board[0][0] == 'O' && board[2][0] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[2][0] == 'X') || (board[1][0] == 'O' && board[2][0] == 'O') && (elements[0] != 'X' && elements[0] != 'O'))) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[0][1] == 'X' && board[1][1] == 'X') || (board[0][1] == 'O' && board[1][1] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'X';
                flag = false;

            } else if (((board[0][1] == 'X' && board[2][1] == 'X') || (board[0][1] == 'O' && board[2][1] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][1] == 'X') || (board[1][1] == 'O' && board[2][1] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'X';
                flag = false;

            } else if (((board[0][2] == 'X' && board[1][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[0][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[2][2] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'X';
                flag = false;

            } else if (((board[1][2] == 'X' && board[2][2] == 'X') || (board[1][2] == 'O' && board[2][2] == 'O')) && (elements[3] != 'X' && elements[3] != 'O') ) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][1] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O')) && (elements[8] != 'X' && elements[8] != 'O')) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][2] == 'X') || (board[0][0] == 'O' && board[2][2] == 'O')) && (elements[4] != 'X' && elements[4] != 'O')) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][2] == 'X') || (board[1][1] == 'O' && board[2][2] == 'O')) &&  (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[1][1] == 'X') || (board[2][0] == 'O' && board[1][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O'))) {

                elements[2] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[0][2] == 'X') || (board[2][0] == 'O' && board[0][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[0][2] == 'X') || (board[1][1] == 'O' && board[0][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'X';
                flag = false;
            }
            printBoard(board, elements);

        }

    }


    private static void hardMoveComp1(char[][] board, char[] elements){
        System.out.println("Making move level \"hard\"");
        boolean flag = true;

        while (flag) {

            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (( board[0][0] == 'X' && board[0][1] == 'X') ||( board[0][0] == 'O' && board[0][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O')) {
                elements[2] = 'X';
                flag = false;

            } else if ( (board[0][1] == 'X' && board[0][2] == 'X') || (board[0][1] == 'O' && board[0][2] == 'O') && (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[0][2] == 'X') || (board[0][0] == 'O' && board[0][2] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][1] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][2] == 'X') || (board[1][0] == 'O' && board[1][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[1][2] == 'X') || (board[1][1] == 'O' && board[1][2] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][1] == 'X') || (board[2][0] == 'O' && board[2][1] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][2] == 'X') || (board[2][0] == 'O' && board[2][2] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'X';
                flag = false;

            } else if  (((board[2][1] == 'X' && board[2][2] == 'X') || (board[2][1] == 'O' && board[2][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][0] == 'X') || (board[0][0] == 'O' && board[1][0] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][0] == 'X') || (board[0][0] == 'O' && board[2][0] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[1][0] == 'X' && board[2][0] == 'X') || (board[1][0] == 'O' && board[2][0] == 'O') && (elements[0] != 'X' && elements[0] != 'O'))) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[0][1] == 'X' && board[1][1] == 'X') || (board[0][1] == 'O' && board[1][1] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'X';
                flag = false;

            } else if (((board[0][1] == 'X' && board[2][1] == 'X') || (board[0][1] == 'O' && board[2][1] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][1] == 'X') || (board[1][1] == 'O' && board[2][1] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'X';
                flag = false;

            } else if (((board[0][2] == 'X' && board[1][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[0][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[2][2] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'X';
                flag = false;

            } else if (((board[1][2] == 'X' && board[2][2] == 'X') || (board[1][2] == 'O' && board[2][2] == 'O')) && (elements[3] != 'X' && elements[3] != 'O') ) {

                elements[3] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][1] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O')) && (elements[8] != 'X' && elements[8] != 'O')) {

                elements[8] = 'X';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][2] == 'X') || (board[0][0] == 'O' && board[2][2] == 'O')) && (elements[4] != 'X' && elements[4] != 'O')) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][2] == 'X') || (board[1][1] == 'O' && board[2][2] == 'O')) &&  (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[1][1] == 'X') || (board[2][0] == 'O' && board[1][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O'))) {

                elements[2] = 'X';
                flag = false;

            } else if (((board[2][0] == 'X' && board[0][2] == 'X') || (board[2][0] == 'O' && board[0][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'X';
                flag = false;

            } else if (((board[1][1] == 'X' && board[0][2] == 'X') || (board[1][1] == 'O' && board[0][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'X';
                flag = false;

            } else if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'X';
                flag = false;
            }
            printBoard(board, elements);

        }

    }

    private static void hardMoveComp2(char[][] board, char[] elements) {
        System.out.println("Making move level \"hard\"");
        boolean flag = true;

        while (flag) {

            Random random = new Random();
            int randomNumber = random.nextInt(9);


            if (( board[0][0] == 'X' && board[0][1] == 'X') ||( board[0][0] == 'O' && board[0][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O')) {
                elements[2] = 'O';
                flag = false;

            } else if ( (board[0][1] == 'X' && board[0][2] == 'X') || (board[0][1] == 'O' && board[0][2] == 'O') && (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'O';
                flag = false;

            } else if (((board[0][0] == 'X' && board[0][2] == 'X') || (board[0][0] == 'O' && board[0][2] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'O';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][1] == 'X') || (board[1][0] == 'O' && board[1][1] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'O';
                flag = false;

            } else if (((board[1][0] == 'X' && board[1][2] == 'X') || (board[1][0] == 'O' && board[1][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'O';
                flag = false;

            } else if (((board[1][1] == 'X' && board[1][2] == 'X') || (board[1][1] == 'O' && board[1][2] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'O';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][1] == 'X') || (board[2][0] == 'O' && board[2][1] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'O';
                flag = false;

            } else if (((board[2][0] == 'X' && board[2][2] == 'X') || (board[2][0] == 'O' && board[2][2] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'O';
                flag = false;

            } else if  (((board[2][1] == 'X' && board[2][2] == 'X') || (board[2][1] == 'O' && board[2][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'O';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][0] == 'X') || (board[0][0] == 'O' && board[1][0] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'O';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][0] == 'X') || (board[0][0] == 'O' && board[2][0] == 'O') && (elements[3] != 'X' && elements[3] != 'O'))) {

                elements[3] = 'O';
                flag = false;

            } else if (((board[1][0] == 'X' && board[2][0] == 'X') || (board[1][0] == 'O' && board[2][0] == 'O') && (elements[0] != 'X' && elements[0] != 'O'))) {

                elements[0] = 'O';
                flag = false;

            } else if (((board[0][1] == 'X' && board[1][1] == 'X') || (board[0][1] == 'O' && board[1][1] == 'O') && (elements[7] != 'X' && elements[7] != 'O'))) {

                elements[7] = 'O';
                flag = false;

            } else if (((board[0][1] == 'X' && board[2][1] == 'X') || (board[0][1] == 'O' && board[2][1] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'O';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][1] == 'X') || (board[1][1] == 'O' && board[2][1] == 'O') && (elements[1] != 'X' && elements[1] != 'O'))) {

                elements[1] = 'O';
                flag = false;

            } else if (((board[0][2] == 'X' && board[1][2] == 'X') || (board[0][2] == 'O' && board[1][2] == 'O') && (elements[8] != 'X' && elements[8] != 'O'))) {

                elements[8] = 'O';
                flag = false;

            } else if (((board[0][2] == 'X' && board[2][2] == 'X') || (board[0][2] == 'O' && board[2][2] == 'O') && (elements[5] != 'X' && elements[5] != 'O'))) {

                elements[5] = 'O';
                flag = false;

            } else if (((board[1][2] == 'X' && board[2][2] == 'X') || (board[1][2] == 'O' && board[2][2] == 'O')) && (elements[3] != 'X' && elements[3] != 'O') ) {

                elements[3] = 'O';
                flag = false;

            } else if (((board[0][0] == 'X' && board[1][1] == 'X') || (board[0][0] == 'O' && board[1][1] == 'O')) && (elements[8] != 'X' && elements[8] != 'O')) {

                elements[8] = 'O';
                flag = false;

            } else if (((board[0][0] == 'X' && board[2][2] == 'X') || (board[0][0] == 'O' && board[2][2] == 'O')) && (elements[4] != 'X' && elements[4] != 'O')) {

                elements[4] = 'O';
                flag = false;

            } else if (((board[1][1] == 'X' && board[2][2] == 'X') || (board[1][1] == 'O' && board[2][2] == 'O')) &&  (elements[0] != 'X' && elements[0] != 'O')) {

                elements[0] = 'O';
                flag = false;

            } else if (((board[2][0] == 'X' && board[1][1] == 'X') || (board[2][0] == 'O' && board[1][1] == 'O') && (elements[2] != 'X' && elements[2] != 'O'))) {

                elements[2] = 'O';
                flag = false;

            } else if (((board[2][0] == 'X' && board[0][2] == 'X') || (board[2][0] == 'O' && board[0][2] == 'O') && (elements[4] != 'X' && elements[4] != 'O'))) {

                elements[4] = 'O';
                flag = false;

            } else if (((board[1][1] == 'X' && board[0][2] == 'X') || (board[1][1] == 'O' && board[0][2] == 'O') && (elements[6] != 'X' && elements[6] != 'O'))) {

                elements[6] = 'O';
                flag = false;

            } else if (elements[randomNumber] != 'X' && elements[randomNumber] != 'O') {
                elements[randomNumber] = 'O';
                flag = false;
            }
            printBoard(board, elements);

        }
    }


    private static void printBoard(char[][] board, char[] elements) {

        for (int i=0; i< elements.length; i++) {
            if (elements[i] == '_') {
                elements[i] = ' ';
            }
        }
        System.out.println("---------");
        System.out.println("| " + elements[0] + " " + elements[1] + " " + elements[2] + " |");
        System.out.println("| " + elements[3] + " " + elements[4] + " " + elements[5] + " |");
        System.out.println("| " + elements[6] + " " + elements[7] + " " + elements[8] + " |");
        System.out.println("---------");
        System.out.println();
    }

    public static void Move(char[][] board , char[] elements, int x) {
        Scanner scanner = new Scanner(System.in);
        int input1 = 0;
        boolean flag = false;
        int input2 = 0;
        if (x%2 == 0) {
            flag = true;
        }


        try {
                System.out.println("Enter the coordinates: ");


                    int number1 = scanner.nextInt();

                    int number2 = scanner.nextInt();


                    if ((number1 > 3) || (number1 < 1)) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        Move(board, elements, x);
                    } else if ((number2 > 3) || (number2 < 1)) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        Move(board, elements, x);
                    } else {
                        input1 = number1;
                        input2 = number2;
                    }

            } catch (InputMismatchException exception) {
                System.out.println("You should enter numbers! ");
                Move(board, elements, x);
            }


        switch (input1) {
            case 1: switch (input2) {
                case 1: if((board[2][0] == 'X') || (board [2][0] == 'O')) {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[6] = 'X';
                    } else {
                        elements[6]  = 'O';
                    }
                    printBoard(board , elements);

                }
                    break;
                case 2: if((board[1][0] == 'X') || board [1][0] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[3]  = 'X';
                    } else {
                        elements[3]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
                case 3: if((board[0][0] == 'X') || board [0][0] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[0]  = 'X';
                    } else {
                        elements[0]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
            } break;
            case 2: switch (input2) {
                case 1: if((board[2][1] == 'X') || board [2][1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[7]  = 'X';
                    } else {
                        elements[7]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
                case 2: if((board[1][1] == 'X') || board [1][1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[4]  = 'X';
                    } else {
                        elements[4]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
                case 3: if((board[0][1] == 'X') || board [0][1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[1]  = 'X';
                    } else {
                        elements[1]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
            }
                break;
            case 3: switch(input2) {
                case 1: if((board[2][2] == 'X') || board [2][2] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[8]  = 'X';
                    } else {
                        elements[8]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
                case 2: if((board[1][2] == 'X') || board [1][2] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[5]  = 'X';
                    } else {
                        elements[5]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
                case 3: if((board[0][2] == 'X') || board [0][2] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    Move(board,elements,x);
                } else {
                    if (flag) {
                        elements[2]  = 'X';
                    } else {
                        elements[2]  = 'O';
                    }
                    printBoard(board , elements);
                }
                    break;
            } break;
        }
    }

    public static String checkSolution(char[][] board, char[] elements){
        String solution = null;
        int tr = 0;
        int sumX = 0;
        int sumO = 0;
        boolean dif = true;
        boolean diagonala = true;
        int line1X =0 , line2X = 0, line3X = 0;
        int line1O = 0, line2O = 0, line30 = 0;
        int line1_ = 0, line2_=0, line3_ = 0;
        int col1X = 0, col2X = 0, col3X =0;
        int col1O = 0, col2O = 0, col3O = 0;
        int col1_ = 0, col2_ = 0, col3_ =0;
        for (int i =0 ; i< 3; i++) {
            board[0][i] = elements[i];

        }
        for (int i =3 ; i< 6; i++) {
            board[1][i-3] = elements[i];

        }
        for (int i =6 ; i< 9; i++) {
            board[2][i-6] = elements[i];

        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j< board.length; j++) {
                if (board[i][j] == 'X') {
                    sumX++;
                } else if (board[i][j] == 'O'){
                    sumO++;
                }
            }
        }
        int x = 0;
        int y = 0;
        while (x<3){
            for (int j=0; j< board.length; j++) {
                if (board[x][j] == 'X') {
                    switch (x) {
                        case 0 :line1X ++;
                            break;
                        case 1: line2X ++;
                            break;
                        case 2: line3X ++;
                            break;
                    }

                } else if (board[x][j] == 'O'){
                    switch (x) {
                        case 0 : line1O++;
                            break;
                        case 1: line2O++;
                            break;
                        case 2 : line30++;
                            break;
                    }
                } else if (board[x][j] == '_'){
                    switch (x) {
                        case 0 : line1_++;
                            break;
                        case 1: line2_++;
                            break;
                        case 2: line3_++;
                            break;
                    }
                }
            }
            x++;
        }
        while (y<3){
            for (int j=0; j< board.length; j++) {
                if (board[j][y] == 'X') {
                    switch (y) {
                        case 0 :col1X ++;
                            break;
                        case 1: col2X ++;
                            break;
                        case 2: col3X ++;
                            break;
                    }

                } else if (board[j][y] == 'O'){
                    switch (y) {
                        case 0 : col1O++;
                            break;
                        case 1: col2O++;
                            break;
                        case 2 : col3O++;
                            break;
                    }
                } else if (board[j][y] == '_'){
                    switch (y) {
                        case 0 : col1_++;
                            break;
                        case 1: col2_++;
                            break;
                        case 2: col3_++;
                            break;
                    }
                }
            }
            y++;
        }



        // System.out.println(col1X + "" + col2X + "" + col3X+ "" + line1X + "" + line2X + "" + line3X);
        if (sumO - sumX > 1) {
            dif = false;
        } else if (sumX - sumO > 1){
            dif = false;
        } else if ( (col1O == 3) && (col2O == 3) ) {
            dif = false;
        } else if ( (col2O == 3) && (col3O == 3) ) {
            dif = false;
        } else if ( (col1O == 3) && (col3O == 3) ) {
            dif = false;
        } else if ( (line1O == 3) && (line2O == 3) ) {
            dif = false;
        } else if ( (line2O == 3) && (line30 == 3) ) {
            dif = false;
        } else if ( (line1O == 3) && (line30 == 3) ) {
            dif = false;
        } else if ( (col1X == 3) && (col2X == 3) ) {
            dif = false;
        } else if ( (col2X == 3) && (col3X == 3) ) {
            dif = false;
        } else if ( (col1X == 3) && (col3X == 3) ) {
            dif = false;
        } else if ( (line1X == 3) && (line2X == 3) ) {
            dif = false;
        } else if ( (line2X == 3) && (line3X == 3) ) {
            dif = false;
        } else if ( (line1X == 3) && (line3X == 3) ) {
            dif = false;
        } else if ( (col1X == 3) && (col2O == 3) ) {
            dif = false;
        } else if ( (col1X == 3) && (col3O == 3)) {
            dif = false;
        } else if ( (col2X == 3) && (col3O == 3)) {
            dif = false;
        }

        if (!dif) {
            System.out.println("Impossible");
            solution = "Impossible";
        } else if (line1X == 3 || line2X == 3 || line3X == 3 || col1X ==3 || col2X ==3 || col3X == 3){
            System.out.println("X wins");
            solution = "X wins";
        } else if ( line1O == 3 || line2O == 3 || line30 == 3 || col1O ==3 || col2O ==3 || col3O == 3) {
            System.out.println("O wins");
            solution = "O wins";
        } else if(line1O <3 || line2O<3 || line30<0){
            solution = "Draw";
        } else if ((board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')) {
            System.out.println("X wins");
            solution = "X wins";
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
                    //System.out.println("X wins");
                    diagonala = false;
                    tr = 1;
                }
                if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
                    //System.out.println("X wins");
                    diagonala = false;
                    tr = 2;
                }
                if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') {
                    //System.out.println("0 wins");
                    diagonala = false;
                    tr = 3;
                }
                if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O') {
                    //System.out.println("0 wins");
                    diagonala = false;
                    tr = 4;
                }

            }
        }

        if (!diagonala) {
            switch (tr) {
                case 1:
                case 2:
                    System.out.println("X wins");
                    solution = "X wins";
                    break;
                case 3:
                case 4:
                    System.out.println("O wins");
                    solution = "O wins";
                    break;
            }
        }
        return solution;
    }
}

