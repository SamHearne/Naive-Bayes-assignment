//This is a program which given a data set can attempt to
// predict if a person has corona or not. It uses naive bayes to interpet the data.
//A simple GUI is presented allowing the user to input their symptoms
//
//Authour : Sam Hearne
//Date : 05/04/2020
//Compiler : Eclipse
public class control {
	
	public static float pos=1;
	public static float neg = 1;
	
	public static void main(String[] args){
		
		boolean cough = false;
		boolean ache = false;
		boolean recently = false;
		boolean throat = false;
		float swap =0;
		
		
		ProbCalc calc = new ProbCalc();
		
		
		data data = new data();
		data.readData();
		
		
		////////////////////////////////////////////////////////////////
		if(cough == true) {
			pos = pos * calc.calculatepos(data.pCoughPositive);
			
			neg = neg * calc.calculateNeg(data.pCoughNegative);
			
		}
		else {
			pos = pos * calc.calculatepos(data.pNoCoughPositive);
			neg = neg * calc.calculateNeg(data.pNoCoughNegative);
		}
		
		
		
		
		////////////////////////////////////////////////////////////////
		if(ache == true) {
			pos = pos * calc.calculatepos(data.pAchesPositive);
			neg = neg * calc.calculateNeg(data.pAchesNegative);
			
		}
		else {
			pos = pos * calc.calculatepos(data.pNoAchesPositive);
			neg = neg * calc.calculateNeg(data.pNoAchesNegative);
		}
		
		
		
		////////////////////////////////////////////////////////////////
		if(recently == true) {
			pos = pos * calc.calculatepos(data.pRecentlyPositive);
			neg = neg * calc.calculateNeg(data.pRecentlyNegative);
			
		}
		else {
			pos = pos * calc.calculatepos(data.pNoRecentlyPositive);
			neg = neg * calc.calculateNeg(data.pNoRecentlyNegative);
		}
		
		
		
		
		////////////////////////////////////////////////////////////////
		if(throat == true) {
			pos = pos * calc.calculatepos(data.pThroatPositive);
			neg = neg * calc.calculateNeg(data.pThroatNegative);
			
		}
		else {
			pos = pos * calc.calculatepos(data.pNoThroatPositive);
			neg = neg * calc.calculateNeg(data.pNoThroatNegative);
		}
		////////////////////////////////////////////////////////////////
		
		
		
		
		//here the probabilites are normalized (eg they add up to 1)
		// and then mutliplied to show them as a percentage out of 100
		swap = pos;
		pos = pos/(pos+neg)* 100;
		neg = neg/(swap+neg)* 100;
		System.out.println("chance of having corona is "+pos + " percent");
		System.out.println("chance of NOT having corona is "+neg+ " percent");
		
		
	
	}
}


















