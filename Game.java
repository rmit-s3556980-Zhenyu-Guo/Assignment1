package Assignment1;

public abstract class Game {
	private String gameID;
	
	public Game(String gameID){
		this.gameID = gameID;
	}
	
	public String getGameID(){
		return gameID;
	}
	
	public abstract void setGameID();
	
	public abstract boolean checkAthletes();
	
	public abstract boolean checkOfficial();
	
}
