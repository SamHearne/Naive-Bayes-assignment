
public class ProbCalc {

	float probPos = 1;
	float temppos = 1;
	float negPos = 1;
	float negpos = 1;
	
	
	public float  calculatepos(float Temp) {

		
		probPos = probPos * Temp;
		
		
		return Temp;
	}
	
	
public float  calculateNeg(float Temp) {
		
		
		negPos = negPos * Temp;
		
		
		return Temp;
	}
}


