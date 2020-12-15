import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Start{
	
	public static void main(String[] args){
			
		// Read menu.txt file and create menu;
		MainMenu menuObj = new MainMenu("menu.txt", "Menu");
		
		// Display menu
		menuObj.displayMenu();
				
		// Create a Keyboard object
		Keyboard kb = new Keyboard();		
		
		// Select Menu Item		
		int choice = kb.readInteger(menuObj.menuSize());
		int exit = menuObj.menuSize() + 1;
		
		while(choice != exit){
			MenuItem item = menuObj.getItem(choice);
			
			if(choice == 1){
				createDialogue();
			}
			else if(choice == 2){
				File tmpDir = new File("habitList.txt");
				boolean exists = tmpDir.exists();
				if(exists){
					HabitList habitList = new HabitList("habitList.txt", "Habits"));
					habitList.selectHabit();
				}
				else{
					System.out.println("Your habit list is empty, please create habit first!");
					
				}
			}
			menuObj.displayMenu();
			choice = kb.readInteger(menuObj.menuSize());
			
		}
		
		System.out.println("See you soon!");
	}
}