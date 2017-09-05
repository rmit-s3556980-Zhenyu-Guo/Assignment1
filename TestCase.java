package Assignment1;

public class TestCase {

	public static void main(String[] args) {
		
//		//Test Swimmer, Sprinter, Cyclist Class
//		Swimmer a = new Swimmer("aa", "bb", "cc", "dd", 0);
//		for(int i=0;i<1000000;i++){
//			if(a.compete("Swimming")>=200 || a.compete("Swimming")<=100)
//				System.out.println(a.compete("Swimming"));
//		}
//		System.out.println("all right");
//		
		SuperAthletes sa = new SuperAthletes("aa", "bb", "cc", "dd", 0);
		for(int i=0;i<10;i++){
			if(sa.compete("Swimming")>=200 || sa.compete("Swimming")<=100)
				System.out.println(sa.compete("Swimming"));
		}
		System.out.println("all right");
//		
//		Sprinter b = new Sprinter("aa", "bb", "cc", "dd", 0);
//		for(int i=0;i<1000000;i++){
//			if(b.compete()>=20 || b.compete()<=10)
//				System.out.println(b.compete());
//		}
//		System.out.println("all right");
//		
//		Cyclist c = new Cyclist("aa", "bb", "cc", "dd", 0);
//		for(int i=0;i<1000000;i++){
//			if(c.compete()>=800 || c.compete()<=500)
//				System.out.println(c.compete());
//		}
//		System.out.println("all right");
		
	//Test Driver Class
		
		Driver d = new Driver();
//		d.cyclingMenu();
//		d.meanMenu();
//		d.gameMenu();
		
		
//Test official menu
//		d.Officer();
//		d.Cyclist();
//		d.SuperAthletes();
		
//		d.officialMenu();
//		int z = 001;
//		int x = 2;
//		int v = z + x;
//		System.out.println("v is :" + v);
//				
//Test Menu
//		d.SuperAthletes();
//		d.Cyclist();
		d.meanMenuControl();
		
	}
}
