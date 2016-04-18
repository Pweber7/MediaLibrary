package medialibrary;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	public static void main(String[] args)
	{
		ArrayList<Video> vList = new ArrayList<>();
		ArrayList<Song> sList = new ArrayList<>();
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
				System.out.println("Would you like to list a list of Videos or Songs? ");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Would you like to list the Video Library or your Watchlist>");
					action = reader.nextLine();
					action.toUpperCase();
					if(action.charAt(0) == 'V')
					{
						vList = (ArrayList<Video>) sc.listVideoLibrary();
					}
					else
					{
						vList = (ArrayList<Video>) sc.listWatchlist();
					}
					if(vList == null)
					{
						System.out.println("There were no videos that matched.");
					}
					else
					{
						for(Video v : vList)
						{
							System.out.println(v.getTitle());
						}
					}
				
				}
				else
				{
					System.out.println("Would you like to list the Music Library or your Playlist? ");
					action = reader.nextLine();
					action.toUpperCase();
					if(action.charAt(0) == 'M')
					{
						sList = (ArrayList<Song>) sc.listMusicLibrary();
					}
					else
					{
						sList = (ArrayList<Song>) sc.listPlaylist();
					}
					if(sList == null)
					{
						System.out.println("There were no videos that matched.");
					}
					else
					{
						for(Song s : sList)
						{
							System.out.println(s.getTitle());
						}
					}
				}				
			}
			else if(action.charAt(0) == 'G')
			{
				System.out.println("Would you like to info for a Video or Song? ");
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
			else if(action.charAt(0) == ('S'))
			{
				System.out.println("Would you like to search for a Video or Song? ");
				action = reader.nextLine();
				action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Would you like to search the Watchlist or Video Library? ");
					action = reader.nextLine();
					action.toUpperCase(); 
					if(action.charAt(0) == 'W')
					{
						System.out.println("Would you like to search by Title, Genre, Rating, Time Remaining, or Runtime? ");
						action = reader.nextLine();
						action.toUpperCase();
						if(action.equals("Title"))
						{
							System.out.println("Please type the title of the Video ");
							action = reader.nextLine();
							//vList = sc.searchWatchlistTitle(action);								
						}
						else if(action.charAt(0) == 'G')
						{
							System.out.println("Please type the genre of the Video ");
							action = reader.nextLine();
							//vList = sc.searchWatchlistGenre(action);
						}
						else if(action.equals("Time Remaining"))
						{
							System.out.println("Please type the Time Remaining in minutes of the Video ");
							action = reader.nextLine();
							//vList = sc.searchWatchlistTimeRemaining(action);
						}
						else if(action.equals("Rating"))
						{
							System.out.println("Please type the Rating of the Video ");
							action = reader.nextLine();
							//vList = sc.searchWatchlistRating(action);
						}
						else if(action.equals("Runtime"))
						{
							System.out.println("Please type the Runtime in minutes of the Video ");
							action = reader.nextLine();
							//vList = sc.searchWatchlistRuntime(action);
						}
					}
					else
					{
						System.out.println("Would you like to search by Title, Genre, Rating, Time Remaining, or Runtime? ");
						action = reader.nextLine();
						action.toUpperCase();
						if(action.charAt(0) == 'T')
						{
							System.out.println("Please type the title of the Video ");
							action = reader.nextLine();
							//vList = sc.searchVLTitle(action);
						}
						else if(action.charAt(0) == 'G')
						{
							System.out.println("Please type the genre of the Video ");
							action = reader.nextLine();
							//vList = sc.searchVLGenre(action);
						}
						else if(action.equals("Rating"))
						{
							System.out.println("Please type the Rating of the Video ");
							action = reader.nextLine();
							//vList = sc.searchVLRating(action);
						}						
					}
					if(vList == null)
					{
						System.out.println("There were no videos that matched.");
					}
					else
					{
						for(Video v : vList)
						{
							System.out.println(v.getTitle());
						}
					}
				}
			}
		}
		reader.close();
	}
}