public class ProbCalc {

	float probPos = 1;
	float temppos = 1;
	float negPos = 1;
	float negpos = 1;
	float pos =1;
	float neg = 1;
	float swap =0;
	
	public float  calculatepos(float Temp)  {

		
		probPos = probPos * Temp;
		
		
		return Temp;
	}
	
	
public float  calculateNeg(float Temp) {
		
		
		negPos = negPos * Temp;
		
		
		return Temp;
	}








public void calctest() {
	float pos =1;
	float neg = 1;
	
	if(gui.Cough == true) {
		pos = pos * calculatepos(data.pCoughPositive);
		neg = neg * calculateNeg(data.pCoughNegative);
		
	}
	else {
		pos = pos * calculatepos(data.pNoCoughPositive);
		neg = neg * calculateNeg(data.pNoCoughNegative);
	}
	
	
	
	
	////////////////////////////////////////////////////////////////
	if(gui.Aches == true) {
		pos = pos * calculatepos(data.pAchesPositive);
		neg = neg * calculateNeg(data.pAchesNegative);
		
		
	}
	else {
		pos = pos * calculatepos(data.pNoAchesPositive);
		neg = neg * calculateNeg(data.pNoAchesNegative);
	}
	
	
	
	////////////////////////////////////////////////////////////////
	if(gui.Recently == true) {
		pos = pos * calculatepos(data.pRecentlyPositive);
		neg = neg * calculateNeg(data.pRecentlyNegative);
		
	}
	else {
		pos = pos * calculatepos(data.pNoRecentlyPositive);
		neg = neg * calculateNeg(data.pNoRecentlyNegative);
	}
	
	
	
	
	////////////////////////////////////////////////////////////////
	if(gui.Throat == true) {
		pos = pos * calculatepos(data.pThroatPositive);
		neg = neg * calculateNeg(data.pThroatNegative);
		
	}
	else {
		pos = pos * calculatepos(data.pNoThroatPositive);
		neg = neg * calculateNeg(data.pNoThroatNegative);
	}
	////////////////////////////////////////////////////////////////
	
	
	
	
	switch (gui.tempNo) {
	
	case 1 :
		
		
		pos = pos * calculatepos(data.pHotPositive);
		neg = neg * calculateNeg(data.pHotNegative);
		
		break;
		
	case 2:
		
		pos = pos * calculatepos(data.pColdPositive);
		neg = neg * calculateNeg(data.pColdNegative);
		
		break;
	case 3:
		
		pos = pos * calculatepos(data.pCoolPositive);
		neg = neg * calculateNeg(data.pCoolNegative);
		
		break;
		
	case 4:
		
		pos = pos * calculatepos(data.pNormalPositive);
		neg = neg * calculateNeg(data.pNormalNegative);
		
		break;
	}
	
	
	
	//here the probabilites are normalized (eg they add up to 1)
	// and then mutliplied to show them as a percentage out of 100
	swap = pos;
	pos = pos/(pos+neg)* 100;
	neg = neg/(swap+neg)* 100;
	System.out.println("chance of having corona is "+pos + " percent");
	System.out.println("chance of NOT having corona is "+neg+ " percent");
	
	

}
}


