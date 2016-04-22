package medialibrary;

public class TVShow extends Video{

	private int tvEpisodes;
	private int tvSeasons;
	private int tvTotalEpisodes;
	private int tvTotalSeasons;
	private int episodeLength;
	
	public TVShow(String title, String rating, String genre, String description, int episodes, int seasons, int totalEpisodes, int totalSeasons, int length, boolean onWatchlist) {
		super(title, rating, genre, description, onWatchlist);
		tvEpisodes = episodes;
		tvSeasons = seasons;
		tvTotalEpisodes = totalEpisodes;
		tvTotalSeasons = totalSeasons;
		episodeLength = length;
	}
	
	public String getInfo()
	{
		String s = "";
		
		s += "Title: " + vTitle + "\n";
		s += "Rating: " + vRating + "\n";
		s += "Description: " + vDescription + "\n";
		s += "Episodes Watched: " + tvEpisodes + "/" + tvTotalEpisodes + "\n";
		s += "Seasons Watched: " + tvSeasons + "/" + tvTotalSeasons + "\n";
		s += "Epiode Length: " + episodeLength + "\n";
		return s;
	}
	
	public int getEpisodes()
	{
		return tvEpisodes;
	}
	
	public int getSeasons()
	{
		return tvSeasons;
	}
	
	public int getTotalEpisodes()
	{
		return tvTotalEpisodes;
	}
	
	public int getTotalSeasons()
	{
		return tvTotalSeasons;
	}
	
	public int getEpisodeLength()
	{
		return episodeLength;
	}

	@Override
	public boolean setFullyWatched(){
		tvEpisodes = tvTotalEpisodes;
		tvSeasons = tvTotalSeasons;
		return true;
	}
}
