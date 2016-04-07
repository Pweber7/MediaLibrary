package medialibrary;

public class Movie extends Video{

	private String mRuntime;
	private String mTimeWatched;
	
	protected Movie(){
		super(vTitle, vRating, vGenre, vDescription);
	}
	
	public String getInfo(){
		String info = null;
		info += vTitle + "\n" + vGenre + "\n" + vRating + "\n" + mTimeWatched + " / " + mRuntime + "\n" + vDescription + "\n";
		return info;
	}
}
