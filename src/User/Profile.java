package User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Profile {
	private String username;
	private int userid;
	private static int lastUserId = 0;
	private ArrayList<Review> reviews;
	private int reviewCount;
	
	public Profile(String username) {
		this.username = username;
		lastUserId++;
		this.userid = lastUserId;
		this.reviewCount = 0;
		this.reviews = new ArrayList<Review>();
	}
	
	public void saveUserToFile() {
		String filePath = System.getProperty("user.home") + "/Documents/TuneIn/Users";
		File userDir = new File(filePath);
		if(userDir.exists() || userDir.mkdirs()) { // if the directory exists, do nothing and keep going. if it doesn't fully exist, create it and keep going.
			try {
				PrintWriter out = new PrintWriter(filePath + "/" + this.username + ".dat"); // saves user information to <username>.dat file
				out.print(this.username + "\n" + this.userid + "\n" + this.reviewCount);
				// TODO: implement how reviews are saved to this file (or perhaps a new file?)
				out.close();
			} catch(FileNotFoundException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
	}
	
	public void addReview(Review newReview) {
		this.reviewCount++;
		this.reviews.add(newReview);
	}
}
