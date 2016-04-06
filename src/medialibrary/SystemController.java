package medialibrary;

import java.util.List;

public class SystemController {

	MLSystem mls = new MLSystem();
	
	public List<Video> listWatchlist(){
		return mls.listWatchlist();
	}
	
	public boolean removeFromWatchlist(String title){
		return mls.removeFromWatchlist(title);
	}
	
	public List<Video> listVideoLibrary(){
		return mls.listVideoLibrary();
	}
	
	public Video getInformationVideo(String title){
		return mls.getInformationVideo(title);
	}
	
	public Song getInformationSong(String title){
		return mls.getInformationSong(title);
	}
	
	public boolean addToWatchlist(String title){
		return mls.addToWatchlist(title);
	}
	
	public List<Song> listMusicLibrary(){
		return mls.listMusicLibrary();
	}
	
	public List<Song> listPlaylist(){
		return mls.listPlaylist();
	}
	
	public boolean addToPlaylist(String title){
		return mls.addToPlaylist(title);
	}
}
