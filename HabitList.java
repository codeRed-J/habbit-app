public class HabitList{

	private ArrayList<Habit> habitList
	
	HabitList(String fileName, String menuName){
		
		// initialize Arrya List which will hold Menu Items
		ArrayList<Habit> habitList = new ArrayList<Habit>();
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null ){
				habitList.add(new Habit(line));
			}
			br.close();
		}
		catch(IOException e){
			System.out.println("Error - Cannot read from file " + fileName);
		}
		this.menu = habitList;
		this.menuName = menuName;
	}
	
	
}

//How to save object in csv and then read it from csv
// List of names and list of Objects?