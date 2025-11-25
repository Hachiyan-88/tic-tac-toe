package tictactoe;

import java.util.Scanner;

public class TurnManager {
	
	private boolean playerFirst;
	
	public TurnManager(Scanner scanner) {
		selectTurn(scanner);
	}
	
	private void selectTurn(Scanner scanner) {
		
		int choice = 0;
		
		while(choice != 1 && choice != 2) {
			
			choice = InputUtil.readInt(scanner, "先攻か後攻を選択してください(1先攻)(2後攻)");
			
			if(choice != 1 && choice != 2) {
				System.out.println("無効な選択肢です１または２を入力してください");
			}
		}
		
		playerFirst = (choice ==1);
	}
	
	public boolean isPlayerTurn(int turnCount) {
		return (turnCount % 2 == 0) == playerFirst;
	}

}
