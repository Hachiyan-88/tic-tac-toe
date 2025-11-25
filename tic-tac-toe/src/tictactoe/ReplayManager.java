package tictactoe;

import java.util.Scanner;

public class ReplayManager {
	
	private boolean playAgain = true;
	
	
	
	public boolean shouldPlayAgain() {
		return playAgain;
	}
	
	public void askPlayAgain(Scanner scanner) {
		
		String input = "";
		
		while(!input.equals("y") && !input.equals("n")) {
			System.out.println("もう一度遊びますか？(y/n):");
			
			input = scanner.nextLine().trim().toLowerCase();

			
			if(input.equals("y")) {
				playAgain = true;
				
			} else if(input.equals("n")) {
				playAgain = false;
				
			} else {
				System.out.println("再度yかnを入力してください");
			}
			
		}
		
	}

}
