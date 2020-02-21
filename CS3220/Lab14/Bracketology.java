package Team;

import java.util.List;

public class Bracketology {
	
	
	static int count=1;
	String team1;
	String team2;
	int id;

	
	
	public Bracketology(String team1, String team2) {
		this.team1 = team1;
		this.team2 = team2;
		this.id = count++;
	}
	
	

	public String getteam1() {
		return team1;
	}

	public void setteam1(String team1) {
		this.team1 = team1;
	}

	public String getteam2() {
		return team2;
	}

	public void setteam2(String team2) {
		this.team2 = team2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	

	
 









}
