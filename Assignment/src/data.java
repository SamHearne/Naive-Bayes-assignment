import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class data {
	
	
	//This counter is used further on to organise the data into the seperate arraylists
	// which are also initialised here.Each list will have the result and also if 
	// the person had corona EG: if a person is hot and has corona the Temp list will
	// have [hot,yes]
	
	
	int counter = 0;
	List<String> Temp = new ArrayList<>();
	List<String> Aches = new ArrayList<>();
	List<String> Cough = new ArrayList<>();
	List<String> Throat = new ArrayList<>();
	List<String> Recently = new ArrayList<>();
	
	
	
	//this method is used to read the data and pass it on to be organised
	public String readData() {
			
			
			
		//the try catch is used incase the file that is to be read can not be found
		try {
				
		//Opening the text file and naming it 'data' ,also opening a scanner and using a comma as the delimiter
		String data = "datacsv.txt";
		Scanner s = new Scanner(new File(data)).useDelimiter(",");
		String text = s.next();
			
			
		//running through the csv file as long as there is another value
		//then passing the value onto organis
		while (s.hasNextLine()) {
			
		organiseData(text);
		text = s.next();
		}
			System.out.println(Temp);
		return text;
			
		}
			
		catch (Exception FileNotFoundException) {
			System.out.println("Missing text file");
			return "error";
		}
		
	}
	
		
		
		
		
	//this places data eg temp , aches(yes or no) sore throat etc into an array list aswell as if that
	// data also has coronavirus
	//A counter is used to go through the 5 options for each case and then start again.
	public String organiseData(String text) {
		
		
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
		}
	
	
		
		counter++;
		if (counter == 5) {
			counter = 0;
		}
		
		return "success";
	}
	
	
}

