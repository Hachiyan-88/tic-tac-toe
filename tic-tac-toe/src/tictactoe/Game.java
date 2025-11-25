package tictactoe;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReplayManager replayManager = new ReplayManager();

        System.out.println("===〇×ゲーム===");

        do {
            Board board = new Board();
            Player player = new Player(scanner, board);
            CPU cpu;

            
            int cpuLevel = 0;
            while(cpuLevel != 1 && cpuLevel != 2) {
                cpuLevel = InputUtil.readInt(scanner, "CPUの強さを選択してください (1.弱い 2.強い): ");
                if(cpuLevel != 1 && cpuLevel != 2) {
                    System.out.println("無効な選択肢です。再度入力してください");
                }
            }

            cpu = (cpuLevel == 1) ? new EasyCPU(board) : new HardCPU(board);
            System.out.println(cpuLevel == 1 ? "CPUの強さ：弱い" : "CPUの強さ：強い");

            
            TurnManager turnManager = new TurnManager(scanner);
            int turnCount = 0; 


            while(true) {
                if(turnManager.isPlayerTurn(turnCount)) {
                    GameController.playerTurn(board, player); 
                } else {
                    GameController.cpuTurn(board, cpu, cpuLevel); 
                }

                
                if(GameController.checkGameEnd(board, '×', "あなたの勝利です") ||
                   GameController.checkGameEnd(board, '〇', "CPUの勝利です") ||
                   GameController.isBoardFull(board)) break;

                turnCount++;
            }

            
            replayManager.askPlayAgain(scanner);

        } while(replayManager.shouldPlayAgain());

        System.out.println("ゲーム終了します。ありがとうございました");
        scanner.close();
    }
}

