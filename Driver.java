package Assignment1;

import java.util.*;
import java.util.Map.Entry;

public class Driver {
	public HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	public HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	public HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	public HashMap<String, Official> officialList = new HashMap<String, Official>();
	public HashMap superAthleteList = new HashMap<>();
	public HashMap<String, ArrayList> gameList= new HashMap<String, ArrayList>();
	
	
	public void Officer(){
		officialList.put("a1", new Official("a1", "bowen", "cc", "dd"));
		officialList.put("a2", new Official("a2", "cc", "cc", "dd"));
		officialList.put("a3", new Official("a3", "yu", "cc", "dd"));
		officialList.put("a4", new Official("a4", "elva", "cc", "dd"));
		officialList.put("a5", new Official("a5", "bb", "cc", "dd"));
		officialList.put("a6", new Official("a6", "ab", "cc", "dd"));		
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
					gameList.get(entry.getKey()).size();
					System.out.println("There are " + gameList.get(entry.getKey()).size() + "in this game");
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
	
	public void gameMenu(){
		System.out.println("Now please select a game.");
		System.out.println("================================");
		System.out.println("---1---Cycling------------------");
		System.out.println("---2---Running------------------");
		System.out.println("---3---Swimming-----------------");
		System.out.println("---4---Back to mean menu--------");
	}
	
	//these three vearable is used for gameID
	int CyclingGameNumber = 1;
	int RunningGameNumber = 1;
	int SwimmingGameNumber = 1;
	
	public void gameMenuControl(){
		
		
		gameMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				String gameID = "C" + Integer.toString(CyclingGameNumber);
				CyclingGameNumber++;
				Cycling cy = new Cycling(gameID, false);
				ArrayList CyclingList= new ArrayList();
				gameList.put(gameID, CyclingList);
				cyclingMenuControl(gameID, CyclingList);
			}
			else if(choice == 2){
				runningMenu();
				String gameID = "R" + Integer.toString(RunningGameNumber);
				System.out.println(gameID);
				RunningGameNumber++;
				ArrayList List= new ArrayList();
				gameList.put(gameID, List);
			}
			else if(choice == 3){
				swimmingMenu();
				String gameID = "S" + Integer.toString(SwimmingGameNumber);
				SwimmingGameNumber++;
				ArrayList List= new ArrayList();
				gameList.put(gameID, List);
			}
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
	public void cyclingMenuControl(String gameID, ArrayList list){
		
		cyclingMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				cyclistMenuControl(gameID, list);
			}
			else if(choice ==2){
				officialMenuControl(gameID, list);
			}
			else if(choice == 3){
				gameMenuControl();
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				cyclingMenuControl(gameID, list);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			cyclingMenuControl(gameID, list);
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
	
	public void runnerMenu(){
		
	}	
	public void swimmerMenu(){
		
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
	public void  cyclistMenuControl(String gameID, ArrayList list){
		cyclistMenu();
		System.out.println("Please enter the athletes' ID: ");
		Scanner sc = new Scanner(System.in);
		String ID = sc.nextLine();
		if(cyclistList.get(ID) != null){
			list.add(cyclistList.get(ID));
			System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
			String choose = sc.nextLine();
			if (choose.equals("yes")){
				cyclistMenuControl(gameID, list);
			}
			else if(choose.equals("no")){
				cyclingMenuControl(gameID, list);
			}
			else{
				System.out.println("You didn't input the right commond! Back to last menu");
				cyclingMenuControl(gameID, list);
			}
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
		
		//To choose an official
		System.out.println("Input the officialID to choose an official:");
		Scanner sc = new Scanner(System.in);
		String ID = sc.nextLine();
		officialList.get(ID).getName();
		System.out.println("You choose " +officialList.get(ID).getName() + " successfully");
		
	}
	public void officialMenuControl(String gameID, ArrayList list){
		officialMenu();
	}
	
}
