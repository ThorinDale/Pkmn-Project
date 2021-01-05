import java.lang.Math;

class Aeroblast extends Move {
	
	public Aeroblast() {
		super("Aeroblast", "Flying", "special", 100, false, false);
	}
	
	public void effect(Pkmn p) {
	}
	
}

class Psychic extends Move {
	
	public Psychic() {
		super("Psychic", "Psychic", "special", 90, false, false);
	}
	
	public void effect(Pkmn p) {
		int rand = super.generateRandomInt(1, 100);
		if (rand <= 10) {
			p.getSpD().modifyStage(-1);
		}
	}
	
}

class AncientPower extends Move {
	
	public AncientPower() {
		super("Ancientpower", "Rock", "special", 60, false, true);
	}
	
	public void effect(Pkmn p) {
		int rand = super.generateRandomInt(1, 100);
		if (rand <= 10) {
			p.getAtk().modifyStage(1);
			p.getDef().modifyStage(1);
			p.getSpA().modifyStage(1);
			p.getSpD().modifyStage(1);
			p.getSpe().modifyStage(1);
		}
	}
}

class HydroPump extends Move {
	
	public HydroPump() {
		super("Hydro Pump", "Water", "special", 110, false, false);
	}
	
	public void effect(Pkmn p) {}
}

class SacredFire extends Move {
	
	public SacredFire() {
		super("Sacred Fire", "Fire", "physical", 100, false, false);
	}
	
	public void effect(Pkmn p) {
		int rand = super.generateRandomInt(1, 100);
		if (rand <= 50) {
			p.getStatus().setStatus("burn", p);
		}
	}
}

class BraveBird extends Move {
	
	public BraveBird() {
		super("Brave Bird", "Flying", "physical", 120, false, true);
	}
	
	public void effect(Pkmn p) {
		int recoil = (int) ((double) p.getHP().getfValue() * (0.25));
		p.getHP().modifyValue(recoil * (-1));
	}
}

class Earthquake extends Move {
	
	public Earthquake() {
		super("Earthquake", "Ground", "physical", 100, false, false);
	}
	
	public void effect(Pkmn p) {}
}

class IronHead extends Move {
	
	public IronHead() {
		super("Iron Head", "Steel", "physical", 80, false, false);
	}
	
	public void effect(Pkmn p) {}
}

class CalmMind extends Move {
	
	public CalmMind() {
		super("Calm Mind", "Psychic", "status", 0, true, true);
	}
	
	public void effect(Pkmn p) {
		p.getSpA().modifyStage(1);
		p.getSpD().modifyStage(1);
	}
}

class ThunderWave extends Move {
	
	public ThunderWave() {
		super("Thunder Wave", "Electric", "status", 0, false, false);
	}
	
	public void effect(Pkmn p) {
		p.getStatus().setStatus("paralysis", p);
	}
}