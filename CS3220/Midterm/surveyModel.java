package Mid;

import java.util.ArrayList;
import java.util.List;



public class surveyModel {
	
	
	    static int count;
		int size;
		
		public  List<questionsModel> questions;
		String name;
		int id;
		
		
		
public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


public surveyModel(String name, List<questionsModel> questions) {
	super();
	id=count++;
	this.name = name;
	this.size = count++;
	this.questions = questions;
}


public surveyModel(String name) {
	super();
	id=count++;
	this.name = name;
	this.size = count++;
	this.questions = questions;
	this.questions = new ArrayList<questionsModel>();
}



public int getSize() {
	return size;
}



public void setSize(int size) {
	this.size = size;
}



public List<questionsModel> getQuestions() {
	return questions;
}



public void setQuestions(List<questionsModel> questions) {
	this.questions = questions;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}








	

}
