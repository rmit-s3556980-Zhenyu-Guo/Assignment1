package Assignment1;

public class Swimmer extends Athletes {

	public Swimmer(String sID, String name, String age, String stateOfAustralia, int point) {
		super(sID, name, age, stateOfAustralia, point);
	}

	@Override
	public double compete() {
		double time = (1 + Math.random()) * 100;
		return time;
	}

}
