
public class Stat {
	
	protected final int fValue;
	protected int value;
	
	public Stat(int f) {
		fValue = f;
		value = f;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getfValue() {
		return fValue;
	}
}