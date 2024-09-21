package Music;

import java.util.ArrayList;

public class Song extends MusicItem implements Reviewable {
	private Duration songDuration;
	private ArrayList<Artist> artists;
	private Album album;
	
	public Song(String songName, ArrayList<Artist> artists, Album album) {
		super(songName);
		this.artists = new ArrayList<Artist>(artists);
		this.album = new Album(album);
	}
	
	
}
