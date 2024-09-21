package Music;

import java.util.ArrayList;

public class Artist extends MusicItem implements Reviewable {
	private ArrayList<Song> allArtistSongs;
	private ArrayList<Album> artistAlbums;
	
	public Artist(String artistName, ArrayList<Song> songs, ArrayList<Album> albums) {
		super(artistName);
		this.allArtistSongs = new ArrayList<Song>(songs);
		this.artistAlbums = new ArrayList<Album>(albums);
	}
}
