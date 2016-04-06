package medialibrary;

import java.util.List;

public class SystemController {

	MLSystem mls = new MLSystem();
	
	public List<Video> listWatchlist(){
		return mls.listWatchlist();
	}
}
