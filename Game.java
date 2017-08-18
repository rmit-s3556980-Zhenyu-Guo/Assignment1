package Assignment1;

public abstract class Game {
	private String gameID;
	private boolean result = false;
	private String gameType;
	
	public Game(String gameID, String gameType, boolean result){
		this.gameID = gameID;
		this.result = result;
		this.gameType = gameType;
	}
	
	public String getGameID(){
		return gameID;
	}
	
	public String getGameType(){
		return gameType;
	}
	
	public void setResult(){
		result = true;
	}
	
	public abstract void setGameID();
	
	public abstract boolean checkAthletes();
	
	public abstract boolean checkOfficial();
	
}
