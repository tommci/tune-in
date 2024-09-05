package Music;

public class Artist {
	private String name;
	private int albumCount;
	private int singleCount;
	private Album[] albums;
	private Song[] singles;
	
	public Artist(String name, Album[] albums, Song[] singles) {
		this.name = name;
		this.albumCount = albums.length;
		this.singleCount = singles.length;
		this.albums = albums;
		this.singles = singles;
	}
	
	public void addSingle(Song single) {
		this.singleCount++;
		Song[] tempSongList = new Song[this.singleCount];
		
		int i = 0;
		for (Song song : this.singles) {
			tempSongList[i] = song;
			i++;
		}
		tempSongList[i] = single;
		
		this.singles = tempSongList;
	}
	
	public void addAlbum(Album newAlbum) {
		this.albumCount++;
		Album[] tempAlbumList = new Album[this.albumCount];
		
		int i = 0;
		for (Album album : this.albums) {
			tempAlbumList[i] = album;
			i++;
		}
		tempAlbumList[i] = newAlbum;
		
		this.albums = tempAlbumList;
	}
}
