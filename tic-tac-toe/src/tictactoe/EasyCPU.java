package tictactoe;

public class EasyCPU extends CPU {

	
	public EasyCPU(Board board) {
		super(board);
	}
	
	public void makeMove() {
	int row ,col;
		
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
