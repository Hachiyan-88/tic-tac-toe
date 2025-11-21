package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("=== 〇×ゲーム ===");
		
		System.out.println("CPUの強さをえらんでください(1.弱め)(2.強め)");
		int cpuLevel = scanner.nextInt();
		
		
		if(cpuLevel == 1) {
			System.out.println("1.弱めのCPUを選びました");
		} else if(cpuLevel == 2){
			System.out.println("2.強めのCPUを選びました");
		} else {
			System.out.println("1,2のどちらかを入力してください");
		}
		
		
		//何もない盤面を準備
		char[][] board = new char[3][3];
		
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
		
		boolean playerTurn = true;
		int moves = 0;
		
		while(moves < 9) {
			
			printBoard(board);
			
			
			//プレーヤーのターン
			if(playerTurn) {
				
				int row, col;
				
				//プレーヤーの処理
				while(true) {
					System.out.println("行（0～2）を入力してください");
					row = scanner.nextInt();
					
					System.out.println("列（0～2）を入力してください");
					col = scanner.nextInt();
					
					
					if(row >= 0 && row < 3 && col >= 0 && col < 3) {
						
						if(board[row][col] == ' ') {
							board[row][col] = '×';
							moves++;
							break;
						} else {
							System.out.println("そのマスは既に埋まっています。再度入力してください");
						}
					} else {
						System.out.println("行・列は0～2で入力して下さい");
					}
				}
				
			} else {
				
				System.out.println("CPUの番です");
				
				if(cpuLevel == 1) {
					cpuRandomMove(board);
					
				} else {
					cpuHardMove(board);
				}
				
				moves++;
			}
			
			char winner = checkWinner(board);
			if(winner == '×') {
				System.out.println("あなたの勝ちです");
				break;
			}else if(winner == '〇') {
				System.out.println("CPUの勝ちです");
				
				break;
			}
			
			if(moves == 9 && winner == ' ') {
				System.out.println("引き分けです");
				break;
			}
			
			playerTurn = !playerTurn;
			
		}
	
	scanner.close();

	}
	
	public static char checkWinner(char[][] board) {
		
		for (int i = 0; i < 3; i++) {
			if(board[i][0] != ' ' &&
			   board[i][0] == board[i][1] &&
			   board[i][1] == board[i][2]) {
				return board[i][0];
			}
		}
		
		for (int j = 0; j < 3; j++) {
			if(board[0][j] != ' ' &&
			   board[0][j] == board[1][j] &&
			   board[1][j] == board[2][j]) {
				return board[0][j];
			}
		}
		
		if(board[0][0] != ' ' &&
		   board[0][0] == board[1][1] &&
		   board[1][1] == board[2][2]) {
			return board[0][0];
		}
		
		if(board[0][2] != ' ' &&
		   board[0][2] == board[1][1] &&
		   board[1][1] == board[2][0]) {
			return board[0][2];
		}
		
		return ' ';
	}
	
	public static void printBoard(char[][] board) {
		
		for(int i = 0; i < 3; i++) {
			
			System.out.println(" " + board[i][0] + " | "
							       + board[i][1] + " | "
							       + board[i][2]);
			
			if(i < 2) {
				System.out.println("-----------");
				
			}
		}
		
	}
	
	public static void cpuRandomMove(char[][] board) {
		Random random = new Random();
		int row, col;
		
		while(true) {
			row = random.nextInt(3);
			col = random.nextInt(3);
			
			if(board[row][col] == ' ') {
				board[row][col] = '〇';
				System.out.println("CPUが(" + row + "," + col + ")に置きました");
				break;
			}
		}
	}
	
	public static void cpuHardMove(char[][] board) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(board[i][j] == ' ') {
					board[i][j] = '〇';
					
					if(checkWinner(board) == '〇') {
						System.out.println("CPUが(" + i + "," + j +")に置きました");
						return;
					}
					
					board[i][j] = ' ';
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				
				if(board[i][j] == ' '){
					board[i][j] = '×';
					
					if(checkWinner(board) == '×') {
						board[i][j] = '〇';
						System.out.println("CPUが(" + i + "," + j +")に置きました");
						return;
					}

				board[i][j] = ' ';
				}
				
			}
		}
		cpuRandomMove(board);
	}

}
