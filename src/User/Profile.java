package User;

public class Profile {
	private String username;
	private int userid;
	private static int lastUserId = 0;
	private Review[] reviews;
	private int reviewCount;
	
	public Profile(String username) {
		this.username = username;
		lastUserId++;
		this.userid = lastUserId;
		this.reviewCount = 0;
		this.reviews = new Review[0]; // note that it IS possible for a profile to have no reviews: will need to compensate for this!
	}
	
	public void addReview(Review newReview) {
		this.reviewCount++;
		Review[] tempReviewList = new Review[this.reviewCount];
		
		if (reviewCount > 1) {
			int i = 0;
			for (Review review : this.reviews) {
				tempReviewList[i] = review;
				i++;
			}
			tempReviewList[i] = newReview;
		} else {
			tempReviewList[0] = newReview;
		}
		
		this.reviews = tempReviewList;
	}
}
