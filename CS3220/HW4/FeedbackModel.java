package CandidateRating;

import java.util.ArrayList;
import java.util.Date;

public class FeedbackModel {
	
		
		String  message;
		String name;
		Date date;
		int rate;

public FeedbackModel (String name ,String message,Date date,int rate) {
	super();
	
	
	this.message = message;
	this.name = name;
	this.date= date;
	this.rate=rate;
}



public int getRate() {
	return rate;
}



public void setRate(int rate) {
	this.rate = rate;
}



public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getName() {
	return name;
}
public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public void setName(String name) {
	this.name = name;
}




	

}
