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
						rs.getInt("Runtime"), rs.getInt("TimeWatched")));
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
		return dummyVideoLibrary;
	}
	
	public List<Song> listMusicLibrary(){
		ArrayList<Song> list = new ArrayList<>();
		Statement stmt;
		try {
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song");
			while(rs.next()){
				list.add(new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Video getVideo(String title){
		return dummyFindVideo(title, dummyVideoLibrary);
	}
	
	public Song getSong(String title){
		Song s = null;
		Statement stmt;
		try {
			stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+DBNAME+".Song where Title='"+title+"'");
			if(rs.next()){
				s = new Song(rs.getString("Title"), rs.getString("Artist"), rs.getString("Genre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	private Video dummyFindVideo(String title, ArrayList<Video> list){
		for(Video v : list){
			if(v.getTitle().equals(title)){
				return v;
			}
		}
		return null;
	}
}
