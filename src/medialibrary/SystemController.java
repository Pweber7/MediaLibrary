package medialibrary;

import java.util.List;

public class SystemController {

	MLSystem mls = new MLSystem();
	
	public List<Video> listWatchlist(){
		return mls.listWatchlist();
	}
	
	public boolean removeFromPlaylist(String name)
	{
		return mls.removeFromPlaylist(name);
	}
	
	public boolean removeFromWatchlist(String title){
		return mls.removeFromWatchlist(title);
	}
	
	public List<Video> listVideoLibrary(){
		return mls.listVideoLibrary();
	}	
	
	public Video getInformationVideo(String title){
		return mls.getInformationVideo(title);
	}
	
	public Song getInformationSong(String title){
		return mls.getInformationSong(title);
	}
	
	public boolean addToWatchlist(String title){
		return mls.addToWatchlist(title);
	}
	
	public List<Song> listMusicLibrary(){
		return mls.listMusicLibrary();
	}
	
	public List<Song> listPlaylist(){
		return mls.listPlaylist();
	}
	
	public List<Video> searchWatchlistTitle(String title)
	{
		return mls.searchWatchlistTitle(title);
	}
	
	public List<Video> searchVideoLibraryTitle(String title)
	{
		return mls.searchVideoLibraryTitle(title);
	}
	
	public List<Video> searchWatchlistRating(String rating)
	{
		return mls.searchWatchlistRating(rating);
	}
	
	public List<Video> searchVideoLibraryRating(String rating)
	{
		return mls.searchVideoLibraryRating(rating);
	}
	
	public List<Video> searchWatchlistGenre(String genre)
	{
		return mls.searchWatchlistGenre(genre);
	}
	
	public List<Video> searchWatchlistRuntime(int runtime)
	{
		return mls.searchWatchlistRuntime(runtime);
	}
	
	public List<Video> searchWatchlistTimeRemaining(int timeRemaining)
	{
		return mls.searchWatchlistTimeRemaining(timeRemaining);
	}
	
	public boolean addToPlaylist(String title){
		return mls.addToPlaylist(title);
	}
	
	public List<Video> searchVideoLibraryGenre(String genre){
		return mls.searchVideoLibraryGenre(genre);
	}
	
	public boolean setTimeWatched(String title, int minutes)
	{
		return mls.setTimeVideoWatched(title, minutes);
	}
	
	public List<Song> searchSongLibraryArtist(String artist)
	{
		return mls.searchSongLibraryArtist(artist);
	}
	public List<Song> searchSongLibraryGenre(String genre){
		return mls.searchSongLibraryGenre(genre);
	}
	
	public List<Song> searchSongLibraryTitle(String title){
		return mls.searchSongLibraryTitle(title);
	}
	
	public List<Song> searchPlaylistTitle(String title){
		return mls.searchPlaylistTitle(title);
	}
	
	public List<Song> searchPlaylistArtist(String artist){
		return mls.searchPlaylistArtist(artist);
	}
	
	public boolean editVideoToWatched(String title){
		return mls.editVideoToWatched(title);
	}
	
	public boolean editNumberEpisodesWatched(String title, int episodes){
		return mls.editNumberEpisodesWatched(title, episodes);
	}
	
	public boolean editNumberSeasonsWatched(String title, int seasons){
		return mls.editNumberSeasonsWatched(title, seasons);
	}
}
