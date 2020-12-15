import java.util.Scanner;

public class Keyboard{
	
	private Scanner in;
	
	Keyboard(){
		in = new Scanner(System.in);
	}
	// Input integer with range from 1 to parameter value;
	public int readInteger(int range){
		int choice = 0;
		String strInput;
		boolean valid = false;
		
		// Keep looking until valid input
		while(valid == false){
			// Prompt the user
			System.out.print("Select option: ");
			// Grab input from keyboard
			strInput = in.nextLine();
			// Try to convert String to int
			try{
				choice = Integer.parseInt(strInput);
				// check if input is between the range from 1 to range value
				if(choice >= 1 && choice <= range+1)
					valid = true;
				else
					System.out.println("Input is not in menu range.");
			}
			catch(NumberFormatException e){
				System.out.println("Error - enter an integer value.");
			}
		}
		// return choice to caller
		return choice;
	}
}