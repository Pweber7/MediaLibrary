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
			vList.clear();
			sList.clear();
			System.out.println("What would you like to do? [a]dd, [r]emove, [l]ist, [g]et info, [search], [set], or [q]uit");
			action = reader.nextLine();
			action = action.toUpperCase();
			if(action.charAt(0) == 'Q')
			{
				break;
			}
			if(action.charAt(0) == 'A')
			{
				System.out.println("Would you like to add to your [V]ideo or Audio list? ");
				action = reader.nextLine();
				action = action.toUpperCase();
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
				System.out.println("Would you like to remove a [V]ideo or Song?");
				action = reader.nextLine();
				action = action.toUpperCase();
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
					success = sc.removeFromPlaylist(action);
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
				System.out.println("Would you like to list a list of [V]ideos or Songs? ");
				action = reader.nextLine();
				action = action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Would you like to list the [V]ideo Library or your Watchlist>");
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
					if(vList.isEmpty())
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
					System.out.println("Would you like to list the [M]usic Library or your Playlist? ");
					action = reader.nextLine();
					action = action.toUpperCase();
					if(action.charAt(0) == 'M')
					{
						sList = (ArrayList<Song>) sc.listMusicLibrary();
					}
					else
					{
						sList = (ArrayList<Song>) sc.listPlaylist();
					}
					if(sList.isEmpty())
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
				System.out.println("Would you like to get info for a [V]ideo or Song? ");
				action = reader.nextLine();
				action = action.toUpperCase();
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
			else if(action.equals("SEARCH"))
			{
				System.out.println("Would you like to search for a [V]ideo or Song? ");
				action = reader.nextLine();
				action = action.toUpperCase();
				if(action.charAt(0) == 'V')
				{
					System.out.println("Would you like to search the [W]atchlist or Video Library? ");
					action = reader.nextLine();
					action = action.toUpperCase(); 
					if(action.charAt(0) == 'W')
					{
						System.out.println("Would you like to search by [Title], [G]enre, [Rating], [Time Remaining], or [Runtime]? ");
						action = reader.nextLine();
						action = action.toUpperCase();
						if(action.equals("TITLE"))
						{
							System.out.println("Please type the title of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchWatchlistTitle(action);								
						}
						else if(action.charAt(0) == 'G')
						{
							System.out.println("Please type the genre of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchWatchlistGenre(action);
						}
						else if(action.equals("TIME REMAINING"))
						{
							System.out.println("Please type the Time Remaining in minutes of the Video ");
							int length = reader.nextInt();
							reader.nextLine();
							vList = (ArrayList<Video>) sc.searchWatchlistTimeRemaining(length);
						}
						else if(action.equals("RATING"))
						{
							System.out.println("Please type the Rating of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchWatchlistRating(action);
						}
						else if(action.equals("RUNTIME"))
						{
							System.out.println("Please type the Runtime in minutes of the Video ");
							int length = reader.nextInt();
							reader.nextLine();
							vList = (ArrayList<Video>) sc.searchWatchlistRuntime(length);
						}
					}
					else
					{
						System.out.println("Would you like to search by [T]itle, [G]enre, [R]ating? ");
						action = reader.nextLine();
						action = action.toUpperCase();
						if(action.charAt(0) == 'T')
						{
							System.out.println("Please type the title of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchVideoLibraryTitle(action);
						}
						else if(action.charAt(0) == 'G')
						{
							System.out.println("Please type the genre of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchVideoLibraryGenre(action);
						}
						else if(action.charAt(0) == 'R')
						{
							System.out.println("Please type the Rating of the Video ");
							action = reader.nextLine();
							vList = (ArrayList<Video>) sc.searchVideoLibraryRating(action);
						}						
					}
					if(vList.isEmpty())
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
					System.out.println("Would you like to search the [P]laylist or Song Library? ");
					action = reader.nextLine();
					action = action.toUpperCase();
					if(action.charAt(0) == 'P')
					{
						System.out.println("Would you like to search the playlist by [T]itle or [A]rtist? ");
						action = reader.nextLine();
						action = action.toUpperCase();
						if(action.charAt(0) == 'T'){
							System.out.println("Please type the title of the Song. ");
							action = reader.nextLine();
							sList = (ArrayList<Song>) sc.searchPlaylistTitle(action);		
						}
						else if(action.charAt(0) == 'A'){
							System.out.println("Please type the artist you are looking for. ");
							action = reader.nextLine();
							sList = (ArrayList<Song>) sc.searchPlaylistArtist(action);	
						}
					}
					else
					{
						System.out.println("Would you like to search for a song by [N]ame, [A]rtist, or Genre? ");
						action = reader.nextLine();
						action = action.toUpperCase();
						if(action.charAt(0) == 'N')
						{
							System.out.println("What Song would you like to search for? ");
							sList = (ArrayList<Song>) sc.searchSongLibraryTitle(action);
						}
						else if(action.charAt(0) == 'A')
						{
							System.out.println("What Artist would you like to search for? ");
							action = reader.nextLine();
							sList = (ArrayList<Song>) sc.searchSongLibraryArtist(action);							
						}
						else
						{
							System.out.println("What Genre would you like to search for? ");
							sList = (ArrayList<Song>) sc.searchSongLibraryGenre(action);
						}
					}
					if(sList.isEmpty())
					{
						System.out.println("There were no songs that matched.");
					}
					else
					{
						for(Song s: sList)
						{
							System.out.println(s.getTitle());
						}
					}
					
					
				}
			}
			else if(action.equals("SET"))
			{
				System.out.println("What would you like to edit a [M]ovie or TV show? ");
				action = reader.nextLine();
				action = action.toUpperCase();
				if(action.charAt(0) == 'M')
				{
					System.out.println("What movie would you like to edit? ");						
					String title = reader.nextLine();
					System.out.println("What would you like to edit about "+ title + " ? [time watched] or [fully watched]");
					action = reader.nextLine();
					action = action.toUpperCase();
					if(action.equals("TIME WATCHED"))
					{
						System.out.println("How many minutes did you watch? ");
						int minutes = reader.nextInt();
						reader.nextLine();
						success = sc.setTimeWatched(title, minutes);
					}
					if(action.equals("FULLY WATCHED")){
						success = sc.editVideoToWatched(title);
						reader.nextLine();
					}
				}
				else
				{
					System.out.println("What Tv Show would you like to edit? ");						
					String title = reader.nextLine();
					System.out.println("What would you like to edit about "+ title + " ? [fully watched], [s]easons, or episodes");
					action = reader.nextLine();
					action = action.toUpperCase();
					if(action.equals("FULLY WATCHED")){
						success = sc.editVideoToWatched(title);
						reader.nextLine();
					}
					else if(action.charAt(0) == 'S')
					{
						System.out.println("How many seasons did you watch? ");
						int seasons = reader.nextInt();
						reader.nextLine();
						success = sc.editNumberSeasonsWatched(title, seasons);
					}
					else
					{
						System.out.println("How many episodes did you watch? ");
						int episodes = reader.nextInt();
						reader.nextLine();
						success = sc.editNumberEpisodesWatched(title, episodes);
					}
				}
			}
		}
		reader.close();
	}
}