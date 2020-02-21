package HW5;

public class Users {
	
	String name;
	String password;
	int is_admin;
	int id;
	
	
	
	
	




	public Users(int id,String name, String password, int is_admin) {
		super();
		this.name = name;
		this.password = password;
		this.is_admin = is_admin;
		this.id = id;
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





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public int  isIs_admin() {
		return is_admin;
	}





	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
