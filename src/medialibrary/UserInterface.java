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
					success = sc.addToWatchlist(action);
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					success = sc.addToPlaylist(action);
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
					success = sc.removeFromWatchlist(action);
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
				System.out.println("Would you like to list a list of Videos or Songs");
				action = reader.nextLine();
				
				if(action.toUpperCase().equals("VIDEOS"))
				{
					System.out.println("Would you like to list the Video Library or your Watchlist>");
					action = reader.nextLine();
					if(action.toUpperCase().equals("VIDEO LIBRARY"))
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
					if(action.toUpperCase().equals("MUSIC LIBRARY"))
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
			else if(action.toUpperCase().equals("GET"))
			{
				System.out.println("Would you like to info for a Video or Song ");
				action = reader.nextLine();
				if(action.toUpperCase().equals("VIDEO"))
				{
					System.out.println("Please type the title of the Video ");
					action = reader.nextLine();
					Video v = sc.getInformationVideo(action);
					System.out.println(v.getInfo());
				}
				else
				{
					System.out.println("Please type the name of the Song ");
					action = reader.nextLine();
					Song s = sc.getInformationSong(action);
					System.out.println(s.getInfo());
				}
			}
			if(success)
			{
				System.out.println("Successful");
			}
		}
		reader.close();
	}
}
