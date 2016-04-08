package medialibrary;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	public static void main(String[] args)
	{
		ArrayList<Video> Vlist = new ArrayList<>();
		ArrayList<Song> Slist = new ArrayList<>();
		SystemController sc = new SystemController();
		Scanner reader = new Scanner(System.in);
		String action = "";
		boolean success = false;
		while(true)
		{
			System.out.println("What would you like to do? ");
			action = reader.nextLine();
			action.toUpperCase();
			if(action.charAt(0) == 'Q')
			{
				break;
			}
			if(action.charAt(0) == 'A')
			{
				System.out.println("Would you like to add to your Video or Audio list? ");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Please type the title of the video ");
					action = reader.nextLine();
					success = sc.addToWatchlist(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					success = sc.addToPlaylist(action);
				}
				if(success)
				{
					System.out.println("The add was successful.");
				}
				else
				{
					System.out.println("The add was unsuccessful.");
				}
				
			}
			else if(action.charAt(0) == 'R')
			{
				System.out.println("Would you like to remove a Video or Song?");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Please type the title of the Video ");
					action = reader.nextLine();
					success = sc.removeFromWatchlist(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					//success = removeFromPlaylist(action);
				}
				if(success)
				{
					System.out.println("The remove was successful.");
				}
				else
				{
					System.out.println("The remove was unsuccessful.");
				}
				
			}
			else if(action.charAt(0) == 'L')
			{
				System.out.println("Would you like to list a list of Videos or Songs");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Would you like to list the Video Library or your Watchlist>");
					action = reader.nextLine();
					action.toUpperCase();
					if(action.charAt(0) == 'V')
					{
						Vlist = (ArrayList<Video>) sc.listVideoLibrary();
					}
					else
					{
						Vlist = (ArrayList<Video>) sc.listWatchlist();
					}
					for(Video v : Vlist)
					{
						System.out.println(v.getTitle());
					}
				
				}
				else
				{
					System.out.println("Would you like to list the Music Library or your Playlist");
					action = reader.nextLine();
					action.toUpperCase();
					if(action.charAt(0) == 'M')
					{
						Slist = (ArrayList<Song>) sc.listMusicLibrary();
					}
					else
					{
						Slist = (ArrayList<Song>) sc.listPlaylist();
					}
					for(Song s : Slist)
					{
						System.out.println(s.getTitle());
					}
				}				
			}
			else if(action.charAt(0) == 'G')
			{
				System.out.println("Would you like to info for a Video or Song ");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Please type the title of the Video ");
					action = reader.nextLine();
					Video v = sc.getInformationVideo(action);
					if(v == null)
					{
						System.out.println("That Video does not exist.");
					}
					else
					{
						System.out.println(v.getInfo());
					}
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					Song s = sc.getInformationSong(action);
					if(s == null)
					{
						System.out.println("That song does not exist.");
					}
					else
					{
						System.out.println(s.getInfo());
					}
				}
			}
		}
		reader.close();
	}
}