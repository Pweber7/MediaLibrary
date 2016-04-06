package medialibrary;

import java.util.List;

public class SystemController {
	
	public List<Video> listWatchlist(){
		return MLSystem.listWatchlist();
	}
	
	public boolean removeFromWatchlist(String title){
		return MLSystem.removeFromWatchlist(title);
	}
	
	public List<Video> listVideoLibrary(){
		return MLSystem.listVideoLibrary;
	}
	
	public
}
