package Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Scanner;

public class HandleSpotifyAPI {

	private static final String clientID = "5211eb0a1f424fc0b8510ba7a00aebfc";
	private String clientSecret;
	
	private String accessToken;
	
	public HandleSpotifyAPI() {
		this.clientSecret = this._getSecret();
		String clientInfo = clientID + ":" + this.clientSecret;
		String encodedClientInfo = Base64.getEncoder().encodeToString(clientInfo.getBytes());
		
		// create the POST request as specified in Spotify's Web API page
		// currently using the client credentials flow
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
				.uri(URI.create("https://accounts.spotify.com/api/token"))
				.header("Authorization","Basic " + encodedClientInfo)
				.header("Content-Type","application/x-www-form-urlencoded")
				.build();
		
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
			String[] handleJson = response.body().split("\""); // super rudimentary way to handle the json output
			this.accessToken = handleJson[3]; // the token itself will be index 3 here
			
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * For now, I will just be entering my secret manually through the console.
	 * @return a client secret for use with the Spotify API
	 */
	private String _getSecret() {
		System.out.print("Client secret: ");
		Scanner in = new Scanner(System.in);
		String secret = in.nextLine();
		in.close();
		return secret;
	}
	
	public static void main(String[] args) {
		HandleSpotifyAPI api = new HandleSpotifyAPI();
	}
	
}
