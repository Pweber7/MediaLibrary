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
		return dummyWatchlist;
	}
	
	public List<Song> getPlaylist(){
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where OnPlaylist=1");
		while(rs.next()){
			list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre")));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean removeFromWatchlist(String title){
		Video v = dummyFindVideo(title, dummyWatchlist);
		return dummyWatchlist.remove(v);
	}
	
	public boolean addToWatchlist(String title){
		Video v = dummyFindVideo(title, dummyVideoLibrary);
		return dummyWatchlist.add(v);
	}
	
	public boolean addToPlaylist(String title){
		Song s = dummyFindSong(title, dummySongLibrary);
		return dummyPlaylist.add(s);
	}
	
	public List<Video> listVideoLibrary(){
		return dummyVideoLibrary;
	}
	
	public List<Song> listMusicLibrary(){
		return dummySongLibrary;
	}
	
	public Video getVideo(String title){
		return dummyFindVideo(title, dummyVideoLibrary);
	}
	
	public Song getSong(String title){
		return dummyFindSong(title, dummySongLibrary);
	}
	
	private Video dummyFindVideo(String title, ArrayList<Video> list){
		for(Video v : list){
			if(v.getTitle().equals(title)){
				return v;
			}
		}
		return null;
	}
	
	private Song dummyFindSong(String title, ArrayList<Song> list){
		for(Song s : list){
			if(s.getTitle().equals(title)){
				return s;
			}
		}
		return null;
	}
}
