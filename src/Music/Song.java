package Music;

public class Song {
	private String name;
	private Artist[] artists;
	private int artistCount;
	private Duration duration;
	
	public Song(String name, Artist[] artists, Duration duration) {
		this.name = name;
		this.artists = artists;
		this.artistCount = artists.length;
		this.duration = duration;
	}
}
