package medialibrary;

import java.util.List;

public class SystemController {
	
	public List<Video> listWatchlist(){
		return MLSystem.listWatchlist();
	}
}
