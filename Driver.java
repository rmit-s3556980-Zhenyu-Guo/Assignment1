package Assignment1;

import java.util.*;
import java.util.Map.Entry;

public class Driver {
	//public HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	//public HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	//public HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	//public HashMap<String, Official> officialList = new HashMap<String, Official>();
	//public HashMap<String, SuperAthletes> superAthletesList = new HashMap<>();
	//public HashMap<String, RunningGameParticipator> runningGameList = new HashMap<String, RunningGameParticipator>();
	//public HashMap<String, CyclingGameParticipator> cyclingGameList = new HashMap<String, CyclingGameParticipator>();
	//public HashMap<String, SwimmingGameParticipator> swimmingGameList = new HashMap<String, SwimmingGameParticipator>();
	//All above HashMap are put in Data Class.
	
	
	
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
				Iterator iter = data.getCyclingGameList().entrySet().iterator();
				while(iter.hasNext()){
					HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
					System.out.println("game ID : " + entry.getKey());
					
					System.out.println("There are " + ((CyclingGameParticipator) data.getCyclingGameList().get(entry.getKey())).getOfficialInGame().size() + " official in this game");
					System.out.println("There are " + ((CyclingGameParticipator) data.getCyclingGameList().get(entry.getKey())).getCyclistInGame().size() + " cyclists in this game");
					System.out.println("There are " + ((CyclingGameParticipator) data.getCyclingGameList().get(entry.getKey())).getSuperAthletesInGame().size() + " superathletes in this game");
					Iterator it = data.getCyclingGameList().entrySet().iterator();
					while(it.hasNext()){
						HashMap.Entry<String, CyclingGameParticipator> en = (Entry<String, CyclingGameParticipator>)it.next();
						System.out.println("game ID : " + en.getKey() + "\tpredict : " 
								+ en.getValue().getCyclingGame().getPredict());
						
					}
					
				}
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
	
	
	public void gameMenuControl(){
		
		gameMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				String gameID = "C" + Integer.toString(cyclingGameNumber);
				cyclingGameNumber++;
				Cycling cy = new Cycling(gameID, "Cycling", false, null);
				
				ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				CyclingGameParticipator GP = new CyclingGameParticipator(officialInGame, cyclistInGame, superAthletesInGame, cy);
				data.getCyclingGameList().put(gameID, GP);
				cyclingMenuControl(gameID, GP);				
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
	public void cyclingMenuControl(String gameID, CyclingGameParticipator cyclingGP){
		
		cyclingMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = cyclingGP.getCyclistInGame().size() + cyclingGP.getSuperAthletesInGame().size();
			if(choice == 1){
				if(athletesNumber <= 7)
					cyclistMenuControl(gameID, cyclingGP);
				else {
					System.out.println("The game has 8 athletes already!");
					cyclingMenuControl(gameID, cyclingGP);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, cyclingGP);				
			}
			else if(choice == 3){
				if(athletesNumber >= 4 && athletesNumber <=8 && cyclingGP.getOfficialInGame().size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, cyclingGP);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						data.getCyclingGameList().remove(gameID);
						System.out.println("The game has been concled.");
						gameMenuControl();
					}
					else if(backOrNot.equals("no")){
						cyclingMenuControl(gameID, cyclingGP);
					}
					else {
						System.out.println("You enter a wrong commond.");
						cyclistMenuControl(gameID, cyclingGP);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				cyclingMenuControl(gameID, cyclingGP);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			cyclingMenuControl(gameID, cyclingGP);
		}
	}

	public void checkGameLimitation(String gameID, CyclingGameParticipator cyclingGP ){
		String reason ;
		int athletesNumber = cyclingGP.getCyclistInGame().size() + cyclingGP.getSuperAthletesInGame().size();
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
	//next method isn't used.
	public void supperAthletesMenuControl(String gameID, CyclingGameParticipator cyclingGP){
		int athletesNumber = cyclingGP.getCyclistInGame().size() + cyclingGP.getSuperAthletesInGame().size();
		//To check the athletes number in the game
		if(athletesNumber<=7){
		supperAthletesMenu();
		System.out.println("Please enter the athletes' ID: ");
		Scanner sc = new Scanner(System.in);
		String ID = sc.nextLine();
		//int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
		if(data.getSuperAthletesList().get(ID) != null && athletesNumber <= 7){
			cyclingGP.getSuperAthletesInGame().add(data.getSuperAthletesList().get(ID));
			System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
			String choose = sc.nextLine();
			if (choose.equals("yes")){
				supperAthletesMenuControl(gameID, cyclingGP);
			}
			else if(choose.equals("no")){
				cyclingMenuControl(gameID, cyclingGP);
			}
			else{
				System.out.println("You didn't input the right commond! Back to last menu");
				cyclingMenuControl(gameID, cyclingGP);
			}
		}else if(data.getSuperAthletesList().get(ID) == null ){
			System.out.println("You the athletes does not exist.");
			supperAthletesMenuControl(gameID, cyclingGP);
		}else if(athletesNumber == 8){
			System.out.println("The game has 8 athleres. You cannot add any more.");
			cyclingMenuControl(gameID, cyclingGP);
		}else {
			System.out.println("The commond cannot be recognized.");
			cyclingMenuControl(gameID, cyclingGP);
		}
		}else{
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, cyclingGP);
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
	public void cyclistMenuControl(String gameID, CyclingGameParticipator cyclingGP){
		int athletesNumber = cyclingGP.getCyclistInGame().size() + cyclingGP.getSuperAthletesInGame().size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			cyclistMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the cyclist is in the list and not in the game.
			if (data.getCyclistList().get(ID) != null && !cyclingGP.getCyclistInGame().contains(data.getCyclistList().get(ID))) {
				cyclingGP.getCyclistInGame().add(data.getCyclistList().get(ID));
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclingGP);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclingGP);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclingGP);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (data.getSuperAthletesList().get(ID) != null
					&& !cyclingGP.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(ID))) {
				cyclingGP.getSuperAthletesInGame().add(data.getSuperAthletesList().get(ID));
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclingGP);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclingGP);
				}
				else{
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclingGP);
				}
			} else if (data.getSuperAthletesList().get(ID) == null && data.getCyclistList().get(ID) == null) {
				System.out.println("The athlete does not exist!");
				cyclistMenuControl(gameID, cyclingGP);
			} else if (cyclingGP.getCyclistInGame().contains(data.getCyclistList().get(ID))
					|| cyclingGP.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				cyclistMenuControl(gameID, cyclingGP);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				cyclistMenuControl(gameID, cyclingGP);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, cyclingGP);
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
	public void officialMenuControl(String gameID, CyclingGameParticipator cyclingGP){
		//Firstly, check whether there is an officer in the game	
		if(cyclingGP.getOfficialInGame().size() != 0){
			System.out.println("The game has already have an official.");
			System.out.println("You cann't add any other official!");
			cyclingMenuControl(gameID, cyclingGP);
		}
		else{
			officialMenu();
			System.out.println("Please enter the official's ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			if(data.getOfficialList().get(ID) != null){
				cyclingGP.getOfficialInGame().add(data.getSuperAthletesList().get(ID));				
				System.out.println("Your choice is successfull!");
				
				cyclingMenuControl(gameID, cyclingGP);
			} 
			else {
				System.out.println("The official is not exist!");
				System.out.println("Pleas enter it again:");
				officialMenuControl(gameID, cyclingGP);
			}
		}
	}
