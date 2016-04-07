package medialibrary;

public class TVShow extends Video{

	private String tvEpisodes;
	private String tvSeasons;
	private String tvTotalEpisodes;
	private String tvTotalSeasons;
	private int episodeLength;
	
	public TVShow(String title, String rating, String genre, String description, String episodes, String seasons, String totalEpisodes, String totalSeasons, int length) {
		super(title, rating, genre, description);
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

}
