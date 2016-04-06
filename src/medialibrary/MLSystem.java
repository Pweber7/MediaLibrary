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
}
