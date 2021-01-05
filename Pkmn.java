import java.awt.print.*;

public abstract class Pkmn {
	
	private String name;
	private boolean faint;
	private Type types;
	private Status status;
	private HPStat hp;
	private CoreStat atk;
	private CoreStat def;
	private CoreStat spa;
	private CoreStat spd;
	private CoreStat spe;
	private MoveMaker movemaker;
	private Move move1;
	private Move move2;
	private Move move3;
	private Move move4;
	private int decision;
//	private Ability ability;

	public Pkmn(String n, int h, int a, int d, int sa, int sd, int se, String m1, String m2, String m3, String m4) {
		name = n;
		hp = new HPStat(h);
		atk = new CoreStat(a);
		def = new CoreStat(d);
		spa = new CoreStat(sa);
		spd = new CoreStat(sd);
		spe = new CoreStat(se);
		status = new Status();
		
		movemaker = new MoveMaker();
		move1 = movemaker.makeMove(m1);
		move2 = movemaker.makeMove(m2);
		move3 = movemaker.makeMove(m3);
		move4 = movemaker.makeMove(m4);
		faint = false;
	}
	
	public Pkmn(String n, String p, int h, int a, int d, int sa, int sd, int se, String m1, String m2, String m3, String m4) {
		this(n, h, a, d, sa, sd, se, m1, m2, m3, m4);
		this.setTypes(p);
	}
	
	public Pkmn(String n, String p, String s, int h, int a, int d, int sa, int sd, int se, String m1, String m2, String m3, String m4) {
		this(n, h, a, d, sa, sd, se, m1, m2, m3, m4);
		this.setTypes(p, s);
	}
	
	public void setTypes(String p) {
		types = new Type(p);
	}
	
	public void setTypes(String p, String s) {
		types = new Type(p, s);
	}
	
	public void setMoves(Move m1, Move m2, Move m3, Move m4) {
		move1 = m1;
		move2 = m2;
		move3 = m3;
		move4 = m4;
	}
	
	public void setFaint() {
		faint = true;
	}
	
	public void setDecision(int d) {
		decision = d;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getFaint() {
		return this.faint;
	}
	
	public Type getTypes() {
		return this.types;
	}
	
	public HPStat getHP() {
		return this.hp;
	}
	
	public CoreStat getAtk() {
		return this.atk;
	}
	
	public CoreStat getDef() {
		return this.def;
	}
	
	public CoreStat getSpA() {
		return this.spa;
	}
	
	public CoreStat getSpD() {
		return this.spd;
	}
	
	public CoreStat getSpe() {
		return this.spe;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public Move getMove1() {
		return this.move1;
	}
	
	public Move getMove2() {
		return this.move2;
	}
	
	public Move getMove3() {
		return this.move3;
	}
	
	public Move getMove4() {
		return this.move4;
	}
	
	public int getDecision() {
		return this.decision;
	}
	
	public String toString() {
		return "Name: " + name +
			"\nTypes: " + types.getTypes()[0] +
			"\nHP: " + hp.getValue() +
			"\nAttack: " + atk.getValue() +
			"\nDefense: " + def.getValue() +
			"\nSpecial Attack: " + spa.getValue() +
			"\nSpecial Defense: " + spd.getValue() +
			"\nSpeed: " + spe.getValue() +
			"\nMoves: " + move1.getName() + "," + move2.getName() + "," + move3.getName() + "," + move4.getName();
	}
	
	public String consoleDisplay() {
		return "Name: " + name + 
			"\nHP: " + hp.getValue() + 
			"\nMoves: " + "1) " + move1.getName() + " * " + "2) " + move2.getName() + " * " + "3) " + move3.getName() + " * " + "4) " + move4.getName() +
			"\nStatus: " + status.getStatus();
	}
	
	public String consoleDisplayOpponent() {
		return "\t\t\t\t\t\t\t\t\t\t\t\tName: " + name + 
			"\n\t\t\t\t\t\t\t\t\t\t\t\tHP: " + hp.getValue() +
			"\n\t\t\t\t\t\t\t\t\t\t\t\tStatus: " + status.getStatus();
	}
}