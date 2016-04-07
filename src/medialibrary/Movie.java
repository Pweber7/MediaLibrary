package medialibrary;

public class Movie extends Video{

	private String mRuntime;
	private String mTimeWatched;
	
	protected Movie(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	public String getInfo(){
		String info = null;
		info += vTitle + "\n" + vGenre + "\n" + vRating + "\n" + mTimeWatched + " / " + mRuntime + "\n" + vDescription + "\n";
		return info;
	}
}
