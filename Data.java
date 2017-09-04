package Assignment1;

import java.util.*;
import java.util.Map.Entry;

public class Data {
	private HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	private HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	private HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	private HashMap<String, Official> officialList = new HashMap<String, Official>();
	private HashMap<String, SuperAthletes> superAthletesList = new HashMap<>();
	private HashMap<String, RunningGameParticipator> runningGameList = new HashMap<String, RunningGameParticipator>();
	private HashMap<String, CyclingGameParticipator> cyclingGameList = new HashMap<String, CyclingGameParticipator>();
	private HashMap<String, SwimmingGameParticipator> swimmingGameList = new HashMap<String, SwimmingGameParticipator>();
	private HashMap<String, HashMap<String, Double>> resultList = new HashMap<String, HashMap<String, Double>>();
	
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
		cyclistList.put("c1", new Cyclist("c1", "bq", "ff", "aa", 0));
		cyclistList.put("c2", new Cyclist("c2", "bq", "ff", "aa", 0));
		cyclistList.put("c3", new Cyclist("c3", "bq", "ff", "aa", 0));
		cyclistList.put("c4", new Cyclist("c4", "bq", "ff", "aa", 0));
		cyclistList.put("c5", new Cyclist("c5", "bq", "ff", "aa", 0));
		cyclistList.put("c6", new Cyclist("c6", "bq", "ff", "aa", 0));
		cyclistList.put("c7", new Cyclist("c7", "bq", "ff", "aa", 0));
		
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
	public HashMap getRunningGameList(){
		return runningGameList;
	}
	public HashMap getCyclingGameList(){
		return cyclingGameList;
	}
	public HashMap getSwimmingGameList(){
		return swimmingGameList;
	}
	public HashMap getResultList(){
		return resultList;
	}
	
	public void printGameList(){
		Iterator iter = cyclingGameList.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, CyclingGameParticipator> entry = (Entry<String, CyclingGameParticipator>)iter.next();
			System.out.println("Game ID : " + entry.getKey());
		}
		iter = swimmingGameList.entrySet().iterator();
		while (iter.hasNext()){
			HashMap.Entry<String, SwimmingGameParticipator> entry = (Entry<String, SwimmingGameParticipator>)iter.next();
			System.out.println("Game ID : " + entry.getKey());
		}
		iter = runningGameList.entrySet().iterator();
		while (iter.hasNext()){
			HashMap.Entry<String, RunningGameParticipator> entry = (Entry<String, RunningGameParticipator>)iter.next();
			System.out.println("Game ID : " + entry.getKey());
		}
	}

	
}
