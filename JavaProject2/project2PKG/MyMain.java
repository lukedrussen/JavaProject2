package project2PKG;
//
import java.io.IOException;

public class MyMain {

	public static void main(String[] args) throws IOException {
		PatientADT p1 = new Patient<String>();
		PatientADT temp = new Patient<String>();
		AceDataManagerADT myData = new AceDataManager<PatientADT>();
		AceDataManagerADT test = new AceDataManager<PatientADT>();
		
		p1.setId("123");
		p1.setName("Luke");
		p1.addACE("1");
		p1.addACE("12");
		p1.addACE("123");
		p1.addACE("1234");
		
		//System.out.println(p1.getACEs());
		
		//myData.addPatient(p1);
		//System.out.println(myData);
		
		//System.out.println(p1.getId()); 
		
		PatientADT p2 = new Patient<String>();
		PatientADT p3 = new Patient<String>();
		p2.setId("976");
		p2.setName("John");
		
		p3.setId("100");
		p3.setName("Al");
		
		
		myData.addPatient(p1);
		myData.addPatient(p2);
		myData.addPatient(p3);
		System.out.println(myData);
		
		temp = myData.getPatient("100");
		temp.addACE("Cool Thing");
		temp.addACE("Cool");
		temp.addACE("Thing");
		System.out.println(myData);
		
		System.out.println(myData.getRiskFactors(p1.getACEs()));
		test.readFile("output.txt");
		temp = test.getPatient("123");
		temp.addACE("999");
		System.out.println("Test:");
		System.out.println(test);
		
		myData.writeToFile();
		

	}

}
