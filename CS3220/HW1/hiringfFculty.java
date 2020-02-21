package Candidate_Reviews;

 
 
public class hiringfFculty {
	static int count=0;
	
	
	int Id;
	String name;
	String Specialties;
	String  Presentation;
	
	
	
	
	
	public int getId() {
		return Id;
	}
	
	
	
	public hiringfFculty() {

		Id =++count ;
		this.name = "";
		Specialties = "";
		Presentation = "";
	    }
		
	
public hiringfFculty( String name, String specialties, String presentation) {
	super();
	this.Id =++count ;
	this.name = name;
	Specialties = specialties;
	Presentation = presentation;
    }
	


	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialties() {
		return Specialties;
	}
	public void setSpecialties(String specialties) {
		Specialties = specialties;
	}
	public String getPresentation() {
		return Presentation;
	}
	public void setPresentation(String presentation) {
		Presentation = presentation;
	}

	
	
	
	
	

}
