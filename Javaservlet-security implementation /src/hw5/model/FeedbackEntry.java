package hw5.model;

import java.util.Date;

public class FeedbackEntry {

	int rating = -1;
	String name;
	String comment;
	Date date;
	String userName;
	int feedId;

	public FeedbackEntry() {
	}

	public FeedbackEntry(int rating, String name, String commentString, Date date, String userName, int feedId) {
		this.rating = rating;
		this.name = name;
		this.comment = commentString;
		this.date = date;
		this.userName = userName;
		this.feedId = feedId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String commentString) {
		this.comment = commentString;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	

}
