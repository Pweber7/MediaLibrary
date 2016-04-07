package medialibrary;

public abstract class Video {

	protected String vTitle;
	protected String vRating;
	protected String vGenre;
	protected String vDescription;
	
	protected Video(String title, String rating, String genre, String description){
		vTitle = title;
		vRating = rating;
		vGenre = genre;
		vDescription = description;
		
	}
	
	public abstract String getInfo();
	
	public String getTitle(){
		return vTitle;
	}
}