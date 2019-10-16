package project2PKG;
import java.io.IOException;
import java.util.ArrayList;
//
public interface AceDataManagerADT {
	public void addPatient (PatientADT p); //Adds a new patient to the data set
	public PatientADT getPatient (String id); //returns the patient with the given identifier, null if the patient is not in the data set
	public ArrayList<String> getRiskFactors (ArrayList<String> aces); // returns an arraylist containing all of the risk factors associated with the input list of ACEs
	public void writeToFile () throws IOException; // write to the file set during instantiation
	public void writeToFile (String fn) throws IOException; // write to the file indicated in parameter
	public void readFile (String fn);//Reads text file
	public String toString(); //Returns a string representation of the ACE patient and risk factors data manager
	public ArrayList<String> getIDs();
	public void removePatient(PatientADT p);
}