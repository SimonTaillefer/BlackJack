
public class Mise {
	
	int mise;

	public Mise(int somme) {
		super();
		this.mise = somme;
	}
	
	void miser(int somme){
		 setMise(getMise() + somme);
	}

	public int getMise() {
		return mise;
	}

	public void setMise(int mise) {
		this.mise = mise;
	}
}
