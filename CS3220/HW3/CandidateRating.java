package CandidateRating;

import java.util.ArrayList;
import java.util.List;

public class CandidateRating {
	
	static int count=1;
	int id;
	public String name;
   
	public ArrayList <FeedbackModel> feedback; 
	
    //public ArrayList<Integer> ListOfrate;
	public String specialties;
	public String presentation;
	
	
	
	
	public float getRating() {
		
		float total=0;
		int size=feedback.size();
		if (size==0) {
			
			return 0;
		}
		
		for (int i=0;i<feedback.size();i++) {
			total+=feedback.get(i).rate;
				
		}
		
	
	return (total/size);	
		
		//System.out.print(feedback.size());
		
//return 0;
	}
	
	
	
	
	public CandidateRating(String name,  String specialties,String presentation,ArrayList<FeedbackModel> feedback) {
		super();
		this.id = count++;
		this.name = name;
		this.feedback = feedback;
		this.specialties = specialties;
		this.presentation = presentation;
	}

	
	
	
	

	public CandidateRating( String name, String specialties, String presentation) {
		super();
		this.id = count++;
		this.name = name;
		this.specialties = specialties;
		this.presentation = presentation;
		this.feedback=feedback;
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


	
	
	
	public ArrayList<FeedbackModel> getFeedback() {
		return feedback;
	}


	public void setFeedback(ArrayList<FeedbackModel> feedback) {
		this.feedback = feedback;
	}


	

}
