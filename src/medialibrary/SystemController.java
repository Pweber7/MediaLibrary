package medialibrary;

import java.util.List;

public class SystemController {

	MLSystem mls = new MLSystem();
	public List<Video> listWatchlist(){
		return mls.listWatchlist();
	}
	
	public boolean removeFromWatchlist(String title){
		return MLSystem.removeFromWatchlist(title);
	}
	
	public List<Video> listVideoLibrary(){
		return MLSystem.listVideoLibrary;
	}
	
	public
}
