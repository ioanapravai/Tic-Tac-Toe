import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1 - 9) : ");
            int playerPosition = scan.nextInt();
            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)){
                System.out.println(" Position taken! Make a valid move.");
                playerPosition = scan.nextInt();
            }
            placePiece(gameBoard, playerPosition, "player");
            String result = chackWinner();
            if(result.length() > 0){
                System.out.println(result);
                printGameBoard(gameBoard);
                break;
            }
            Random random = new Random();
            int cpuPosition = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)){
                cpuPosition = random.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPosition, "cpu");
            printGameBoard(gameBoard);
            result = chackWinner();
            if(result.length() > 0){
                System.out.println(result);
                printGameBoard(gameBoard);
                break;
            }
        }
    }

    public static String chackWinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftColumn);
        winningConditions.add(middleColumn);
        winningConditions.add(rightColumn);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        for (List list: winningConditions){
            if (playerPositions.containsAll(list)){
                return "Congratulations, you won!";
            }
            else if(cpuPositions.containsAll(list)){
                return "Cpu wins!";
            }else if(playerPositions.size() + cpuPositions.size() == 9){
                return "Draw";
            }
        }
        return "";
    }

    public static void placePiece(char [][] gameBoard, int position, String user){

        char symbol = 'X';
        if(user.equals("player")){
            symbol = 'X';
            playerPositions.add(position);
        }else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch (position){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                System.out.println("Not Valid.");
                break;
        }
    }

    public static void printGameBoard(char [][] gameBoard){
        for(char[] row : gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

    }
}
