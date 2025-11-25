package tictactoe;

import java.util.Scanner;

public class InputUtil {
	
	public static int readInt(Scanner scanner, String prompt) {
		while(true) {
			
			System.out.println(prompt);
			
			String line = scanner.nextLine();
			
			try {
				return Integer.parseInt(line);
				
			} catch (NumberFormatException e) {
				
				System.out.println("数字を入力してください");
			}
		}
	}

}
