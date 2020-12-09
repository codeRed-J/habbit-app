import java.io.IOException;

public class HabitsTest{
	public static void main(String[] args){
		
		try{
			Habbit habbit = new Habbit("programming", true);
		}
		catch(IOException e){
			System.out.println("Can't open file");
		}
		
		habbit.addDay();
	}
}