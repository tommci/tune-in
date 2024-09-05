package Music;

public class SongOnAlbum extends Song {
	private Album album;
	
	public SongOnAlbum(String name, Artist[] artists, Duration duration, Album album) {
		super(name, artists, duration);
		this.album = album;
	}
}
