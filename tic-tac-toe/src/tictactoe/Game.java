package tictactoe;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner scanner = new Scanner(System.in);
		ReplayManager replayManager = new ReplayManager();
		
		System.out.println("===〇×ゲーム===");
		
		do {
			Board board = new Board();
			Player player = new Player(scanner, board);
			CPU cpu;
			
			int cpuLevel = 0;
			while(cpuLevel != 1 && cpuLevel != 2) {
				
				cpuLevel = InputUtil.readInt(scanner, "CPUの強さを選択してください(1弱い)(2強い)");
				
				if(cpuLevel != 1 && cpuLevel != 2) {
					System.out.println("無効な選択肢です。再度入力してください");
				}
				
			}
			
			System.out.println(cpuLevel == 1 ? "CPUの強さ：弱い" : "CPUの強さ：強い");
			
			if(cpuLevel == 1) {
				cpu = new EasyCPU(board);
			}else {
				cpu = new HardCPU(board);
			}
			
			board.print();
			
			while(true) {
				
				GameController.playerTurn(board, player);

				
				if(GameController.checkGameEnd(board, '×', "あなたの勝利です")) break;
				
				
				if(GameController.isBoardFull(board)) {
					System.out.println("引き分けです");
					break;
				}
				
				GameController.cpuTurn(board, cpu, cpuLevel);
				
				if(GameController.checkGameEnd(board, '〇', "CPUの勝利です")) break;
				
				if(GameController.isBoardFull(board)) {
					System.out.println("引き分けです");
					break;
				}
			}
		
			replayManager.askPlayAgain(scanner);
			
		}while (replayManager.shouldPlayAgain());
		
		System.out.println("ゲーム終了します。ありがとうございました");
		scanner.close();


	}
	
}

