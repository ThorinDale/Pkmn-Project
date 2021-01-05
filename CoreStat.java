
public class CoreStat extends Stat {
	
	private int stage;
	private int statusModifiedValue; // for when the Pkmn is burned or paralyzed, mods value
	
	public CoreStat(int f) {
		super(f);
		stage = 0;
		statusModifiedValue = value;
	}
	
	public void setStatusModifiedValue(int v) {
		statusModifiedValue = v;
	}
	
	public int getStage() {
		return stage;
	}
	
	public int getStatusModifiedValue() {
		return statusModifiedValue;
	}
	
	public void modifyStage(int m) {
		if (stage + m >= 6) {
			System.out.println("Stat was raised");
			stage = 6;
		} else if (stage + m <= -6) {
			System.out.println("Stat was lowered");
			stage = -6;
		} else {
			if (m > 0) {
				System.out.println("Stat was raised.");
			} else {
				System.out.println("Stat was lowered.");
			}
			stage = stage + m;
		}
		modifyValue();
	}
	
//	public void modifyValue(double m) {
//		value = (int) ((double) value * m);
//	}
	
	public void modifyValueByStatus(double m) {
		statusModifiedValue = (int) ((double) value * m);
	}
	
	public void modifyValue() {
		double multiplier;
		switch (stage) {
			case -6:
				multiplier = 0.25;
				break;
			case -5:
				multiplier = 0.285;
				break;
			case -4:
				multiplier = 0.33;
				break;
			case -3:
				multiplier = 0.4;
				break;
			case -2:
				multiplier = 0.5;
				break;
			case -1:
				multiplier = 0.66;
				break;
			case 1:
				multiplier = 1.5;
				break;
			case 2:
				multiplier = 2;
				break;
			case 3:
				multiplier = 2.5;
				break;
			case 4:
				multiplier = 3;
				break;
			case 5:
				multiplier = 3.5;
				break;
			case 6:
				multiplier = 4;
				break;
			default:
				multiplier = 1;
		}
		value = (int) (((double) fValue) * multiplier);
	}
	
}