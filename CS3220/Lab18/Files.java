package Lab18;

public class Files {
	
	int id;
	String name;
	boolean is_folder;
	int  parent_id;
	int owner_id;
	
	
	
	public Files(int id, String name, boolean is_folder, int i, int j) {
		super();
		this.id = id;
		this.name = name;
		this.is_folder = is_folder;
		this.parent_id = i;
		this.owner_id = j;
	}



	public Files( String name, boolean is_folder, int i, int j) {
		super();
	
		this.name = name;
		this.is_folder = is_folder;
		this.parent_id = i;
		this.owner_id = j;
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



	public boolean isIs_folder() {
		return is_folder;
	}



	public void setIs_folder(boolean is_folder) {
		this.is_folder = is_folder;
	}



	public int getParent_id() {
		return parent_id;
	}



	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}



	public int getOwner_id() {
		return owner_id;
	}



	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	
	
	
	
	
	
	
	

}
