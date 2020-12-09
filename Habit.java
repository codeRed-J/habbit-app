 import java.util.Scanner;
 import java.time.LocalDate;
 import java.io.FileWriter;
 import java.io.IOException;

public class Habit{
	
	// Habbit name
	private String name;
	// Data of habbit creation
	private LocalDate theDate;
	// Days you do some habbit in a row
	private int success;
	// Max days in a row
	private int record;
	// Total days spent for habbit ( future futures )
   //private int total;
	
	
	Habbit(String name, boolean done) throws IOException {
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
		// Create string with habbit details
		String habbitDetails = name + " " + success + " " + record + " " + theDate;
		// Write to txt file string with details
		fr.write(habbitDetails);
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
		// Create string with habbit details
		String habbitDetails = name + " " + success + " " + record + " " + theDate;
		// Write to txt file string with details
		fr.write(habbitDetails);
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
	
	public static void habbitDialogue(){
		System.out.println("Hi there!");
		System.out.println("You would like to create new habbit?! Great!");
		System.out.print("Enter new habbit name: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.printf("Your new habbit name is %s", name);
		
	}
	
}