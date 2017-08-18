package Assignment1;
import java.util.*;
public class RunningGameParticipator {
	ArrayList<Official> OfficialInGame;
	ArrayList<Cyclist> CyclistInGame;
	ArrayList<SuperAthletes> SuperAthletesInGame;
	
	public RunningGameParticipator(ArrayList<Official> OfficialInGame, ArrayList<Cyclist> CyclistInGame, 
				ArrayList<SuperAthletes> SuperAthletesInGame){
		this.OfficialInGame = OfficialInGame;
		this.CyclistInGame = CyclistInGame;
		this.SuperAthletesInGame = SuperAthletesInGame;
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
	
}
