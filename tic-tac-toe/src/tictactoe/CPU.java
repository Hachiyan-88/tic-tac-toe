package tictactoe;

import java.util.Random;

public abstract class CPU {
	
	protected Board board;
	protected Random random;
	
	public CPU(Board board) {
		
		this.board = board;
		this.random = new Random();
	}
	
	public abstract void makeMove();
	
	public void RandomMove() {
		int row, col;
		
		while(true) {
			
			row = random.nextInt(3);
			col = random.nextInt(3);
			
			if(board.getCell(row, col) == ' ') {
				board.setCell(row, col, '〇');
				System.out.println("CPUが（" + row +","+ col + "）に置きました");
				break;
			}
		}
	}
}
	
/*	
	//弱いCPU
	public void RandomMove() {
		int row, col;
		
		while(true) {
			
			row = random.nextInt(3);
			col = random.nextInt(3);
			
			if(board.getCell(row, col) == ' ') {
				board.setCell(row, col, '〇');
				System.out.println("CPUが（" + row +","+ col + "）に置きました");
				break;
			}
		}
	}
	
	//強いCPU
	public void HardMove() {
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				
				if(board.getCell(row, col) == ' ') {
					board.setCell(row, col, '〇');
					if(board.checkWinner() == '〇') {
						System.out.println("CPUが（" + row + "," + col + "）に置きました");
						return;
					} else {
						board.setCell(row, col, ' ');
				  }
				  
				board.setCell(row, col, ' ');
				}
			}
		}
		
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				
				if(board.getCell(row, col) == ' ') {
					board.setCell(row, col, '×');
					
					if(board.checkWinner() == '×') {
						board.setCell(row, col, '〇');
						System.out.println("CPUが（" + row + "," + col + "）に置きました（ブロック）");
						return;
					}
					board.setCell(row, col, ' ');
				}
			}
		}
		
		RandomMove();
	}
*/


