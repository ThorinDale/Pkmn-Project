
public abstract class Move {
	
	private String name;
	private String type;
	private String category;
	private int power;
	private boolean selfTarget;
	private boolean selfEffectTarget;
	abstract void effect(Pkmn p);
	
	public Move(String n, String t, String c, int p, boolean s, boolean se) {
		name = n;
		type = t;
		category = c;
		power = p;
		selfTarget = s;
		selfEffectTarget = se;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public boolean getSelfTarget() {
		return this.selfTarget;
	}
	
	public boolean getSelfEffectTarget() {
		return this.selfEffectTarget;
	}
	
	public int generateRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}