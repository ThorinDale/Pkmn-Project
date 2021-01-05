
public class MoveMaker implements MoveMakerInterface {
	
	public Move makeMove(String n) {
		if (n == "Aeroblast") {
			return new Aeroblast();
		}
		else if (n == "Psychic") {
			return new Psychic();
		}
		else if (n == "Ancientpower") {
			return new AncientPower();
		}
		else if (n == "Hydro Pump") {
			return new HydroPump();
		}
		else if (n == "Sacred Fire") {
			return new SacredFire();
		}
		else if (n == "Earthquake") {
			return new Earthquake();
		}
		else if (n == "Brave Bird") {
			return new BraveBird();
		}
		else if (n == "Iron Head") {
			return new IronHead();
		}
		else if (n == "Calm Mind") {
			return new CalmMind();
		}
		else if (n == "Thunder Wave") {
			return new ThunderWave();
		}
		return null;
	}
}