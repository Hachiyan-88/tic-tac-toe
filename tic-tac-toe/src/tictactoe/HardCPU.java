package tictactoe;

public class HardCPU extends CPU {

	public HardCPU(Board board) {
        super(board);
    }

    public void makeMove() {
    		
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
}
