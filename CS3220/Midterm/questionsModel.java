package Mid;

import java.util.List;



public class questionsModel {
	
String description;

static int index=0;
int  size;
List <String>  chocies;
static int counter;
int id;


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public int getSize() {
	return size;
}


public void setSize(int size) {
	this.size = size;
}


public List<String> getChocies() {
	return chocies;
}


public void setChocies(List<String> chocies) {
	this.chocies = chocies;
}





public questionsModel(String description, List<String> chocies) {
	super();
	this.description = description;
	this.size = counter++;
	this.chocies = chocies;
	id=index++;
}


















}
