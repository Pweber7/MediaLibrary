package medialibrary;

public class Movie extends Video{

	private int mRuntime;
	private int mTimeWatched;
	
	protected Movie(String title, String rating, String genre, String description, int runtime, int timeWatched, boolean onWatchlist){
		super(title, rating, genre, description, onWatchlist);
		mRuntime = runtime;
		mTimeWatched = timeWatched;
	}
	
	public String getInfo(){
		String info = null;
		info += vTitle + "\n" + vGenre + "\n" + vRating + "\n" + mTimeWatched + " / " + mRuntime + "\n" + vDescription + "\n";
		return info;
	}
	
	public int getRuntime()
	{
		return mRuntime;
	}
	
	public int getTimeWatched()
	{
		return mTimeWatched;
	}

	public boolean setTimeWatched(int minutes)
	{
		mTimeWatched += minutes;
		if(mTimeWatched > mRuntime)
		{
			mTimeWatched = mRuntime;
		}
		return true;
	}
	
	@Override
	public boolean setFullyWatched(){
		mTimeWatched = mRuntime;
		return true;
	}
}
