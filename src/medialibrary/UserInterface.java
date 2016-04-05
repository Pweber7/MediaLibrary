package medialibrary;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		String action = "";
		while(true)
		{
			System.out.println("What would you like to do? ");
			action = reader.nextLine();
			if(action.toUpperCase().equals("QUIT"))
			{
				break;
			}
			if(action.toUpperCase().equals("ADD"))
			{
				System.out.println("Would you like to add to your Video or Audio List");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO"))
				{
					System.out.println("Please type the title of the video ");
					action = reader.nextLine();
					addVideoToWatchList()
				}
			}
		}
		reader.close();
	}
}
