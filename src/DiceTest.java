import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*Forklaring af kommentarer: 
 *Ved hvert positiv/negativ test er kommentarerne struktureret således:
 *Forventet værdi: Det resultat vi siger, at testmetoden skal forvente.
 *Faktisk værdi: Den værdi, testmetoden giver
 *Resultatet: Vi fik forventede værdi / vi fik ikke den forventede værdi. 
*/

public class DiceTest {

	Dice diceUnderTest;
	
	// Vi kalder en testmetode til at starte med
	@Before
	public void setUp() throws Exception {
		diceUnderTest = new Dice();
	}


	@After
	public void tearDown() throws Exception {
	}

	
	// Positiv: Forventet værdi: 60000 	-  Faktist værdi: 60000 - Den akkumulerede mængde af samtlige udfald mellem 1 og 6.	- Resultatet var korrekt
	// Negativ: Forventet værdi: 59999 	-  Faktist værdi: 60000 - Den akkumulerede mængde af samtlige udfald mellem 1 og 6.	- Resultatet var forkert
	
	@Test
	public void testRoll() {
		int faktisk=0;
		int forventet = 59999;
		int max = 6;
		int min = 1;
		for (int i=0; i<60000; i++) {
			int tal = diceUnderTest.roll();
			if (min <= tal && max>= tal)
				faktisk++;
		}
		System.out.println(faktisk);
		assertEquals(forventet, faktisk);
	}

	
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 1	- Faktist værdi: 5937	- Resultatet var forkert
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 2	- Faktist værdi: 12003	- Resultatet var forkert 
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 3	- Faktist værdi: 11922	- Resultatet var forkert
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 4	- Faktist værdi: 11971	- Resultatet var forkert 
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 5	- Faktist værdi: 12091	- Resultatet var forkert
	// Positiv: Forventet værdi: [9600 ; 10400]	- Terning: 6	- Faktist værdi: 5956	- Resultatet var forkert 
	
	// Negativ: Forventet værdi: 0 				- Terning: 7	- Faktist værdi: 0		- Resultatet var korrekt  *Løkken gennemløber 70000 gang i forhold til 60000

	@Test
	public void testRoll1() {
		int faktisk = 0;
		int maxForventet = 10400;
		int minForventet = 9600;
		for(int i=0; i<70000; i++){
			int terning = 6;
			int tal = diceUnderTest.roll();
			
			if (terning == tal)
				faktisk++;
		}
		System.out.println(faktisk);
		assertTrue (faktisk<=maxForventet && faktisk>=minForventet);
	}	
}
	
	
	

