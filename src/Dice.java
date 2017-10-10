
public class Dice {
	privat final int MAX=6;
	
	// roll the die and return the value (1-6)
	public int roll() {
		return (int) (Math.random()*MAX)+1;
	}
	
	// roll the die n times and print the values	
	public void rollMultiple(int n) {
		for (int i=0; i<n; i++) { 
			System.out.print(roll() + " ");
		}		
	}
}
