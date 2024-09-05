package Music;

public class Album {
	private String name;
	private Artist artist;
	private int songCount;
	private SongOnAlbum[] tracklist;
	
	public Album(String name, Artist artist, SongOnAlbum[] tracklist) {
		this.name = name;
		this.artist = artist;
		this.songCount = tracklist.length;
		this.tracklist = tracklist;
	}
}
