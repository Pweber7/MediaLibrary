package medialibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseSupport {
	
	private static final String HOST = "mysql.cs.iastate.edu";
	private static final String USER = "dbu362jacobs62";
	private static final String PASSWORD = "59qrTPd2hYVh";
	private static final String DBNAME = "db362jacobs62";
	
	private Connection connect = null;
	
	public DatabaseSupport(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Properties connProps = new Properties();
			connProps.put("user", USER);
			connProps.put("password", PASSWORD);
			connect = DriverManager.getConnection("jdbc:mysql://"+HOST+":3306"+"/", connProps);
		}
		catch(SQLException e){
			System.out.println("Failed to connect to the database.");
		} catch (ClassNotFoundException e) {
			System.out.println("Could not set driver.  ");
			e.printStackTrace();
		}
	}

	public List<Video> getWatchlist(){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where OnWatchlist=1");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime") - rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where OnWatchlist=1");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Song> getPlaylist(){
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where OnPlaylist=1");
			while(rs.next()){
				list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"), rs.getBoolean("onPlaylist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean removeFromWatchlist(String title){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			stmt.executeUpdate("update "+DBNAME+".Movie set OnWatchlist=0 where Title='"+title+"'");
			stmt.executeUpdate("update "+DBNAME+".TVShow set OnWatchlist=0 where Title='"+title+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addToWatchlist(String title){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			stmt.executeUpdate("update "+DBNAME+".Movie set OnWatchlist=1 where Title='"+title+"'");
			stmt.executeUpdate("update "+DBNAME+".TVShow set OnWatchlist=1 where Title='"+title+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addToPlaylist(String title){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			stmt.executeUpdate("update "+DBNAME+".Song set OnPlaylist=1 where Title='"+title+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<Video> listVideoLibrary(){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime")-rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Song> listMusicLibrary(){
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song");
			while(rs.next()){
				list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"), rs.getBoolean("onPlaylist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Video getVideo(String title){
		Video v = null;
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where Title='"+title+"'");
			if(rs.next()){
				v = new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime")-rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist"));
			}
			else{
				rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where Title='"+title+"'");
				if(rs.next()){
					v = new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
							rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public Song getSong(String title){
		Song s = null;
		Statement stmt;
		try {
			stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where Title='"+title+"'");
			if(rs.next())
			{
				s = new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"), rs.getBoolean("onPlaylist"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public List<Video> searchVideoLibraryGenre(String genre){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		
		try{
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from "+DBNAME+".Movie where Genre='"+genre+"'");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), rs.getInt("Runtime"), rs.getInt("Runtime") - rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("Select * from "+DBNAME+".TVShow where Genre='"+genre+"'");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Video> searchVideoLibraryTitle(String title){
		ArrayList<Video> list = new ArrayList<>();
		ArrayList<Video> lib = new ArrayList<>();
		lib = (ArrayList<Video>) listVideoLibrary();
		
		for(Video v : lib){
			if(v.getTitle().contains(title)){
				list.add(v);
			}
		}
		return list;
	}
	
	public List<Video> searchWatchlistTitle(String title){
		ArrayList<Video> list = new ArrayList<>();
		ArrayList<Video> wList = new ArrayList<>();
		wList = (ArrayList<Video>) getWatchlist();
		
		for(Video v : wList){
			if(v.getTitle().contains(title)){
				list.add(v);
			}
		}
		return list;
	}
	 
	public boolean putSong(Song s){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			stmt.executeUpdate("update "+DBNAME+".Song set OnPlaylist=" + s.isOnPlaylist() + ", Artist='" 
			+ s.getArtist() + "', Genre='" + s.getGenre() + "' where Title='"+s.getTitle()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Video> searchWatchlistRuntime(int runtime){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try{
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where OnWatchlist=1 and Runtime<="+runtime);
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime")-rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where OnWatchlist=1 and Length<="+runtime);
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Video> searchWatchlistTimeRemaining(int timeRemaining){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try{
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where OnWatchlist=1 and TimeRemaining<="+timeRemaining);
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime")-rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where OnWatchlist=1 and Length<="+timeRemaining);
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	public List<Video> searchVideoLibraryRating(String rating){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where Rating = '" + rating + "'");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime") - rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where Rating = '" + rating + "'");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Video> searchWatchlistRating(String rating){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where OnWatchlist=1 and Rating = '" + rating + "'");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime") - rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where OnWatchlist=1 and Rating = '" + rating + "'");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Video> searchWatchlistGenre(String genre){
		ArrayList<Video> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Movie where OnWatchlist=1 and Genre = '" + genre + "'");
			while(rs.next()){
				list.add(new Movie(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("Runtime"), rs.getInt("Runtime") - rs.getInt("TimeRemaining"), rs.getBoolean("onWatchlist")));
			}
			rs = stmt.executeQuery("select * from "+DBNAME+".TVShow where OnWatchlist=1 and Genre = '" + genre + "'");
			while(rs.next()){
				list.add(new TVShow(rs.getString("Title"), rs.getString("Rating"), rs.getString("Genre"), rs.getString("Description"), 
						rs.getInt("EpisodesWatched"), rs.getInt("SeasonsWatched"), rs.getInt("Episodes"), rs.getInt("Seasons"), rs.getInt("Length"), rs.getBoolean("onWatchlist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Song> searchPlaylistTitle(String title)
	{
		ArrayList<Song> list = new ArrayList<>();
		ArrayList<Song> lib = new ArrayList<>();
		lib = (ArrayList<Song>) getPlaylist();
		
		for(Song s : lib){
			if(s.getTitle().contains(title)){
				list.add(s);
			}
		}
		return list;
	}
	
	public List<Song> searchSongLibraryArtist(String artist)
	{
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where Artist ='"+artist+"'");
			while(rs.next()){
				list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"), rs.getBoolean("onPlaylist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Song> searchSongLibraryGenre(String genre){
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where Genre='"+genre+"'");
			while(rs.next()){
				list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"), rs.getBoolean("onPlaylist")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Song> searchSongLibraryTitle(String title){
		ArrayList<Song> list = new ArrayList<>();
		ArrayList<Song> lib = new ArrayList<>();
		lib = (ArrayList<Song>) listMusicLibrary();
		
		for(Song s : lib){
			if(s.getTitle().contains(title)){
				list.add(s);
			}
		}
		return list;
	}
	
	public boolean putVideo(Video v){
		Statement stmt;
		try {
			stmt = connect.createStatement();
			if(v.getClass()==Movie.class){
				Movie m = (Movie)v;
				stmt.executeUpdate("update "+DBNAME+".Movie set OnWatchlist=" + m.isOnWatchlist() + ", Genre='"
					+ m.getGenre() + "', Rating='" + m.getRating() + "', Description='" + m.getDescription() + 
					"', Runtime=" + m.getRuntime() + ", TimeRemaining="+ (m.getRuntime()-m.getTimeWatched()) + " where Title='"+ m.getTitle() + "'");
			}
			else{
				TVShow t = (TVShow) v;
				stmt.executeUpdate("update "+DBNAME+".TVShow set OnWatchlist=" + t.isOnWatchlist() + ", Genre='"
						+ t.getGenre() + "', Rating='" + t.getRating() + "', Description='" + t.getDescription() + 
						"', Episodes=" + t.getTotalEpisodes() + ", Seasons=" + t.getTotalSeasons() + ", EpisodesWatched="
						+ t.getEpisodes() + ", SeasonsWatched=" + t.getSeasons() + " where Title='"+ t.getTitle() + "'");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
