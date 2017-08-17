package Assignment1;

public class Sprinter extends Athletes{

	public Sprinter(String rID, String name, String age, String stateOfAustralia, int point) {
		super(rID, name, age, stateOfAustralia, point);
		
	}

	@Override
	public double compete() {
		double time = (1 + Math.random()) * 10;
		return time;
	}

}
