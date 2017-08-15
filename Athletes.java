package Assignment1;

public abstract class Athletes {
	
	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	private int point;
	
	public Athletes(String ID, String name, String age, String stateOfAustralia, int point){
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.stateOfAustralia = stateOfAustralia;
		this.point = point;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getStateOfAustralia(){
		return stateOfAustralia;
	}
	
	public int getPoint(){
		return point;
	}
	
	public void setPoint(){
		this.point = point;
	}
	
	public abstract double compete();
	
	
	
	
	
	
	
	
	
	
	

}
