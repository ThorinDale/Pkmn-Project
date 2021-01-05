import java.lang.Math;

public class Type {

	private String[] types;
	private String attackingType;
	private double weaknessModifier;
	private boolean immune;
	
	public Type(String p) {
		types = new String[1];
		types[0] = p;
	}
	
	public Type(String p, String s) {
		types = new String[2];
		types[0] = p;
		types[1] = s;
	}
	
	public String[] getTypes() {
		return types;
	}
	
	public double getWeaknessModifier() {
		return weaknessModifier;
	}
	
	public void setAttackingType(String a) {
		attackingType = a;
		this.setWeaknessModifier(a);
	}
	
	public void setWeaknessModifier(String a) {
		int weaknessCounter = 0;
		
		for (int i = 0; i < types.length; i++) {
			weaknessCounter += this.weaknessCalc(types[i], a);
		}
		
		if (immune) {
			weaknessModifier = 0;
		} else {
			weaknessModifier = Math.pow(2, weaknessCounter);
		}
		
		if (weaknessModifier == 0) {
			System.out.println("It has no effect.");
		} else if (weaknessModifier > 1) {
			System.out.println("It's super effective!");
		} else if (weaknessModifier < 1) {
			System.out.println("It's not very effective!");
		}
	}
	
	public void noDamage() {
		immune = true;
	}
	
	public void resetDamage() {
		immune = false;
	}
	
	public int weaknessCalc(String t, String a) {
		int count = 0;
		
		if (t == "Normal") {
			if (a == "Fighting") {
				count++;
			}
			else if (a == "Ghost") {
				this.noDamage();
				return 0;
			}
		}
		
		else if (t == "Fighting") {
			if (a == "Flying" || a == "Psychic" || a == "Fairy") {
				count++;
			}
			else if (a == "Rock" || a == "Bug" || a == "Dark") {
				count--;
			}
		}
		
		else if (t == "Flying") {
			if (a == "Ground") {
				this.noDamage();
				return 0;
			}
			else if (a == "Rock" || a == "Electric" || a == "Ice") {
				count++;
			}
			else if (a == "Fighting" || a == "Bug" || a == "Grass") {
				count--;
			}
		}
		
		else if (t == "Poison") {
			if (a == "Ground" || a == "Psychic") {
				count++;
			}
			else if (a == "Fighting" || a == "Poison" || a == "Bug" || a == "Grass" || a == "Fairy") {
				count--;
			}
		}
		
		else if (t == "Ground") {
			if (a == "Electric") {
				this.noDamage();
				return 0;
			}
			else if (a == "Water" || a == "Grass" || a == "Ice") {
				count++;
			}
			else if (a == "Poison" || a == "Rock") {
				count--;
			}
		}
		
		else if (t == "Rock") {
			if (a == "Fighting" || a == "Ground" || a == "Steel" || a == "Water" || a == "Grass") {
				count++;
			}
			else if (a == "Normal" || a == "Flying" || a == "Poison" || a == "Fire") {
				count--;
			}
		}
		
		else if (t == "Bug") {
			if (a == "Flying" || a == "Rock" || a == "Fire") {
				count++;
			}
			else if (a == "Fighting" || a == "Ground" || a == "Grass") {
				count--;
			}
		}
		
		else if (t == "Ghost") {
			if (a == "Fighting" || a == "Normal") {
				this.noDamage();
				return 0;
			}
			else if (a == "Ghost" || a == "Dark") {
				count++;
			}
			else if (a == "Poison" || a == "Bug") {
				count--;
			}
		}
		
		else if (t == "Steel") {
			if (a == "Fighting" || a == "Ground" || a == "Fire") {
				count++;
			}
			else if (a == "Normal" || a == "Flying" || a == "Rock" || a == "Bug" || a == "Steel" || a == "Grass" || a == "Psychic" || a == "Ice" || a == "Dragon" || a == "Fairy") {
				count--;
			}
		}
		
		else if (t == "Fire") {
			if (a == "Ground" || a == "Water" || a == "Rock") {
				count++;
			}
			else if (a == "Bug" || a == "Steel" || a == "Fire" || a == "Grass" || a == "Ice" || a == "Fairy") {
				count--;
			}
		}
		
		else if (t == "Water") {
			if (a == "Grass" || a == "Electric") {
				count++;
			}
			else if (a == "Steel" || a == "Fire" || a == "Water" || a == "Ice") {
				count--;
			}
		}
		
		else if (t == "Grass") {
			if (a == "Flying" || a == "Poison" || a == "Bug" || a == "Fire" || a == "Ice") {
				count++;
			}
			else if (a == "Ground" || a == "Water" || a == "Grass" || a == "Electric") {
				count--;
			}
		}
		
		else if (t == "Electric") {
			if (a == "Ground") {
				count++;
			}
			else if (a == "Flying" || a == "Steel" || a == "Electric") {
				count--;
			}
		}
		
		else if (t == "Psychic") {
			if (a == "Bug" || a == "Ghost" || a == "Dark") {
				count++;
			}
			else if (a == "Fighting" || a == "Electric") {
				count--;
			}
		}
		
		else if (t == "Ice") {
			if (a == "Fighting" || a == "Rock" || a == "Steel" || a == "Fire") {
				count++;
			}
			else if (a == "Ice") {
				count--;
			}
		}
		
		else if (t == "Dragon") {
			if (a == "Dragon" || a == "Fairy" || a == "Ice") {
				count++;
			}
			else if (a == "Fire" || a == "Water" || a == "Grass" || a == "Electric") {
				count--;
			}
		}
		
		else if (t == "Dark") {
			if (a == "Psychic") {
				this.noDamage();
				return 0;
			}
			else if (a == "Fighting" || a == "Bug" || a == "Fairy") {
				count++;
			}
			else if (a == "Ghost" || a == "Dark") {
				count--;
			}
		}
		
		else if (t == "Fairy") {
			if (a == "Dragon") {
				this.noDamage();
				return 0;
			}
			else if (a == "Poison" || a == "Steel") {
				count++;
			}
			else if (a == "Fighting" || a == "Bug" || a == "Dark") {
				count--;
			}
		}
		
		return count;
	}
	
}