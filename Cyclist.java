package Assignment1;

import java.util.*;

public class Cyclist extends Athletes{

	public Cyclist(String cID, String name, String age, String stateOfAustralia, int point) {
		super(cID, name, age, stateOfAustralia, point);
	}

	@Override
	public double compete() {
		Random rand = new Random();
		// To make a random double from 500 to 800
		double time = (rand.nextInt(3) + 5 + Math.random()) * 100;
		return time;
	}

}
