package tictactoe;

import java.util.Scanner;

public class Player {
	
	Scanner scanner = new Scanner(System.in);
	
	private Board board;
	
	public Player(Scanner scanner, Board board) {
		this.scanner = scanner;
		this.board = board;
	}
	
	public void makeMove() {
		
		int row,col;
		
		while(true) {
			
			System.out.println("行（0～2）を入力してください");
			row = scanner.nextInt();
			
			System.out.println("列（0～2）を入力してください");
			col = scanner.nextInt();
			
			if(row < 0 || row > 2 || col < 0 || col > 2) {
				System.out.println("再度入力してください");
				continue;
			}
			
			if(board.getCell(row, col) == ' ') {
				board.setCell(row, col, '×');
				System.out.println("あなたは" + row + "," +col + "に置きました");
				break;
			} else {
				System.out.println("そのマスは既に埋まっています。別の場所にしてください");
			}
		}
		
	}
	

}
