package Data;

public abstract class DataHandler {
	
	private static final String ROOT = "https://musicbrainz.org/ws/2/";
	
	public static String getArtists(String query) {
		String extension = "artist/?query=artist:" + query.replace(" ", "%20");
		String fullQuery = ROOT + extension;
		return fullQuery;
	}
	
	
	public static void main(String[] args) {
		System.out.println(DataHandler.getArtists("porter robinson"));
	}
}
