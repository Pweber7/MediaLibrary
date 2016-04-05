package medialibrary;

public abstract class Video {

	private String vTitle;
	
	protected Video(String title){
		vTitle = title;
	}
	
	public String getTitle(){
		return vTitle;
	}
}