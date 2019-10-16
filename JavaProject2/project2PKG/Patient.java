package project2PKG;
//
import java.util.ArrayList;

public class Patient<T> implements PatientADT{

	private String ID;
	private String NAME;
	private ArrayList<String> ACE = new ArrayList<String>(); 

	Patient(String id, String name){
		ID = id;
		NAME = name;
	}

	
	Patient(){
		ID = null;
		NAME = null;
	}


	public void setId(String id) {
		ID = id;
	}


	public String getId() {

		return ID;
	}


	public void setName(String name) {
		NAME = name;
	}


	public String getName() {

		return NAME;
	}


	public void addACE(String ace) {
		for(String s:ACE)
			if(s.equals(ace))
				return;

		ACE.add(ace);
	}


	public void removeACE(String ace) {
		ACE.remove(ace);
	}


	public ArrayList<String> getACEs() {
		return ACE;
	}

	
	public String toString() {
		String x = ACE.toString();
		return (NAME + "," + ID + ","+ x.replace("[", "").replace("]", "").replace(", ", ","));
	}

}
