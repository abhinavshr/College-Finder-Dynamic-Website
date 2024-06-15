package model;

public class modelReview {
	
	private String FullName;
	private String Rating;
	private String Review;
	public modelReview(String fullName, String rating, String review) {
		super();
		this.FullName = fullName;
		this.Rating = rating;
		this.Review = review;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}
	
	
}
