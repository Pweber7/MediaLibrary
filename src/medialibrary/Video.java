package medialibrary;

public abstract class Video {

	protected String vTitle;
	protected String vRating;
	protected String vGenre;
	protected String vDescription;
	protected boolean vOnWatchlist;
	
	protected Video(String title, String rating, String genre, String description, boolean onWatchlist){
		vTitle = title;
		vRating = rating;
		vGenre = genre;
		vDescription = description;
		vOnWatchlist = onWatchlist;
		
	}
	
	public abstract String getInfo();
	
	public boolean isOnWatchlist()
	{
		return vOnWatchlist;
	}
	
	public String getRating()
	{
		return vRating;
	}
	
	public String getGenre()
	{
		return vGenre;
	}
	
	public String description()
	{
		return vDescription;
	}
	
	public String getTitle(){
		return vTitle;
	}
	
	public abstract boolean setFullyWatched();
}