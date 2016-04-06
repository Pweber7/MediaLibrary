package medialibrary;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args)
	{
		SystemController sc = new SystemController();
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
				System.out.println("Would you like to add to your Video or Audio List? ");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO"))
				{
					System.out.println("Please type the title of the video ");
					action = reader.nextLine();
					sc.addToWatchlist(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					sc.addToPlaylist(action);
				}
			}
			else if(action.toUpperCase().equals("REMOVE"))
			{
				System.out.println("Would you like to remove a Video or Song?");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO"))
				{
					System.out.println("Please type the title of the Video ");
					action = reader.nextLine();
					sc.removeFromWatchlist(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					//removeFromPlaylist(action);
				}
			}
			else if(action.toUpperCase().equals("LIST"))
			{
				System.out.println("Would you like to list the Video Library, Music library, Watchlist, or Playlist");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO LIBRARY"))
				{
					sc.listVideoLibrary();
				}
				else if(action.toUpperCase().equals("MUSIC LIBRARY"))
				{
					sc.listMusicLibrary();
				}
				else if(action.toUpperCase().equals("WATCHLIST"))
				{
					sc.listWatchlist();
				}
				else
				{
					sc.getPlaylist();
				}
			}
			else if(action.toUpperCase().equals("GET"))
			{
				System.out.println("Would you like to info for a Video or Song ");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO"))
				{
					System.out.println("Please type the title of the Video ");
					action = reader.nextLine();
					sc.getInformationVideo(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					sc.getInformationSong(action);
				}
			}
		}
		reader.close();
	}
}
