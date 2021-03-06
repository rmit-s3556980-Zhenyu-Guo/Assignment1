package Assignment1;
import java.util.*;
public class RunningGameParticipator {
	ArrayList<Official> OfficialInGame;
	ArrayList<Cyclist> SprinterInGame;
	ArrayList<SuperAthletes> SuperAthletesInGame;
	
	public RunningGameParticipator(ArrayList<Official> OfficialInGame, ArrayList<Cyclist> SprinterInGame, 
				ArrayList<SuperAthletes> SuperAthletesInGame){
		this.OfficialInGame = OfficialInGame;
		this.SprinterInGame = SprinterInGame;
		this.SuperAthletesInGame = SuperAthletesInGame;
	}
	
	public ArrayList getOfficialInGame(){
		return OfficialInGame;
	}
	public ArrayList getCyclistInGame(){
		return SprinterInGame;
	}
	public ArrayList getSuperAthletesInGame(){
		return SuperAthletesInGame;
	}
	public void printAthletes(){
		if(SprinterInGame.size()!=0){
			for(int i=0; i<SprinterInGame.size();i++){
				System.out.println("Athlete's ID: " + SprinterInGame.get(i).getID() + "\tAthletet's name: " + SprinterInGame.get(i).getName());
			}
		}
		if(SuperAthletesInGame.size()!=0){
			for(int i=0; i<SuperAthletesInGame.size();i++){
				System.out.println("Athlete's ID: " + SuperAthletesInGame.get(i).getID() + "\tAthletet's name: " + SuperAthletesInGame.get(i).getName());
			}
		}
	}
	
}
