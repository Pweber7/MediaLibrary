package medialibrary;

public class Song {
	
	private String sTitle;
	private String sArtist;
	private String sGenre;
	private boolean onPlaylist;
	
	public Song(String title, String artist, String genre, boolean onPlaylist){
		sTitle = title;
		sArtist = artist;
		sGenre = genre;
		this.onPlaylist = onPlaylist;
	}
	
	public String getTitle(){
		return sTitle;
	}
	
	public String getInfo()
	{
		return("Name: " + sTitle + "\n" + "Artist: " + sArtist + "\n" + "Genre: " + sGenre);
	}
	
	public boolean isOnPlaylist()
	{
		return onPlaylist;
	}
	
	public String getArtist()
	{
		return sArtist;
	}
	
	public String getGenre()
	{
		return sGenre;
	}
	
	public boolean removeFromPlaylist()
	{
		onPlaylist = false;
		return true;
	}
}