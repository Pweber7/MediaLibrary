package medialibrary;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSupport {
	
	private ArrayList<Video> dummyVideoLibrary = new ArrayList<>();
	private ArrayList<Song> dummySongLibrary = new ArrayList<>();
	private ArrayList<Video> dummyWatchlist = new ArrayList<>();
	private ArrayList<Song> dummyPlaylist = new ArrayList<>();
	private Movie m1 = new Movie("Movie1");
	private Movie m2 = new Movie("Movie2");
	private TVShow t1 = new TVShow("TVShow1");
	private TVShow t2 = new TVShow("TVShow2");
	private Song s1 = new Song("Song1", "", "");
	private Song s2 = new Song("Song2", "", "");
	private Song s3 = new Song("Song3", "", "");
	
	private void dummyInit(){
		dummyVideoLibrary.add(m1);
		dummyVideoLibrary.add(m2);
		dummyVideoLibrary.add(t1);
		dummyVideoLibrary.add(t2);
		dummySongLibrary.add(s1);
		dummySongLibrary.add(s2);
		dummySongLibrary.add(s3);
		dummyWatchlist.add(m1);
		dummyWatchlist.add(t2);
		dummyPlaylist.add(s2);
		dummyPlaylist.add(s1);
	}
	
	private Video dummyFindVideo(String title, ArrayList<Video> list){
		for(Video v : list){
			if(v.getTitle().equals(title)){
				return v;
			}
		}
		return null;
	}
	
	private Song dummyFindSong(String title, ArrayList<Song> list){
		for(Song s : list){
			if(s.getTitle().equals(title)){
				return s;
			}
		}
		return null;
	}
	
	public DatabaseSupport(){
		dummyInit();
	}

	public List<Video> getWatchlist(){
		return dummyWatchlist;
	}
	
	public List<Song> getPlaylist(){
		return dummyPlaylist;
	}
	
	public boolean removeFromWatchlist(String title){
		Video v = dummyFindVideo(title, dummyWatchlist);
		return dummyWatchlist.remove(v);
	}
	
	public boolean addToWatchlist(String title){
		Video v = dummyFindVideo(title, dummyVideoLibrary);
		return dummyWatchlist.add(v);
	}
	
	public boolean addToPlaylist(String title){
		Song s = dummyFindSong(title, dummySongLibrary);
		return dummyPlaylist.add(s);
	}
	
	public List<Video> listVideoLibrary(){
		return dummyVideoLibrary;
	}
	
	public List<Song> listMusicLibrary(){
		return dummySongLibrary;
	}
	
	public Video getVideo(String title){
		return dummyFindVideo(title, dummyVideoLibrary);
	}
	
	public Song getSong(String title){
		return dummyFindSong(title, dummySongLibrary);
	}
}
