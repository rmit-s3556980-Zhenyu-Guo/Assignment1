package Assignment1;

import java.util.*;
import java.util.Map.Entry;

public class Driver {
	public HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	public HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	public HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	public HashMap<String, Official> officialList = new HashMap<String, Official>();
	public HashMap<String, SuperAthletes> superAthletesList = new HashMap<>();
	public HashMap<String, RunningGameParticipator> gameList= new HashMap<String, RunningGameParticipator>();
	
	
	public void Officer(){
		officialList.put("a1", new Official("a1", "bowen", "cc", "dd"));
		officialList.put("a2", new Official("a2", "cc", "cc", "dd"));
		officialList.put("a3", new Official("a3", "yu", "cc", "dd"));
		officialList.put("a4", new Official("a4", "elva", "cc", "dd"));
		officialList.put("a5", new Official("a5", "bb", "cc", "dd"));
		officialList.put("a6", new Official("a6", "ab", "cc", "dd"));		
	}
	public void SuperAthletes(){
		superAthletesList.put("SA01", new SuperAthletes("sa1", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA02", new SuperAthletes("sa2", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA03", new SuperAthletes("sa3", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA04", new SuperAthletes("sa4", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA05", new SuperAthletes("sa5", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA06", new SuperAthletes("sa6", "ds", "asdff", "fa", 0));
	}
	public void Cyclist(){
		cyclistList.put("c1", new Cyclist("cc1", "bq", "ff", "aa", 0));
		cyclistList.put("c2", new Cyclist("cc2", "bq", "ff", "aa", 0));
		cyclistList.put("c3", new Cyclist("cc3", "bq", "ff", "aa", 0));
		cyclistList.put("c4", new Cyclist("cc4", "bq", "ff", "aa", 0));
		cyclistList.put("c5", new Cyclist("cc5", "bq", "ff", "aa", 0));
		cyclistList.put("c6", new Cyclist("cc6", "bq", "ff", "aa", 0));
		cyclistList.put("c7", new Cyclist("cc7", "bq", "ff", "aa", 0));
	}
	
	//the first layer
	public void meanMenu(){
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
				Iterator iter = gameList.entrySet().iterator();
				while(iter.hasNext()){
					HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
					System.out.println("game ID : " + entry.getKey());
					
					System.out.println("There are " + gameList.get(entry.getKey()).getOfficialInGame().size() + " official in this game");
					System.out.println("There are " + gameList.get(entry.getKey()).getCyclistInGame().size() + " cyclists in this game");
					System.out.println("There are " + gameList.get(entry.getKey()).getSuperAthletesInGame().size() + " superathletes in this game");
				}
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
	private int CyclingGameNumber = 1;
	private int RunningGameNumber = 1;
	private int SwimmingGameNumber = 1;
	
	
	public void gameMenuControl(){
		
		gameMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				String gameID = "C" + Integer.toString(CyclingGameNumber);
				CyclingGameNumber++;
				Cycling cy = new Cycling(gameID, "Cycling", false);
				
				ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				RunningGameParticipator GP = new RunningGameParticipator(officialInGame, cyclistInGame, superAthletesInGame);
				gameList.put(gameID, GP);
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
	public void cyclingMenuControl(String gameID, RunningGameParticipator GP){
		
		cyclingMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
			if(choice == 1){
				if(athletesNumber <= 7)
					cyclistMenuControl(gameID, GP);
				else {
					System.out.println("The game has 8 athletes already!");
					cyclingMenuControl(gameID, GP);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, GP);				
			}
			else if(choice == 3){
				if(athletesNumber >= 4 && athletesNumber <=8 && GP.getOfficialInGame().size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, GP);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						gameList.remove(gameID);
						System.out.println("The game has been concled.");
					}
					else if(backOrNot.equals("no")){
						cyclingMenuControl(gameID, GP);
					}
					else {
						System.out.println("You enter a wrong commond.");
						cyclistMenuControl(gameID, GP);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				cyclingMenuControl(gameID, GP);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			cyclingMenuControl(gameID, GP);
		}
	}

	public void checkGameLimitation(String gameID, RunningGameParticipator GP){
		String reason ;
		int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
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
		Iterator iter = superAthletesList.entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			System.out.println(saNumber + ". superathlete ID : " + entry.getKey() + "\tsuperathlete Name : " 
					+ entry.getValue().getName());
			saNumber++;
		}
	}
	//next method isn't used.
	public void supperAthletesMenuControl(String gameID, RunningGameParticipator GP){
		int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
		//To check the athletes number in the game
		if(athletesNumber<=7){
		supperAthletesMenu();
		System.out.println("Please enter the athletes' ID: ");
		Scanner sc = new Scanner(System.in);
		String ID = sc.nextLine();
		//int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
		if(superAthletesList.get(ID) != null && athletesNumber <= 7){
			GP.getSuperAthletesInGame().add(superAthletesList.get(ID));
			System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
			String choose = sc.nextLine();
			if (choose.equals("yes")){
				supperAthletesMenuControl(gameID, GP);
			}
			else if(choose.equals("no")){
				cyclingMenuControl(gameID, GP);
			}
			else{
				System.out.println("You didn't input the right commond! Back to last menu");
				cyclingMenuControl(gameID, GP);
			}
		}else if(superAthletesList.get(ID) == null ){
			System.out.println("You the athletes does not exist.");
			supperAthletesMenuControl(gameID, GP);
		}else if(athletesNumber == 8){
			System.out.println("The game has 8 athleres. You cannot add any more.");
			cyclingMenuControl(gameID, GP);
		}else {
			System.out.println("The commond cannot be recognized.");
			cyclingMenuControl(gameID, GP);
		}
		}else{
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, GP);
		}
	}
	
	public void cyclistMenu(){
		int cyNumber = 1;		
		
		System.out.println("Now, we have these cyclists :");
		
		//To print all the cyclists in the list
		Iterator iter = cyclistList.entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println(cyNumber + ". cyclist ID : " + entry.getKey() + "\tcyclist Name : " 
					+ entry.getValue().getName());
			cyNumber++;
		}
	}
	public void cyclistMenuControl(String gameID, RunningGameParticipator GP){
		int athletesNumber = GP.getCyclistInGame().size() + GP.getSuperAthletesInGame().size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			cyclistMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the cyclist is in the list and not in the game.
			if (cyclistList.get(ID) != null && !GP.getCyclistInGame().contains(cyclistList.get(ID))) {
				GP.getCyclistInGame().add(cyclistList.get(ID));
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, GP);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, GP);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, GP);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (superAthletesList.get(ID) != null
					&& !GP.getSuperAthletesInGame().contains(superAthletesList.get(ID))) {
				GP.getSuperAthletesInGame().add(superAthletesList.get(ID));
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, GP);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, GP);
				}
			} else if (superAthletesList.get(ID) == null && cyclistList.get(ID) == null) {
				System.out.println("The athlete does not exist!");
				cyclistMenuControl(gameID, GP);
			} else if (GP.getCyclistInGame().contains(cyclistList.get(ID))
					|| GP.getSuperAthletesInGame().contains(superAthletesList.get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				cyclistMenuControl(gameID, GP);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				cyclistMenuControl(gameID, GP);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, GP);
		}
	}

	public void officialMenu(){
		int ocNumber = 1;
		
		System.out.println("Now, we have these official officers:");
		
		//To print all the official in the list
		Iterator iter = officialList.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Official> entry = (Entry<String, Official>)iter.next();
			System.out.println(ocNumber + ". official ID : " + entry.getKey() + "\tofficial Name : " 
					+ entry.getValue().getName());
			ocNumber++;
		}
	}
	public void officialMenuControl(String gameID, RunningGameParticipator GP){
		//Firstly, check whether there is an officer in the game	
		if(GP.getOfficialInGame().size() != 0){
			System.out.println("The game has already have an official.");
			System.out.println("You cann't add any other official!");
			cyclingMenuControl(gameID, GP);
		}
		else{
			officialMenu();
			System.out.println("Please enter the official's ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			if(officialList.get(ID) != null){
				GP.getOfficialInGame().add(superAthletesList.get(ID));				
				System.out.println("Your choice is successfull!");
				cyclingMenuControl(gameID, GP);
			} 
			else {
				System.out.println("The official is not exist!");
				System.out.println("Pleas enter it again:");
				officialMenuControl(gameID, GP);
			}
		}
	}
	
}
