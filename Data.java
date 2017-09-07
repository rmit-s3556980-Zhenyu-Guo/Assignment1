import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Data {

	private HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	private HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	private HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	private HashMap<String, Official> officialList = new HashMap<String, Official>();
	private HashMap<String, SuperAthletes> superAthletesList = new HashMap<>();
	private HashMap<String, HashMap<String, Double>> resultList = new HashMap<String, HashMap<String, Double>>();
	
	private ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
	private ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
	private ArrayList<Swimmer> swimmerInGame = new ArrayList<Swimmer>();
	private ArrayList<Sprinter> runnerInGame = new ArrayList<Sprinter>();
	
	private Swimming s;
	private Running r;
	private Cycling c;
	private Official o;
	
	private String gameType;
	private String pridict;
	
	
	public void Officer(){
		officialList.put("a1", new Official("a1", "bowen", "cc", "dd"));
		officialList.put("a2", new Official("a2", "cc", "cc", "dd"));
		officialList.put("a3", new Official("a3", "yu", "cc", "dd"));
		officialList.put("a4", new Official("a4", "elva", "cc", "dd"));
		officialList.put("a5", new Official("a5", "bb", "cc", "dd"));
		officialList.put("a6", new Official("a6", "ab", "cc", "dd"));		
	}
	public void SuperAthletes(){
		superAthletesList.put("SA01", new SuperAthletes("SA01", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA02", new SuperAthletes("SA02", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA03", new SuperAthletes("SA03", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA04", new SuperAthletes("SA04", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA05", new SuperAthletes("SA05", "ds", "asdff", "fa", 0));
		superAthletesList.put("SA06", new SuperAthletes("SA06", "ds", "asdff", "fa", 0));
	}
	public void Cyclist(){
		cyclistList.put("c1", new Cyclist("c1", "1", "ff", "aa", 0));
		cyclistList.put("c2", new Cyclist("c2", "2", "ff", "aa", 0));
		cyclistList.put("c3", new Cyclist("c3", "3", "ff", "aa", 0));
		cyclistList.put("c4", new Cyclist("c4", "4", "ff", "aa", 0));
		cyclistList.put("c5", new Cyclist("c5", "5", "ff", "aa", 0));
		cyclistList.put("c6", new Cyclist("c6", "6", "ff", "aa", 0));
		cyclistList.put("c7", new Cyclist("c7", "7", "ff", "aa", 0));
		
	}
	public void Sprinter(){
		sprinterList.put("r1", new Sprinter("r1", "1", "ff", "aa", 0));
		sprinterList.put("r2", new Sprinter("r2", "2", "ff", "aa", 0));
		sprinterList.put("r3", new Sprinter("r3", "3", "ff", "aa", 0));
		sprinterList.put("r4", new Sprinter("r4", "4", "ff", "aa", 0));
		sprinterList.put("r5", new Sprinter("r5", "5", "ff", "aa", 0));
		sprinterList.put("r6", new Sprinter("r6", "6", "ff", "aa", 0));
		sprinterList.put("r7", new Sprinter("r7", "7", "ff", "aa", 0));
		sprinterList.put("r8", new Sprinter("r8", "8", "ff", "aa", 0));
		sprinterList.put("r9", new Sprinter("r9", "9", "ff", "aa", 0));
	}
	
	public Swimming getSwimming(){
		return s;
	}
	public Running getRunning(){
		return r;
	}
	public Cycling getCycling(){
		return c;
	}
	public Official getOfficial(){
		return o;
	}
	public String getGameType(){
		return gameType;
	}
	public String getPredict(){
		return pridict;
	}
	
	public void setSwimming(Swimming s){
		this.s = s;
	}
	public void setRunning(Running r){
		this.r = r;
	}
	public void setCycling(Cycling c){
		this.c = c;
	}
	public void setOfficial(Official o){
		this.o = o;
	}
	public void setGameType(String sGT){
		gameType = sGT;
	}
	public void setPredict(String pridict){
		this.pridict = pridict;
	}
	
	public void setcyclistInGame(ArrayList<Cyclist> cIG){
		cyclistInGame = cIG ;
	}
	public void setsuperAthletesInGame(ArrayList<SuperAthletes> saIG){
		superAthletesInGame = saIG;
	}
	public void setSwimmerInGame(ArrayList<Swimmer> sIG){
		swimmerInGame = sIG;
	}
	public void setRunnerInGame(ArrayList<Sprinter> rIG){
		runnerInGame = rIG;
	}
	
	public ArrayList getCyclistInGame(){
		return cyclistInGame;
	}
	public ArrayList getSuperAthletesInGame(){
		return superAthletesInGame;
	}
	public ArrayList getSwimmerInGame(){
		return swimmerInGame;
	}
	public ArrayList getRunnerInGame(){
		return runnerInGame;
	}
	
	public HashMap getsprinterList(){
		return sprinterList;
	}
	public HashMap getSwimmerList(){
		return swimmerList;
	}
	public HashMap getCyclistList(){
		return cyclistList;
	}
	public HashMap getOfficialList(){
		return officialList;
	}
	public HashMap getSuperAthletesList(){
		return superAthletesList;
	}
	public HashMap getResultList(){
		return resultList;
	}
	
	public void printCyclistInGame(){
		for(int i = 0; i < cyclistInGame.size(); i++){
			System.out.println("Cyclist ID: \t" + cyclistInGame.get(i).getID());
		}
	}
	public void printSuperAthletesInGame(){
		for(int i = 0; i < superAthletesInGame.size(); i++){
			System.out.println("Cyclist ID: \t" + superAthletesInGame.get(i).getID());
		}
	}
	public void printSwimmerInGame(){
		for(int i = 0; i < swimmerInGame.size(); i++){
			System.out.println("Cyclist ID: \t" + swimmerInGame.get(i).getID());
		}
	}
	public void printRunnerInGame(){
		for(int i = 0; i < runnerInGame.size(); i++){
			System.out.println("Cyclist ID: \t" + runnerInGame.get(i).getID());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
