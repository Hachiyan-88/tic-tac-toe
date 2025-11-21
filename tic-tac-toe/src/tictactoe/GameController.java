package tictactoe;

public class GameController {
	
	
	public static void playerTurn(Board board, Player player) {
		
		
		System.out.println("あなたのターンです");
		player.makeMove();
		board.print();
	}
	
	public static void cpuTurn(Board board, CPU cpu, int cpuLevel) {
		
		System.out.println("CPUのターンです");
		cpu.makeMove();;
		board.print();
	}
	
	public static boolean checkGameEnd(Board board, char symbol, String message) {
		if(board.checkWinner() == symbol) {
			System.out.println(message);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isBoardFull(Board board) {
		
		char[][] b = board.getBoard();
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(b[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

}
