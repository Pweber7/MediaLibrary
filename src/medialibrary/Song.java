package medialibrary;

public class Song {
	
	private String sTitle;
	private String sArtist;
	private String sGenre;
	
	public Song(String title, String artist, String genre){
		sTitle = title;
		sArtist = artist;
		sGenre = genre;
	}
	
	public String getTitle(){
		return sTitle;
	}
	
	public String getInfo()
	{
		return(sTitle + "	" + sArtist + "	" + sGenre);
	}
}