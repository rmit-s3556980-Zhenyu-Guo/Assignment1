package Assignment1;

public class Running extends Game{
	private String gameID;
	private boolean result = false;
	private String gameType;
	private String predict;
	
	public Running(String gameID, String gameType, boolean result,String predict) {
		super(gameID, gameType, result, predict);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setGameID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkAthletes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkOfficial() {
		// TODO Auto-generated method stub
		return false;
	}

}
