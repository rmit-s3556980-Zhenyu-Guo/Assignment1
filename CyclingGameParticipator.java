package Assignment1;

import java.util.*;
import java.util.Map.Entry;
public class CyclingGameParticipator {
	private ArrayList<Official> OfficialInGame;
	private ArrayList<Cyclist> CyclistInGame;
	private ArrayList<SuperAthletes> SuperAthletesInGame;
	private Cycling c;
	
	public CyclingGameParticipator(ArrayList<Official> OfficialInGame, ArrayList<Cyclist> CyclistInGame, 
				ArrayList<SuperAthletes> SuperAthletesInGame, Cycling c){
		this.OfficialInGame = OfficialInGame;
		this.CyclistInGame = CyclistInGame;
		this.SuperAthletesInGame = SuperAthletesInGame;
		this.c = c;
	}
	
	public ArrayList getOfficialInGame(){
		return OfficialInGame;
	}
	public ArrayList getCyclistInGame(){
		return CyclistInGame;
	}
	public ArrayList getSuperAthletesInGame(){
		return SuperAthletesInGame;
	}
	public Cycling getCyclingGame(){
		return c;
	}
	public void printAthletes(){
		if(CyclistInGame.size()!=0){
			for(int i=0; i<CyclistInGame.size();i++){
				System.out.println("Athlete's ID: " + CyclistInGame.get(i).getID() + "\tAthletet's name: " + CyclistInGame.get(i).getName());
			}
		}
		if(SuperAthletesInGame.size()!=0){
			for(int i=0; i<SuperAthletesInGame.size();i++){
				System.out.println("Athlete's ID: " + SuperAthletesInGame.get(i).getID() + "\tAthletet's name: " + SuperAthletesInGame.get(i).getName());
			}
		}
	}

}
