import java.util.Random;

public class Calculations {
	private static int rndmNr;
	private static int rndmTwo;

	//	public static void main(String[] args) {
	//		//System.out.println(getRandomNr());
	//		// System.out.println(getRandomTwo());
	//	}

	public static int getRandomNr() {
		Random rndmGenerate = new Random();
		rndmNr = rndmGenerate.nextInt(100) + 1;
		// System.out.println(rndmOne);
		return rndmNr;
	}

	public static int getRandomTwo() {
		Random rndmGenerate = new Random();
		rndmTwo = rndmGenerate.nextInt(100) + 50; // System.out.println(rndmTwo);
		return rndmTwo;
	}

}

// public static int getRndmOne() {
// return rndmOne;
// }

// public static int getRndmTwo() {
// return rndmTwo;

// }
// }