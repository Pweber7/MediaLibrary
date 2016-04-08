package medialibrary;

public class Movie extends Video{

	private int mRuntime;
	private int mTimeWatched;
	
	protected Movie(String title, String rating, String genre, String description, int runtime, int timeWatched){
		super(title, rating, genre, description);
		mRuntime = runtime;
		mTimeWatched = timeWatched;
	}
	
	public String getInfo(){
		String info = null;
		info += vTitle + "\n" + vGenre + "\n" + vRating + "\n" + mTimeWatched + " / " + mRuntime + "\n" + vDescription + "\n";
		return info;
	}
}
