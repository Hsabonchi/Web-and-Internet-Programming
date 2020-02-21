package HW2;

public class CandidatesModel {

	static int count=1;
	int id;
	public String name;
	public String specialties;
	public String presentation;
	
	
	public CandidatesModel( String name, String specialties, String presentation) {
		super();
		this.id = count++;
		this.name = name;
		this.specialties = specialties;
		this.presentation = presentation;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpecialties() {
		return specialties;
	}


	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}


	public String getPresentation() {
		return presentation;
	}


	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}


	


}
