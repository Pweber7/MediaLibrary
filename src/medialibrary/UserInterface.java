package medialibrary;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		String action = "";
		while(!action.toUpperCase().equals("QUIT"))
		{
			System.out.println("What would you like to do? ");
			action = reader.nextLine();
		}
		reader.close();
	}
}