//	public void officialMenuControl(String gameID, RunningGameParticipator rGP){
//		
//	}
//	public void officialMeunControl(String gameID, SwimmingGameParticipator sGP){
//		
//	}
	
	public void predictMenu(){
		//List all the cycling games
		System.out.println("We have these games: ");
		Iterator iter = data.getCyclingGameList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println("game ID : " + entry.getKey() );
		}
	}
	public void predictMenuControl(){
		int gameNumber = data.getCyclingGameList().size() + data.getRunningGameList().size() + data.getSwimmerList().size();
		if(gameNumber == 0){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			predictMenu();
			System.out.println("Please enter the game ID that you want to predict: ");
			Scanner sc = new Scanner(System.in);
			String gID = sc.nextLine();
			//check the game
			//then call that game's predict
			if(data.getCyclingGameList().get(gID) != null){
				predictCyclingGame(gID);
			}
			else if(data.getRunningGameList().get(gID) != null){
				
			}
			else if(data.getSwimmingGameList().get(gID) != null){
				
			}
			else{
				System.out.println("The game doesn't exist.");
				meanMenuControl();
			}
		}
	}
	
	public void predictCyclingGame(String gID){
		if(((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclingGame().getResult() == false){
			Scanner sc = new Scanner(System.in);
			if(((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclingGame().getPredict() == null){
				//print all the athletes in the game
				((CyclingGameParticipator) data.getCyclingGameList().get(gID)).printAthletes();
				//choose an athletes
				
				System.out.println("Please enter the Athlete's ID to predict the winner: ");
				String predict = sc.nextLine();
				if(((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclistInGame() != null || ((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getSuperAthletesInGame() != null){
					((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclingGame().setPredict(predict);
					meanMenuControl();
						
				}else{
					System.out.println("The athlete does not exist.");
					predictCyclingGame(gID);
				}
				
			}
			else if(((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclingGame().getPredict() != null){
				System.out.println("The game has been predict! Do you want to change your predict?(yes/no)");
				String choice = sc.nextLine();
				if(choice.equals("yes")){
					//print all the athletes in the game
					((CyclingGameParticipator) data.getCyclingGameList().get(gID)).printAthletes();
					//choose an athletes
					String input = "false";
					do{
						System.out.println("Please enter the Athlete's ID to predict the winner: ");
						String predict = sc.nextLine();
						if(((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclistInGame() != null || ((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getSuperAthletesInGame() != null){
							((CyclingGameParticipator) data.getCyclingGameList().get(gID)).getCyclingGame().setPredict(predict);
							input = "true";
						}
					}while(input.equals("true"));
				}
				else if(choice.equals("no")){
					meanMenuControl();
				}
				else{
					System.out.println("Wrong commond!");
					meanMenuControl();
				}
			}
		}
		else
			System.out.println("The game is finish. You cann't predict it.");
	}
	
	public void startTheGame(){
		int gameNumber = data.getCyclingGameList().size() + data.getRunningGameList().size() + data.getSwimmerList().size();
		if(gameNumber == 0){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			data.printGameList();
			System.out.println("Please choose a game to start.");
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the gameID: ");
			String gameID = sc.nextLine();
			HashMap<String, Double> result = new HashMap<String, Double>();
			if(data.getCyclingGameList().get(gameID) != null){
				startCycling(gameID, result);
			}
			else if(data.getRunningGameList().get(gameID) != null){
				
			}
			else if(data.getSwimmingGameList().get(gameID) != null){
				
			}
			else{
				System.out.println("The game does not exist.");
				meanMenuControl();
			}
			
		}
	}
	public void startCycling(String gameID, HashMap<String, Double> result){
		CyclingGameParticipator cGP = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
		int athletesNumber = cGP.getCyclistInGame().size() + cGP.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<cGP.getCyclistInGame().size();i++){
			Cyclist c = (Cyclist) cGP.getCyclistInGame().get(i);
			double time = c.compete(cGP.getCyclingGame().getGameType());
			String ID = c.getID();
			System.out.println("test\t" + time + "    " + ID);
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=cGP.getCyclistInGame().size();i<athletesNumber;i++){
			System.out.println("test" + cGP.getCyclingGame().getGameType());
			SuperAthletes s = (SuperAthletes) cGP.getSuperAthletesInGame().get(j);
			double time = s.compete(cGP.getCyclingGame().getGameType());
			String ID = s.getID();
			System.out.println("test\t" + time + "    " + ID);
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		System.out.println(rank[0]);
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
		CyclingGameParticipator cyclingGP = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
		if(cyclingGP.getCyclingGame().getPredict().equals(winner)){
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
	
	public void desplayAllGameResults(){
		if(data.getResultList().size()!=0){
			Iterator iter = data.getResultList().entrySet().iterator();		
			while (iter.hasNext()){
				HashMap.Entry<String, HashMap<String, Double>> entry = (Entry<String, HashMap<String, Double>>)iter.next();
				System.out.println("Test\t" + entry.getKey());
				printResults(entry.getKey());
			}
		} else {
			System.out.println("There are not any game has been finished!");
			meanMenuControl();
		}
	}
	
	public void printResults(String gameID){
		System.out.println("Test\t" + gameID);
		HashMap<String, Double> result = (HashMap<String, Double>) data.getResultList().get(gameID);
		Double[] rank = new Double[result.size()];
		int i = 0;
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			//System.out.println("ID" + entry.getKey() + "time" + entry.getValue());
			rank[i] = entry.getValue();
			System.out.println("test 1 \t" + rank[i]);
			i++;		
		}
		System.out.println("test2");
		Arrays.sort(rank);
		String winner = null, second = null, third = null, referee = null;
		String winnerName = null, seconderName = null, thirderName = null, refereeName = null;
		iter = result.entrySet().iterator();
		while (iter.hasNext()){
			System.out.println("test3");
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
		System.out.println("Test3" + winner + "\t" + winnerName);
		winnerName = getAthletesName(winner, winnerName);
		System.out.println("Test4" + winner + "\t" + winnerName);
		seconderName = getAthletesName(second, seconderName);
		thirderName = getAthletesName(third, thirderName);
//		referee = getOfficialDetails(gameID,referee);
//		System.out.println("Test5" + referee);
//		if(data.getCyclingGameList().get(gameID) != null){
//			System.out.println("Test5");
//			CyclingGameParticipator cgp = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
//			Official o = (Official) cgp.getOfficialInGame().get(0);
//			referee = o.getID();
//			refereeName = o.getName();
//			System.out.println("Test 6 : " + referee + "     " + refereeName);
//		}
//		else if(data.getSwimmingGameList().get(gameID) != null){
//			SwimmingGameParticipator sgp = (SwimmingGameParticipator) data.getSwimmingGameList().get(gameID);
//			Official o = (Official) sgp.getOfficialInGame().get(0);
//			referee = o.getID();
//			refereeName = o.getName();
//		} else {
//			RunningGameParticipator rgp = (RunningGameParticipator) data.getRunningGameList().get(gameID);
//			Official o = (Official) rgp.getOfficialInGame().get(0);
//			referee = o.getID();
//			refereeName = o.getName();
//		}
		System.out.println("GameID: " + gameID);
		CyclingGameParticipator cp = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
//		cp.printOfficial();
		System.out.println("RefereeID: " + referee + "Referee's Name: " + refereeName);
		System.out.println("WinnerID: " + winner + "Winner's Name: " + winnerName + "Result: " + rank[0]);
		System.out.println("SeconderID: " + winner + "seconder's Name: " + seconderName + "Result: " + rank[1]);
		System.out.println("ThirderID: " + winner + "thirder's Name: " + thirderName + "Result: " + rank[2]);
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
			SuperAthletes first = (SuperAthletes) data.getCyclistList().get(ID);
			Name = first.getName();
		}
		return Name;
	}
	
	
	public String getOfficialDetails(String gameID, String officialID){
		if(data.getCyclingGameList().get(gameID) != null){
			CyclingGameParticipator cgp = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
			Official o = (Official) cgp.getOfficialInGame().get(0);
			officialID = o.getID();
			String Name = o.getName();
		}
		else if(data.getSwimmingGameList().get(gameID) != null){
			SwimmingGameParticipator sgp = (SwimmingGameParticipator) data.getSwimmingGameList().get(gameID);
			Official o = (Official) sgp.getOfficialInGame().get(0);
			officialID = o.getID();
			String Name = o.getName();
		} else {
			RunningGameParticipator rgp = (RunningGameParticipator) data.getRunningGameList().get(gameID);
			Official o = (Official) rgp.getOfficialInGame().get(0);
			officialID = o.getID();
			String Name = o.getName();
		}
		return officialID;
	}
	
	public void displayPointsOfAllAthletes(){
		Iterator iter = data.getCyclistList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println("Cyclist ID : " + entry.getKey() + "\tCyclist Name : " 
					+ entry.getValue().getName() + "\tCyclist points : " + entry.getValue().getPoint());
		}
		iter = data.getSwimmerList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Swimmer> entry = (Entry<String, Swimmer>)iter.next();
			System.out.println("Swimmer ID : " + entry.getKey() + "\tSwimmer Name : " 
					+ entry.getValue().getName() + "\tSwimmer points : " + entry.getValue().getPoint());
		}
		iter = data.getsprinterList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Sprinter> entry = (Entry<String, Sprinter>)iter.next();
			System.out.println("Sprinter ID : " + entry.getKey() + "\tSprinter Name : " 
					+ entry.getValue().getName() + "\tSprinter points : " + entry.getValue().getPoint());
		}
		iter = data.getSuperAthletesList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			System.out.println("SuperAthletes ID : " + entry.getKey() + "\tSuperAthletes Name : " 
					+ entry.getValue().getName() + "\tSuperAthletes points : " + entry.getValue().getPoint());
		}
		meanMenuControl();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}



