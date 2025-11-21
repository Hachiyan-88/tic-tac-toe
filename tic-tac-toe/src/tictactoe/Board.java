package tictactoe;

public class Board {
	
	private char[][] board;
	
		
		public Board() {
			
			board = new char[3][3];
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';
				}
			}
		}
		
	public void print() {
		for(int i = 0; i <3; i++) {
			System.out.println(" " + board[i][0] + " | "
							       + board[i][1] + " | "
							       + board[i][2] );
			
			if(i < 2) {
				System.out.println("------------------");
			}
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public char getCell(int row, int col) {
		return board[row][col];
	}
	
	public void setCell(int row, int col, char value) {
		board[row][col] = value;
	}
	
	public char checkWinner() {
		
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != ' ' &&
				board[i][0] == board[i][1] &&
				board[i][1] == board[i][2]) {
				return board[i][0];
			}
		}
		
		for(int j = 0; j < 3; j++) {
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

}
