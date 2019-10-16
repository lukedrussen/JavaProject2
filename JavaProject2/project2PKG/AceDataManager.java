package project2PKG;
//
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class AceDataManager<T> implements AceDataManagerADT {

	private ArrayList<PatientADT> Patients = new ArrayList<PatientADT>();
	private ArrayList<String> Risks = new ArrayList<String>();
	private ArrayList<String> IDS = new ArrayList<String>();


	public void addPatient(PatientADT p) {
		Patients.add(p);
	}


	public PatientADT getPatient(String id) {
		for(PatientADT s:Patients)
			if(s.getId().equals(id))
				return s;


		return null;
	}




	public ArrayList<String> getRiskFactors(ArrayList<String> aces) {
		ArrayList<String> riskfactors = new ArrayList<String>();
		if(aces.contains("Physical abuse"))
		{
			riskfactors.add("Potential risk of substance abuse and/or aggressive behavior from Physical abuse");
		}
		if(aces.contains("Sexual abuse"))
		{
			riskfactors.add("Potential risk of personality disorder, mood disorder and/or anxiety disorder from Sexual abuse");
		}
		if(aces.contains("Emotional abuse"))
		{
			riskfactors.add("Potential risk of substance abuse, mood disorder and/or anxiety disorder from Emotional abuse");
		}
		if(aces.contains("Physical neglect"))
		{
			riskfactors.add("Potential risk of substance abuse and/or chronic diseases from Physical neglect");
		}
		if(aces.contains("Emotional neglect"))
		{
			riskfactors.add("Potential risk of substance abuse, mood disorder and/or anxiety disorder from Emotional neglect");
		}
		if(aces.contains("Exposure to domestic violence"))
		{
			riskfactors.add("Potential risk of substance abuse, mood disorder, anxiety disorder, and/or aggressive behavior from Exposure to domestic violence");
		}
		if(aces.contains("Household substance abuse"))
		{
			riskfactors.add("Potential risk of chronic diseases, substance abuse and/or mood disorder from Household substance abuse exposure");
		}
		if(aces.contains("Household mental illness"))
		{
			riskfactors.add("Potential risk of mood disorder and/or chronic diseases from Household mental illness");
		}
		if(aces.contains("Parental separation"))
		{
			riskfactors.add("Potential risk of chronic diseases, substance abuse, mood disorder and/or anxiety disorder from Parental separation");
		}
		if(aces.contains("Incarcerated household member"))
		{
			riskfactors.add("Potential risk of substance abuse, mood disorder, and/or chronic diseases from Incarcerated household member");
		}
		//Judges severity of symptoms based on quantity of aces
		if(riskfactors.size() < 2)
		{
			riskfactors.add("Low range of symptom severity. Suggest short-term individual therapy.");
			return riskfactors;
		}
		if(riskfactors.size() < 6)
		{
			riskfactors.add("Medium range of symptom severity. Suggest treatment plan, group therapy, and individual thearpy.");
			return riskfactors;
		}
		riskfactors.add("High range of symptom severity. Suggest multidisciplinary team and adminstration to medical institution for intensive care.");
		return riskfactors;

	}


	public void writeToFile() throws IOException {
		//Found on Stack Overflow
		FileWriter writer = new FileWriter("output.txt"); 

		for(PatientADT s: Patients) {
			writer.write(s + System.lineSeparator());
		}
		writer.close();

	}
	
	public ArrayList getIDs() {
		for(PatientADT s: Patients) {
			IDS.add(s.getId());
		}
		return IDS;
	}


	public void writeToFile(String fn) throws IOException {
		//Found On Stack Overflow
		FileWriter writer = new FileWriter(fn); 

		for(PatientADT s: Patients) {
			writer.write(s + System.lineSeparator());
		}
		writer.close();

	}

	public String toString() {
		String x = "";
		for(PatientADT s:Patients) {
			x += s + "\n"; 
		}
		return x;	
	}


	@Override
	public void readFile(String fn){
		BufferedReader lineReader = null;

		try {			

			lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(fn), Charset.forName("UTF-8")));  

			String line = null;
			while ((line = lineReader.readLine())!=null) {

				String[] tokens = line.split(",");
				String name = tokens[0];
				String id = tokens[1];

				PatientADT p = new Patient(id,name);

				for(int i = 2; i<tokens.length; i++) {
					p.addACE(tokens[i]);
				}

				addPatient(p);


			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file.  either no such file or format error");
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}
}
