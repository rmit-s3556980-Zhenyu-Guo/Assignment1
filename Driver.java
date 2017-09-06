import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class Driver {

Data data = new Data();
	
	
	int dataInsert = 0;
	public void Officer(){
		data.getOfficialList().put("a1", new Official("a1", "bowen", "cc", "dd"));
		data.getOfficialList().put("a2", new Official("a2", "cc", "cc", "dd"));
		data.getOfficialList().put("a3", new Official("a3", "yu", "cc", "dd"));
		data.getOfficialList().put("a4", new Official("a4", "elva", "cc", "dd"));
		data.getOfficialList().put("a5", new Official("a5", "bb", "cc", "dd"));
		data.getOfficialList().put("a6", new Official("a6", "ab", "cc", "dd"));		
	}
	public void SuperAthletes(){
		data.getSuperAthletesList().put("SA01", new SuperAthletes("SA01", "ds", "asdff", "fa", 0));
		data.getSuperAthletesList().put("SA02", new SuperAthletes("SA02", "ds", "asdff", "fa", 0));
		data.getSuperAthletesList().put("SA03", new SuperAthletes("SA03", "ds", "asdff", "fa", 0));
		data.getSuperAthletesList().put("SA04", new SuperAthletes("SA04", "ds", "asdff", "fa", 0));
		data.getSuperAthletesList().put("SA05", new SuperAthletes("SA05", "ds", "asdff", "fa", 0));
		data.getSuperAthletesList().put("SA06", new SuperAthletes("SA06", "ds", "asdff", "fa", 0));
	}
	public void Cyclist(){
		data.getCyclistList().put("c1", new Cyclist("c1", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c2", new Cyclist("c2", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c3", new Cyclist("c3", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c4", new Cyclist("c4", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c5", new Cyclist("c5", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c6", new Cyclist("c6", "bq", "ff", "aa", 0));
		data.getCyclistList().put("c7", new Cyclist("c7", "bq", "ff", "aa", 0));
		
	}
	
	//the first layer
	public void meanMenu(){
		if(dataInsert==0){
			data.Officer();
			data.Cyclist();
			data.SuperAthletes();
			dataInsert++;
		}
		System.out.println("Ozlympic Game");
		System.out.println("================================================");
		System.out.println("---1---Select a game to run---------------------");
		System.out.println("---2---Predict the winner of the game-----------");
		System.out.println("---3---Start the game---------------------------");
		System.out.println("---4---Display the final results of all games---");
		System.out.println("---5---Display the points of all athletes-------");
		System.out.println("---6---Exit-------------------------------------");
	}
	
	public void meanMenuControl(){
		meanMenu();		
		try{
			System.out.println("Please enter your commond : ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1)
				gameMenuControl();
			else if(choice == 0){
				System.out.println("Now, we have these cyclists :");
				
			}
			else if(choice == 2 ){
				predictMenuControl();
			}
			else if(choice == 3){
				startTheGame();
			}
			else if(choice == 4){
				desplayAllGameResults();
			}
			else if(choice == 5){
				displayPointsOfAllAthletes();
			}
			else if(choice == 6){
				System.out.println("------Bye------");
				System.exit(0);
			}
			else{
				System.out.println("You enter a wrong number! Try it again!");
				meanMenu();
				meanMenuControl();
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 6.");
			meanMenuControl();
		}
	}
	
	//the second layer
	public void gameMenu(){
		System.out.println("Now please select a game.");
		System.out.println("================================");
		System.out.println("---1---Cycling------------------");
		System.out.println("---2---Running------------------");
		System.out.println("---3---Swimming-----------------");
		System.out.println("---4---Back to mean menu--------");
	}
	
	
	//these three variables is used for gameID
	private int cyclingGameNumber = 1;
	//private int RunningGameNumber = 1;
	//private int SwimmingGameNumber = 1;
//	private Swimming s;
//	private Running r;
//	private Cycling c;
//	private Official o;
//	private String gameType;
	
	
	public void gameMenuControl(){
		
		gameMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				String gameID = "C" + Integer.toString(cyclingGameNumber);
				cyclingGameNumber++;
				Cycling cycling = new Cycling(gameID, "Cycling", false, null);
				data.setCycling(cycling);
				data.setGameType("Cycling");
				ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);				
			}
//			else if(choice == 2){
//				runningMenu();
//				String gameID = "R" + Integer.toString(RunningGameNumber);
//				System.out.println(gameID);
//				RunningGameNumber++;
//				ArrayList List= new ArrayList();
//				gameList.put(gameID, List);
//			}
//			else if(choice == 3){
//				swimmingMenu();
//				String gameID = "S" + Integer.toString(SwimmingGameNumber);
//				SwimmingGameNumber++;
//				ArrayList List= new ArrayList();
//				gameList.put(gameID, List);
//			}
			else if(choice == 4){		
				if(data.getOfficial() == null){
					data.setGameType(null);
				}
				meanMenuControl();
			}
			else{
				System.out.println("You enter a wrong number, try it again!");
				gameMenuControl();
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 4.");
			gameMenuControl();
		}
	}
	
	//the third layer ------ running, cycling, swimming
	public void runningMenu(){
		System.out.println("Please choose the athletes and official for the running game");
		System.out.println("============================================================");
		System.out.println("---1---Choose the athlets-----------------------------------");
		System.out.println("---2---Choose the offical-----------------------------------");
		System.out.println("---3---Back to the game menu--------------------------------");
	}
	public void runningMenuControl(String gameID, ArrayList list){
		
	}
	
	public void cyclingMenu(){
		System.out.println("Please choose the athletes and official for the cucling game");
		System.out.println("============================================================");
		System.out.println("---1---Choose the athlets-----------------------------------");
		System.out.println("---2---Choose the offical-----------------------------------");
		System.out.println("---3---Back to the game menu--------------------------------");
	}
	public void cyclingMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){		
		cyclingMenu();
		data.setcyclistInGame(cyclistInGame);
		data.setsuperAthletesInGame(superAthletesInGame);
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
			if(choice == 1){
				if(athletesNumber <= 7)
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				else {
					System.out.println("The game has 8 athletes already!");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 3){
				if(athletesNumber >= 4 && athletesNumber <=8 && officialInGame.size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, cyclistInGame, superAthletesInGame);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						if(cyclingGameNumber != 1){
							cyclingGameNumber = 1;
							data.setCycling(null);;
							data.setGameType(null);
							data.setOfficial(null);;
						}
						System.out.println("The game has been concled.");
						gameMenuControl();
					}
					else if(backOrNot.equals("no")){
						cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
					}
					else {
						System.out.println("You enter a wrong commond.");
						cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
	}

	public void checkGameLimitation(String gameID, ArrayList cyclistInGame, ArrayList superAthletesInGame){
		String reason ;
		int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
		if(athletesNumber == 8){
			System.out.println("The game has 8 athletes so you can't add any athletes!");
		}
		else if(athletesNumber < 4){
			System.out.println("There are less then 4 athletes in the game. \nIf you go back to game menu, this game will be concled.");
		}
		else{
			System.out.println("There are no official in the game. \nIf you go back to game menu, this game will be concled.");
		}
	}
	
 	public void swimmingMenu(){
		System.out.println("Please choose the athletes and official for the swimming game");
		System.out.println("=============================================================");
		System.out.println("---1---Choose the athlets------------------------------------");
		System.out.println("---2---Choose the offical------------------------------------");
		System.out.println("---3---Back to the game menu---------------------------------");
	}
	public void swimmingMenuControl(String gameID, ArrayList list){
		
	}
	
	//the last layer ------ runner, swimmer, cyclist, superathlete, official
	public void runnerMenu(){
		
	}	
	public void swimmerMenu(){
		
	}
	
	public void supperAthletesMenu(){
		int saNumber = 1;		
		
		System.out.println("And we have these superathletes :");
		
		//To print all the superathletes in the list
		Iterator iter = data.getSuperAthletesList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			System.out.println(saNumber + ". superathlete ID : " + entry.getKey() + "\tsuperathlete Name : " 
					+ entry.getValue().getName());
			saNumber++;
		}
	}

	public void cyclistMenu(){
		int cyNumber = 1;		
		
		System.out.println("Now, we have these cyclists :");
		
		//To print all the cyclists in the list
		Iterator iter = data.getCyclistList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println(cyNumber + ". cyclist ID : " + entry.getKey() + "\tcyclist Name : " 
					+ entry.getValue().getName());
			cyNumber++;
		}
	}
	public void cyclistMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			cyclistMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the cyclist is in the list and not in the game.
			if (data.getCyclistList().get(ID) != null && !cyclistInGame.contains(data.getCyclistList().get(ID))) {
				cyclistInGame.add(data.getCyclistList().get(ID));
				System.out.println("Now we have: " + cyclistInGame.size() + " cyclists in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (data.getSuperAthletesList().get(ID) != null
					&& !superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				superAthletesInGame.add(data.getSuperAthletesList().get(ID));
				System.out.println("Now, we have: " + superAthletesInGame.size() + " superathletes in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
				else{
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			} else if (data.getSuperAthletesList().get(ID) == null && data.getCyclistList().get(ID) == null) {
				System.out.println("The athlete does not exist!");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} else if (cyclistInGame.contains(data.getCyclistList().get(ID))
					|| superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
	}

	public void officialMenu(){
		int ocNumber = 1;
		
		System.out.println("Now, we have these official officers:");
		
		//To print all the official in the list
		Iterator iter = data.getOfficialList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Official> entry = (Entry<String, Official>)iter.next();
			System.out.println(ocNumber + ". official ID : " + entry.getKey() + "\tofficial Name : " 
					+ entry.getValue().getName());
			ocNumber++;
		}
	}
	public void officialMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		//Firstly, check whether there is an officer in the game	
		if(officialInGame.size() != 0){
			System.out.println("The game has already have an official.");
			System.out.println("You cann't add any other official!");
			cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
		else{
			officialMenu();
			System.out.println("Please enter the official's ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			if(data.getOfficialList().get(ID) != null){
				officialInGame.add(data.getOfficialList().get(ID));	
				data.setOfficial((Official) data.getOfficialList().get(ID));
				System.out.println("Your choice is successfull!");
				System.out.println("Now we have: " + officialInGame.size() + " official in game.");
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} 
			else {
				System.out.println("The official is not exist!");
				System.out.println("Pleas enter it again:");
				officialMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		}
	}

	
	//String pridict = null;
	public void predictMenuControl(){		
		if(data.getGameType() == null){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			System.out.println("Now we have these athletes in the game:");
			if(data.getGameType().equals("Cycling")){
				data.printCyclistInGame();
				data.printSuperAthletesInGame();
			} 
			else if(data.getGameType().equals("Swimming")){
				data.printSwimmerInGame();
				data.printSuperAthletesInGame();
			}
			else if(data.getGameType().equals("Running")){
				data.printRunnerInGame();
				data.printSuperAthletesInGame();
			} else{
				System.out.println("Something goes wrong in predictMenuControl!");
				meanMenuControl();
			}
		}
			predictGame();
	}
	public void predictGame(){
		System.out.println("Please choose an athlete's ID: ");
		Scanner sc = new Scanner(System.in);
		String athleteID = sc.nextLine();
		if(data.getGameType().equals("Cycling")){
			if(data.getCyclistList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getCyclistInGame().contains(data.getCyclistList().get(athleteID)) 
					|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
						data.setPredict(athleteID);
						System.out.println("You predict " + athleteID + " as winner!");
						meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		}
		else if(data.getGameType().equals("Swimming")){
			if(data.getSwimmerList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getSwimmerInGame().contains(data.getSwimmerList().get(athleteID))
					|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
						data.setPredict(athleteID);
						System.out.println("You predict " + athleteID + " as winner!");
						meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		} else if(data.getGameType().equals("Running")){
			if(data.getsprinterList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getRunnerInGame().contains(data.getsprinterList().get(athleteID))
						|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
					data.setPredict(athleteID);
					System.out.println("You predict " + athleteID + " as winner!");
					meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		} else {
			System.out.println("There are some error in predictGame!");
			meanMenuControl();
		}
	}
	
	String reStartUse = null;
	public void startTheGame(){
		if(data.getGameType() == null){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			if(reStartUse == null){
				HashMap<String, Double> result = new HashMap<String, Double>();
				if(data.getGameType() == "Cycling"){
					reStartUse = "ran";
					String gameID = data.getCycling().getGameID();
					startCycling(gameID, result);
				}
				else if(data.getGameType() == "Running"){
					
				}
				else if(data.getGameType() == "Swimming"){
					
				}
				else{
					System.out.println("The game does not exist.");
					meanMenuControl();
				}
			} else {
				System.out.println("Would you like restart the game?(yes/no)");
				Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
				if(choice.equals("yes")){
					resetPoints();
					System.out.println("You should reset the prediction first!");
					reStartUse = null;
					predictMenuControl();
				}
				else if(choice.equals("no"))
					meanMenuControl();
				else{
					System.out.println("You entered wrong commond!");
					meanMenuControl();
				}
			}
			
		}
	}
	public void startCycling(String gameID, HashMap<String, Double> result){
		//CyclingGameParticipator cGP = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
		int athletesNumber = data.getCyclistInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getCyclistInGame().size();i++){
			Cyclist c = (Cyclist) data.getCyclistInGame().get(i);
			double time = c.compete(data.getGameType());
			String ID = c.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getCyclistInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		if(data.getCyclistList().get(winner) != null){
			Cyclist c1 = (Cyclist) data.getCyclistList().get(winner);
			c1.setPoint(5);
		}else{
			SuperAthletes sa1 = (SuperAthletes) data.getSuperAthletesList().get(winner);
			sa1.setPoint(5);
		}
		if(data.getCyclistList().get(second) != null){
			Cyclist c2 = (Cyclist) data.getCyclistList().get(second);
			c2.setPoint(2);
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(second);
			sa2.setPoint(2);
		}
		if(data.getCyclistList().get(third) != null){
			Cyclist c2 = (Cyclist) data.getCyclistList().get(third);
			c2.setPoint(1);
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(third);
			sa2.setPoint(1);
		}
//		setPoints(winner, second, third);
		meanMenuControl();
	}
	public void setPoints(String winner, String second, String third){
		if(data.getCyclistList().get(winner) != null){
			Cyclist c1 = (Cyclist) data.getCyclistList().get(winner);
			c1.setPoint(5);
		}else{
			SuperAthletes sa1 = (SuperAthletes) data.getSuperAthletesList().get(winner);
			sa1.setPoint(5);
		}
		if(data.getCyclistList().get(second) != null){
			Cyclist c2 = (Cyclist) data.getCyclistList().get(second);
			c2.setPoint(2);
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(second);
			sa2.setPoint(2);
		}
		if(data.getCyclistList().get(third) != null){
			Cyclist c2 = (Cyclist) data.getCyclistList().get(third);
			c2.setPoint(1);
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(third);
			sa2.setPoint(1);
		}
	}
	public void resetPoints(){
		if(data.getGameType() == "Cycling"){
			resetCyclistPoints();
		}
	}
	public void resetCyclistPoints(){
		data.getCycling().getGameID();
		HashMap<String, Double> reset = (HashMap<String, Double>) data.getResultList().get(data.getCycling().getGameID());
		Iterator iter = reset.entrySet().iterator();
		Double[] rank = new Double[reset.size()];
		int i = 0;
		while(iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			rank[i] = entry.getValue();
			i++;
		}
		Arrays.sort(rank);
		iter = reset.entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue() == rank[0] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-5);;
			}
			if(entry.getValue() == rank[1] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-2);;
			}
			if(entry.getValue() == rank[2] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-1);;
			}
			if(entry.getValue() == rank[0] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-5);;
			}
			if(entry.getValue() == rank[1] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-2);;
			}
			if(entry.getValue() == rank[2] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-1);;
			}
		}
	}
	
	
	public void desplayAllGameResults(){
		if(data.getResultList().size()!=0){
			Iterator iter = data.getResultList().entrySet().iterator();		
			while (iter.hasNext()){
				HashMap.Entry<String, HashMap<String, Double>> entry = (Entry<String, HashMap<String, Double>>)iter.next();
				printResults(entry.getKey());
			}
			meanMenuControl();
		} else {
			System.out.println("There are not any game has been finished!");
			meanMenuControl();
		}
	}
	
	public void printResults(String gameID){
		HashMap<String, Double> result = (HashMap<String, Double>) data.getResultList().get(gameID);
		Double[] rank = new Double[result.size()];
		int i = 0;
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			//System.out.println("ID" + entry.getKey() + "time" + entry.getValue());
			rank[i] = entry.getValue();
			i++;		
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null, referee;
		String winnerName = null, seconderName = null, thirderName = null, refereeName;
		iter = result.entrySet().iterator();
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(rank[0]==entry.getValue()){
				winner = entry.getKey();
			}
			if(rank[1]==entry.getValue()){
				second = entry.getKey();
			}
			if(rank[2]==entry.getValue()){
				third = entry.getKey();
			}
		}
		winnerName = getAthletesName(winner, winnerName);
		seconderName = getAthletesName(second, seconderName);
		thirderName = getAthletesName(third, thirderName);
		referee = data.getOfficial().getID();
		refereeName = data.getOfficial().getName();
		
		System.out.println("GameID:\t" + gameID);
		System.out.println("\tRefereeID:\t" + referee + "\tReferee's Name:\t" + refereeName);
		System.out.println("\tWinnerID:\t" + winner + "\tWinner's Name:\t" + winnerName + "\tResult:\t" + rank[0]);
		System.out.println("\tSeconderID:\t" + winner + "\tseconder's Name:" + seconderName + "\tResult:\t" + rank[1]);
		System.out.println("\tThirderID:\t" + winner + "\tthirder's Name:\t" + thirderName + "\tResult:\t" + rank[2]);
	}
	
	public String getAthletesName(String ID, String Name){
		if(data.getCyclistList().get(ID)!=null){
			Cyclist c = (Cyclist) data.getCyclistList().get(ID);
			Name = c.getName();
		} 
		else if(data.getSwimmerList().get(ID)!=null){
			Swimmer s = (Swimmer) data.getSwimmerList().get(ID);
			Name = s.getName();
		}
		else if(data.getsprinterList().get(ID)!=null){
			Sprinter r = (Sprinter) data.getsprinterList().get(ID);
			Name = r.getName();
		}
		else {
			SuperAthletes first = (SuperAthletes) data.getSuperAthletesList().get(ID);
			Name = first.getName();
		}
		return Name;
	}
	
	
	public void displayPointsOfAllAthletes(){
		//All cyclists points
		Iterator iter = data.getCyclistList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println("Cyclist ID : " + entry.getKey() + "\tCyclist Name : " 
					+ entry.getValue().getName() + "\tCyclist points : " + entry.getValue().getPoint());
		}
		//All swimmer points
		iter = data.getSwimmerList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Swimmer> entry = (Entry<String, Swimmer>)iter.next();
			System.out.println("Swimmer ID : " + entry.getKey() + "\tSwimmer Name : " 
					+ entry.getValue().getName() + "\tSwimmer points : " + entry.getValue().getPoint());
		}
		//All sprinter points
		iter = data.getsprinterList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Sprinter> entry = (Entry<String, Sprinter>)iter.next();
			System.out.println("Sprinter ID : " + entry.getKey() + "\tSprinter Name : " 
					+ entry.getValue().getName() + "\tSprinter points : " + entry.getValue().getPoint());
		}
		//all superathlete points
		iter = data.getSuperAthletesList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			System.out.println("SuperAthletes ID : " + entry.getKey() + "\tSuperAthletes Name : " 
					+ entry.getValue().getName() + "\tSuperAthletes points : " + entry.getValue().getPoint());
		}
		meanMenuControl();
	}
	
	
	
}
