package Assignment1;

public abstract class Game {
	private String gameID;
	private boolean result = false;
	
	public Game(String gameID, boolean result){
		this.gameID = gameID;
		this.result = result;
	}
	
	public String getGameID(){
		return gameID;
	}
	
	public void setResult(){
		result = true;
	}
	
	public abstract void setGameID();
	
	public abstract boolean checkAthletes();
	
	public abstract boolean checkOfficial();
	
}
