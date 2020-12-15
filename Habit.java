 import java.util.Scanner;
 import java.time.LocalDate;
 import java.io.FileWriter;
 import java.io.IOException;

// rename name
// rename file name
public class Habit{
	// Habit name
	private String name;
	// Data of habit creation
	private final LocalDate startDate;
	// Date when done last time
	private LocalDate lastDate;
	// Days you do some habit in a row
	private int daysDo;
	// Max days in a row
	private int record;
	// Total days done
	private int totalDays;
	// Create name of file where will be stored information about habit
	private String file;
	// Save habit details in String
	private String habitDetails;
	
	// Create a habit object. 
	// If parameter done is true, it means that you done it in a day of creation
	// Otherwise you just create a habit	
	public Habit(String name, boolean done) throws IOException {
		this.name = name;
		this.startDate = LocalDate.now();
		if(done){
			// If habit done at the moment when it was created
			this.lastDate = this.startDate;
			this.daysDo = 1;
			this.record = 1;
			this.totalDays = 1;
		}
		else{
			// If only habit was created, lastDate variable will initialize 
			// to date which is two days before creation date.
			// It is done to compare it in method addDay()
			this.lastDate = LocalDate.now().minusDays(2);
			this.daysDo = 0;
			this.record = 0;
			this.totalDays = 0;
		} 
		this.file = name + ".csv";
		
				
		FileWriter fr = new FileWriter(file);
		// Create string with titles
		String habitTitle = "Name\tCreated\tLast done\tRecord\tStreak";
		// Write to csv file string titles
		fr.write("Name,Date of Creation,Last Done,Record,Streak");
		fr.write(System.lineSeparator());
		// Initialize string with habit details
		detailsToString();
		// Write to csv file string with details
		fr.write(habitDetails);
		fr.write(System.lineSeparator());
		fr.close();
		
		// Write name of the habit to txt file. File will hold all habits)
		FileWriter fr = new FileWriter("habitList.txt", true)
		fr.write(name)
		fr.write(System.lineSeparator());
	}	
	
	// Change habit details when add a day when you did a habit.
	public void addDay(LocalDate date) throws IOException {
		// Check if habit already done today
		if(lastDate.equals(date)){
			System.out.println("You already did it today!");
		}
		else {//lastDate.equals(date)){
			totalDays++;
			// Checks if you go day by day or start after some break
			if((date.minusDays(1)).equals(lastDate)){
				daysDo++;
				lastDate = date;
			}
			else{
				lastDate = date;
				daysDo = 1;
			}
			// Compare streak to record
			if(record < daysDo){
				record = daysDo;
			}
		}
		
		FileWriter fr = new FileWriter(file, true);
		// Initialize string with habit details
		detailsToString();
		// Write to csv file string with details
		fr.write(habitDetails);
		fr.write(System.lineSeparator());
		fr.close();
	}
	
	// Gather all field information in String with coma separated way
	private void detailsToString(){
		this.habitDetails = name + "," + startDate + "," + lastDate + "," + record + "," + daysDo + "," + totalDays;
	}
	
	
}
	
	//Map<A,List<B>> map = new HashMap<A,List<B>>();
	
	// public String getHabbitName(){
		//return name;
	//}
	
/*	public void show(){
		System.out.printf("You did %s %d days in a row", name, daysDo);
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
*/