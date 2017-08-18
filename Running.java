package Assignment1;

public class Running extends Game{
	private String gameID;
	private boolean result = false;
	private String gameType;
	
	public Running(String gameID, String gameType, boolean result) {
		super(gameID, gameType, result);
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
