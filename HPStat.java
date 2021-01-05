
public class HPStat extends Stat {
	
	private int modifier;
	
	public HPStat(int f) {
		super(f);
		modifier = 0;
	}
	
	public void modifyValue(int d) {
		if (value + d > fValue) {
			value = fValue;
		} else if (value + d <= 0) {
			value = 0;
		} else {
			value = value + d;
		}
	}
	
	public double showPercent() {
		return value / fValue;
	}
}