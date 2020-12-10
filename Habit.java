 import java.util.Scanner;
 import java.time.LocalDate;
 import java.io.FileWriter;
 import java.io.IOException;

public class Habit{
	
	// Habit name
	private String name;
	// Data of habit creation
	private LocalDate theDate;
	// Days you do some habit in a row
	private int success;
	// Max days in a row
	private int record;
	
	
	Habit(String name, boolean done) throws IOException {
		this.name = name;
		this.theDate = LocalDate.now();
		if(done){
			this.success = 1;
			this.record = 1;
		}
		else{
			this.success = 0;
			this.record = 0;
		} 
	
				
		FileWriter fr = new FileWriter("habits.txt", true);
		// Create string with habit details
		String habitDetails = name + " " + success + " " + record + " " + theDate;
		// Write to txt file string with details
		fr.write(habitDetails);
		fr.append("\n");
		fr.close();
	}	
	
	public void addDay(LocalDate date){
		if(date.isAfter(theDate)){
			success++;
			theDate = date;
			if(record < success){
			record = success;
			}
		}
		else{
			theDate = date;
			success = 1;
		}
		System.out.println("Data successfuly added!");
		FileWriter fr = new FileWriter("habits.txt", true);
		// Create string with habit details
		String habitDetails = name + " " + success + " " + record + " " + theDate;
		// Write to txt file string with details
		fr.write(habitDetails);
		fr.append("\n");
		fr.close();
	}
	
	//Map<A,List<B>> map = new HashMap<A,List<B>>();
	
	// public String getHabbitName(){
		//return name;
	//}
	
	public void show(){
		System.out.printf("You did %s %d days in a row", name, success);
	}
	
	public static void habitDialogue(){
		System.out.println("Hi there!");
		System.out.println("You would like to create new habit?! Great!");
		System.out.print("Enter new habbit name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.printf("Your new habit name is %s", name);
		
	}
	
}