package Music;

import java.util.ArrayList;

public class Album extends MusicItem implements Reviewable {
	private ArrayList<Song> songList;
	private ArrayList<Artist> albumArtists;
	
	public Album(String albumName, ArrayList<Song> songs, ArrayList<Artist> artists) {
		super(albumName);
		this.songList = new ArrayList<Song>(songs);
		this.albumArtists = new ArrayList<Artist>(artists);
	}
	
	public Album(Album toCopy) {
		super(toCopy.getName());
		this.songList = new ArrayList<Song>(toCopy.songList);
		this.albumArtists = new ArrayList<Artist>(toCopy.albumArtists);
	}
	
	public void addSong(Song song) {
		songList.add(song);
	}
	
	public void removeSong(String songName) {
		for(int i = 0; i < songList.size(); i++) {
			if ( (songList.get(i).getName()).equals(songName) ) {
				songList.remove(i);
				break;
			}
		}
	}
}
