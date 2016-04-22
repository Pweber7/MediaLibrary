package medialibrary;

import java.util.List;
import java.util.ArrayList;

public class MLSystem {
	
	DatabaseSupport ds = new DatabaseSupport();
	
	public List<Video> listWatchlist()
	{
		return ds.getWatchlist();
	}
	
	public List<Song> listPlaylist()
	{
		return ds.getPlaylist();
	}
	
	public List<Video> listVideoLibrary()
	{
		return ds.listVideoLibrary();
	}
	
	public List<Song> listMusicLibrary()
	{
		return ds.listMusicLibrary();
	}
	
	public List<Video> searchWatchlistTitle(String title)
	{
		return ds.searchWatchlistTitle(title);
	}
	
	public List<Video> searchVideoLibraryTitle(String title)
	{
		return ds.searchVideoLibraryTitle(title);
	}
	
	public List<Video> searchWatchlistRating(String rating)
	{
		return ds.searchWatchlistRating(rating);
	}
	
	public List<Video> searchVideoLibraryRating(String rating)
	{
		return ds.searchVideoLibraryRating(rating);
	}
	
	public List<Video> searchWatchlistGenre(String genre)
	{
		return ds.searchWatchlistGenre(genre);
	}
	
	public List<Video> searchWatchlistRuntime(int runtime)
	{
		return ds.searchWatchlistRuntime(runtime);
	}
	
	public List<Video> searchWatchlistTimeRemaining(int timeRemaining)
	{
		return ds.searchWatchlistTimeRemaining(timeRemaining);
	}
	
	public boolean addToPlaylist(String name)
	{
		return ds.addToPlaylist(name);
	} 
	
	public boolean addToWatchlist(String title)
	{
		return ds.addToWatchlist(title);
	}
	
	public boolean removeFromWatchlist(String title)
	{
		return ds.removeFromWatchlist(title);
	}
	
	public Video getInformationVideo(String title)
	{
		return ds.getVideo(title);
	}
	
	public Song getInformationSong(String name)
	{
		return ds.getSong(name);
	}
	
	public List<Video> searchVideoLibraryGenre(String genre){
		return ds.searchVideoLibraryGenre(genre);
	}

	public boolean removeFromPlaylist(String name)
	{
		Song s = ds.getSong(name);
		if(s != null && s.isOnPlaylist())
		{
			s.removeFromPlaylist();
			return ds.putSong(s);
		}
		return false;
	}
	
	public boolean editTimeVideoWatched(String title, int minutes)
	{
		Movie m = (Movie) ds.getVideo(title);
		if(m != null && m.isOnWatchlist())
		{
			m.editTimeWatched(minutes);
			//return ds.putMovie(m);
		}
		
		return false;
	}
	
	public List<Song> searchSongLibraryArtist(String artist)
	{
		return ds.searchSongLibraryArtist(artist);
	}
}
