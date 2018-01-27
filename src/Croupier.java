import java.util.concurrent.ThreadLocalRandom;

public class Croupier {
	
	public Croupier() {
		super();
	}

	public void distribuerCarte(){
		int randomNum = ThreadLocalRandom.current().nextInt(1, 13 + 1);
		int randomType = ThreadLocalRandom.current().nextInt(1, 4 + 1);
		
		System.out.println("RandomNum" + randomNum);
		System.out.println("RandomType" + randomType);
	}

}
