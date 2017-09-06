
public class Swimming extends Game{

	private String gameID;
	private boolean result = false;
	private String gameType;
	private String predict;
	
	public Swimming(String gameID, String gameType, boolean result, String predict) {
		super(gameID, gameType, result, predict);
		
	}

	@Override
	public void setGameID(String gameID) {
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
