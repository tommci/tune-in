package User;

public class Review {
	private int score; // score will be on a scale of 1-10, with 10 being good and 1 being bad
	private String reviewText;
	
	public Review(int score, String review) {
		this.score = score;
		this.reviewText = review;
	}
}
