package medialibrary;

public abstract class Video {

	private String vTitle;
	private String vRating;
	private String vGenera;
	private String vDescription;
	
	protected Video(String title, String rating, String genera, String description){
		vTitle = title;
		vRating = rating;
		vGenera = genera;
		vDescription = description;
		
	}
	
	public abstract String getInfo();
	
	public String getTitle(){
		return vTitle;
	}
}