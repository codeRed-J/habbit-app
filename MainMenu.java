import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class MainMenu extends Menu {
	
	private String menuName;
	// menu with menu items objects
	private ArrayList<MenuItem> menu;
	
	// Constructor will read menu from file and create it in ArrayList<MenuItem>
	MainMenu(String fileName, String menuName){
		
		// initialize Arrya List which will hold Menu Items
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null ){
				menuItems.add(new MenuItem(line));
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("Error - Cannot read from file " + fileName);
		}
		this.menu = menuItems;
		this.menuName = menuName;
	}
	
	public void displayMenu(){
		//Display menu
		System.out.println("--------------");
		System.out.printf("%s%n", menuName);
		System.out.println("--------------");
		for(int i = 0; i < menu.size(); i++){
			MenuItem item = menu.get(i);
			System.out.printf("%d. %s %n", i + 1, item.getName());
		}
		System.out.printf("%d. %s %n", menu.size() + 1, "Exit");
		System.out.println("--------------");
	}
		
	// return size of menu variable
	public int menuSize(){
		return menu.size();
	}
	
	// return MenuItem object from menu variable
	public MenuItem getItem(int choice) throws IndexOutOfBoundsException{
		return menu.get(choice-1);
	}
}