import java.io.IOException;
import java.time.LocalDate;

public class HabitsTest{
	public static void main(String[] args){
				
		try{
			Habit habit = new Habit("programming", true);
			habit.addDay(LocalDate.now());
			habit.addDay(LocalDate.of(2020, 12, 13));
			habit.addDay(LocalDate.of(2020, 12, 14));
			habit.addDay(LocalDate.of(2020, 12, 16));
			habit.addDay(LocalDate.of(2020, 12, 17));
			habit.addDay(LocalDate.of(2020, 12, 18));
			habit.addDay(LocalDate.of(2020, 12, 19));
		}
		catch(IOException e){
			System.out.println("Can't open file");
		}
	}
}