package User;

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
	
	public void addReview(Review newReview) {
		this.reviewCount++;
		this.reviews.add(newReview);
	}
}
