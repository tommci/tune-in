/*
 * When I begun this project I had originally intended on using Spotify's API to get music information.
 * At that time I had not known that their policy on use of metadata were quite overbearing. Once I found this out
 * I realized using Spotify wouldn't be viable for my plans with this project.
 * 
 * However, this class file was an important step for me to learn how to send/receive HTTP requests to an API.
 * I don't want to delete all that progress so I'm leaving it here for archival purposes and to remember this learning experience for
 * me personally.
 */
package Data;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Scanner;

public class UNUSED_HandleSpotifyAPI {

	private static final String clientID = "5211eb0a1f424fc0b8510ba7a00aebfc";
	private String clientSecret;
	
	private String accessToken;
	
	private UNUSED_HandleSpotifyAPI() { // made the constructor private to avoid instantiating this anywhere since it's unused
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
	
}
