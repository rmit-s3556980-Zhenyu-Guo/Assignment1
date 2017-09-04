package Assignment1;

import java.util.ArrayList;
import java.util.*;
public class SwimmingGameParticipator {
	ArrayList<Official> OfficialInGame;
	ArrayList<Cyclist> SwimmerInGame;
	ArrayList<SuperAthletes> SuperAthletesInGame;
	
	public SwimmingGameParticipator(ArrayList<Official> OfficialInGame, ArrayList<Cyclist> SwimmerInGame, 
				ArrayList<SuperAthletes> SuperAthletesInGame){
		this.OfficialInGame = OfficialInGame;
		this.SwimmerInGame = SwimmerInGame;
		this.SuperAthletesInGame = SuperAthletesInGame;
	}
	
	public ArrayList getOfficialInGame(){
		return OfficialInGame;
	}
	public ArrayList getCyclistInGame(){
		return SwimmerInGame;
	}
	public ArrayList getSuperAthletesInGame(){
		return SuperAthletesInGame;
	}
	public void printAthletes(){
		if(SwimmerInGame.size()!=0){
			for(int i=0; i<SwimmerInGame.size();i++){
				System.out.println("Athlete's ID: " + SwimmerInGame.get(i).getID() + "\tAthletet's name: " + SwimmerInGame.get(i).getName());
			}
		}
		if(SuperAthletesInGame.size()!=0){
			for(int i=0; i<SuperAthletesInGame.size();i++){
				System.out.println("Athlete's ID: " + SuperAthletesInGame.get(i).getID() + "\tAthletet's name: " + SuperAthletesInGame.get(i).getName());
			}
		}
	}

}
