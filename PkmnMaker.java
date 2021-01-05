
public class PkmnMaker implements PkmnMakerInterface {
	
	public Pkmn makePkmn(String n) {
		if (n == "Lugia") {
			return new Lugia();
		}
		else if (n == "Ho-Oh") {
			return new Ho_Oh();
		}
//		else if (n == "Zekrom") {
//			return new Zekrom();
//		}
//		else if (n == "Solgaleo") {
//			return new Solgaleo();
//		}
		return null;
	}
}