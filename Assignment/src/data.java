import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class data {
	
	
	//Variables are created here which will hold the probability (p) of a certain case.
	//pHotPositive holds the probability of being hot and testing positive for the virus
	//pHotNegative holds the probability of being hot and testing negative for the virus.
	//these variables are made public static so other classes have access to them.
	
	
	//The counter is used further on to organise the data into the seperate arraylists
	//which are also created here.Each list will simply hold if a certain patient has
	//a cough/aches/sore throat etc  or doesn't. Another list (corona) holds if that same patient does
	//or does not have the virus.
	
	
	public static float pHotPositive  ,pHotNegative  ,pColdPositive  ,pColdNegative  ,pCoolPositive  ,pCoolNegative  ,pNormalPositive  ,pNormalNegative;
	public static float pAchesPositive ,pAchesNegative ,pNoAchesPositive ,pNoAchesNegative;
	public static float pCoughPositive  ,pCoughNegative;
	public static float pNoCoughPositive ,pNoCoughNegative;
	public static float pThroatPositive, pThroatNegative, pNoThroatPositive, pNoThroatNegative;
	public static float pRecentlyPositive ,pRecentlyNegative ,pNoRecentlyPositive ,pNoRecentlyNegative;
	int counter = 0;
	int pcounter = 0;
	int ncounter = 0;
	float positive = 0;
	float negative = 0;
	
	
	
	ArrayList<ArrayList<String> > aList =   new ArrayList<ArrayList<String> >(6); 
	List<String> Temp = new ArrayList<>();
	List<String> Aches = new ArrayList<>();
	List<String> Cough = new ArrayList<>();
	List<String> Throat = new ArrayList<>();
	List<String> Recently = new ArrayList<>();
	List<String> corona = new ArrayList<>();
	
	
	
	//this method is used to read the data and pass it on to be organised
	public String readData() {
			
		
		//the try catch is used incase the file that is to be read can not be found
		try {
				
		//Opening the text file and naming it 'data' ,also opening a scanner and using a comma as the delimiter
		String data = "datacsv.txt";
		Scanner s = new Scanner(new File(data)).useDelimiter(",");
		String text = s.next();
			
			
		//running through the csv file as long as there is another value
		//then passing the value onto organiseData
		
		
		while (s.hasNextLine()) {
		organiseData(text);
		text = s.next();
		
		
		
		}	
		organiseData(text);
		
		
		//Here the appropriate functions are called to add up the total amount of all
		//variations of cases eg yes yes, no yes etc.
		//it is then divided by the total amount of yes cases or the total amount of no cases.
		
		/////////////////////////////////////////////////////////////
		sortDataPos(Cough,corona);
		pCoughPositive = positive/pcounter;
		pCoughNegative = negative/pcounter;
		
		sortDataNeg(Cough,corona);
		pNoCoughPositive = positive/ncounter;
		pNoCoughNegative = negative/ncounter;
	
		
		/////////////////////////////////////////////////////////////
		
		sortDataPos(Aches,corona);
		pAchesPositive = positive/pcounter;
		pAchesNegative = negative/pcounter;
		
		
		
		sortDataNeg(Aches,corona);
		pNoAchesPositive = positive/ncounter;
		pNoAchesNegative = negative/ncounter;
		
		
		//////////////////////////////////////////////////////////////
		sortDataPos(Throat,corona);
		pThroatPositive = positive/pcounter;
		pThroatNegative = negative/pcounter;
		
		
		sortDataNeg(Throat,corona);
		pNoThroatPositive = positive/ncounter;
		pNoThroatNegative = negative/ncounter;
		
		
		///////////////////////////////////////////////////////////////
		sortDataPos(Recently,corona);
		pRecentlyPositive = positive/pcounter;
		pRecentlyNegative = negative/pcounter;

		sortDataNeg(Recently,corona);
		pNoRecentlyPositive = positive/ncounter;
		pNoRecentlyNegative = negative/ncounter;
		
		////////////////////////////////////////////////////////////////
		
		sortTempHot(Temp,corona);
		pHotPositive = positive/pcounter;
		pHotNegative = negative/pcounter;
	
	
		sortTempCold(Temp,corona);
		pColdPositive = positive/pcounter;
		pColdNegative = negative/pcounter;
		
		
		
	
		sortTempCool(Temp,corona);
		pCoolPositive = positive/pcounter;
		pCoolNegative = negative/pcounter;
		
		
		sortTempNormal(Temp,corona);
		pNormalPositive = positive/pcounter;
		pNormalNegative = negative/pcounter;
		
		
		
		
		
		return text;
			
		}
			
		catch (Exception FileNotFoundException) {
			System.out.println("Missing text file");
			return "error";
		}
		
		
	}

		
		
		
		
	//this places data eg aches(yes or no) into an array list 
	//
	//A counter is used to go through the 5 options for each case and then start again.
	public void organiseData(String text) {
		
		
		
		if (counter == 6) {
			counter = 0;
		}
	
		switch(counter) {
		
		case 0:
			Temp.add(text);
		
			break;
			
		case 1:
			Aches.add(text);
			break;
			
		case 2:
			Cough.add(text);
			break;
			
		case 3:
			Throat.add(text);
			break;
			
		case 4:
			Recently.add(text);
			break;
		
		case 5:
			corona.add(text);
			
	
		}
		
		
		
		counter++;
		
		
		
	}

	
	
	
	
	
	//sortDataPos and sortDataNeg are used to count how many combinations
	//there are of each  type eg cough yes corona yes , cough no corona yes etc.
	//the probabilty is then found above by dividing by the total amount of yes cases
	// and no cases
	
	public  void sortDataPos(List<String> list,List<String> corona) {
		
		
		positive = 0;//yes yes
		
		negative = 0;// no yes
		pcounter = 0;
		
		
		
		
		
		// yes yes
		for(int i=0;i<corona.size();i++) {
			
			if(corona.get(i).contains("s") && list.get(i).contains("s")) {
				positive++;
				pcounter++;
				
				
			}
			
		}
	
			// no yes
		
			for(int i=0;i<list.size();i++) {
				
				if(corona.get(i).contains("y") && list.get(i).contains("o")) {
					negative++;
					pcounter++;
				}
			
		}
			
			
		
		
		

	}
	
	

	
	
	//sortDataPos and sortDataNeg are used to count how many combinations
		//there are of each  type eg cough yes corona yes , cough no corona yes etc.
		//the probabilty is then found above by dividing by the total amount of yes cases
		// and no cases
	
	public void sortDataNeg(List<String> list,List<String> corona) {
		
		
		positive = 0; //no yes
		negative = 0; // no no
		ncounter = 0;
		
		
		//both of these for loops are used to iterate through two lists one always
		//being if the person had corona or not.
		
		
		// no yes
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("y")) {
				positive++;
				ncounter++;
			}
			
			
			
			
		}
		
		// no no
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("o")) {
				negative++;
				ncounter++;
			}
		}
		
		
	
		

	}
	









	//not yet finished
	public void sortTempHot(List<String> list,List<String> corona) {
		
		positive = 0; //no yes
		negative = 0; // no no
		ncounter = 0;
		
		
		//both of these for loops are used to iterate through two lists one always
		//being if the person had corona or not.
		
		
		// corona no hot 
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("y") && list.get(i).contains("t")) {
				positive++;
				ncounter++;
			}
			
			
			
			
		}
		
		// corona  yes hot
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("t")) {
				negative++;
				ncounter++;
			}
		}
		
		
	}
	
	public void sortTempCold(List<String> list,List<String> corona) {
		
		positive = 0; //no yes
		negative = 0; // no no
		ncounter = 0;
		
		
		//both of these for loops are used to iterate through two lists one always
		//being if the person had corona or not.
		
		
		// corona no hot 
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("y") && list.get(i).contains("d")) {
				positive++;
				ncounter++;
			}
			
			
			
			
		}
		
		// corona  yes hot
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("d")) {
				negative++;
				ncounter++;
			}
		}
		
		
	}
	
	
	public void sortTempNormal(List<String> list,List<String> corona) {
	
		positive = 0; //no yes
		negative = 0; // no no
		ncounter = 0;
		
		
		//both of these for loops are used to iterate through two lists one always
		//being if the person had corona or not.
		
		
		// corona no hot 
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("y") && list.get(i).contains("n")) {
				positive++;
				ncounter++;
			}
			
			
			
			
		}
		
		// corona  yes hot
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("n")) {
				negative++;
				ncounter++;
			}
		}
	}
	
	
	public void sortTempCool(List<String> list,List<String> corona) {
		
		positive = 0; //no yes
		negative = 0; // no no
		ncounter = 0;
		
		
		//both of these for loops are used to iterate through two lists one always
		//being if the person had corona or not.
		
		
		// corona no hot 
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("y") && list.get(i).contains("oo")) {
				positive++;
				ncounter++;
			}
			
			
			
			
		}
		
		// corona  yes hot
		for(int i=0;i<corona.size();i++) {
			if(corona.get(i).contains("o") && list.get(i).contains("oo")) {
				negative++;
				ncounter++;
			}
		}
	
}
	
	

	
}

