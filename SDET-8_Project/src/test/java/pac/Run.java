package pac;

class AntiVirus{
	static AntiVirus a1 = new AntiVirus();                     // Rule 2 : create static Object for same class  
	private AntiVirus(){                               // Rule 1 : make Class Construtor as private
		System.out.println("construtor"); 
	}
	
	public static AntiVirus getAntiVirusInstance() {          // Rule 3 : provide public static getInstance() mtd to retun same Object all the time     
	    return a1;	
	}
}


public class Run {

	public static void main(String[] args) {
	
           System.out.println(AntiVirus.getAntiVirusInstance());
           System.out.println(AntiVirus.getAntiVirusInstance());
           System.out.println(AntiVirus.getAntiVirusInstance());
	}

}
