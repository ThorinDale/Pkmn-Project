
public class BattleField {
	
//	private Team team1;
//	private Team team2;
	
	private Pkmn pkmn1;
	private Pkmn pkmn2;
	private PkmnMaker pkmnMaker;
	
	public BattleField(String x, String y) {
		pkmnMaker = new PkmnMaker();
		
		pkmn1 = pkmnMaker.makePkmn(x);
		pkmn2 = pkmnMaker.makePkmn(y);
	}
	
	public Pkmn getPkmn1() {
		return pkmn1;
	}
	
	public Pkmn getPkmn2() {
		return pkmn2;
	}
	
	public Pkmn speedCompare() {
		int pkmn1Spe;
		int pkmn2Spe;
		if (pkmn1.getStatus().getStatus() == "paralysis") {
			pkmn1Spe = pkmn1.getSpe().getStatusModifiedValue();
		} else {
			pkmn1Spe = pkmn1.getSpe().getValue();
		}
		
		if (pkmn2.getStatus().getStatus() == "paralysis") {
			pkmn2Spe = pkmn2.getSpe().getStatusModifiedValue();
		} else {
			pkmn2Spe = pkmn2.getSpe().getValue();
		}
		
		if (pkmn1Spe > pkmn2Spe) {
			return pkmn1;
		} else if (pkmn1Spe < pkmn2Spe) {
			return pkmn2;
		} else {
			return pkmn1;
		}
	}
	
	public void executeTurn(Pkmn p1, Pkmn p2, Move m) {
		
		if (p1.getStatus().getStatus() != null || p1.getStatus().getConfuse()) {
			if (!p1.getStatus().executeMoveStatus(p1)) {
				return;
			}
		}
		
		System.out.println(p1.getName() + " used " + m.getName());
		if (!m.getSelfTarget()) {
			int damage = damageCalculation(p1, p2, m);
			System.out.println("Damage: " + damage);
			p2.getHP().modifyValue((-1) * damage);
			
			if (m.getSelfEffectTarget()) {
				m.effect(p1);
			}
			
			if (!m.getSelfEffectTarget()) {
				m.effect(p2);
			}
			
			if (faintCheck(p1, p2)) {
				return;
			}
		}
		else {
			m.effect(p1);
		}
		
//		endOfTurnChecks(p1, p2);
	}
	
	public void endOfTurnChecks(Pkmn p1, Pkmn p2) {
		if (p1.getStatus().getStatus() != null) {
			p1.getStatus().endOfTurnStatus(p1);
		} else if (p2.getStatus().getStatus() != null) {
			p2.getStatus().endOfTurnStatus(p2);
		}
		
		if (faintCheck(p1, p2)) {
			return;
		}
	}
	
	public boolean faintCheck(Pkmn p1, Pkmn p2) {
		if (p1.getHP().getValue() <= 0) {
			p1.setFaint();
		} else if (p2.getHP().getValue() <= 0) {
			p2.setFaint();
		}
		if (p1.getFaint() || p2.getFaint()) {
			return true;
		}
		return false;
	}
	
	public int damageCalculation(Pkmn p1, Pkmn p2, Move m) {
		if (m.getPower() == 0) {
			return 0;
		}
		int damage;
		String category = m.getCategory();
		if (category == "physical") {
//			if (p1.getStatus().getStatus() == "burn") {
//				damage = ( (int) (22 * (double)m.getPower() * ((double)p1.getAtk().getStatusModifiedValue() / (double)p2.getDef().getValue()) ) / 50 + 2);
//			} else {
			damage = ( (int) (22 * (double)m.getPower() * ((double)p1.getAtk().getValue() / (double)p2.getDef().getValue()) ) / 50 + 2);
			if (p1.getStatus().getStatus() == "burn") {
				damage = (int) ((double) damage * 0.5);
			}
		}
		else {
			damage = ((int) (22 * (double)m.getPower() * ((double)p1.getSpA().getValue() / (double)p2.getSpD().getValue())) / 50 + 2);
		}
		
//		System.out.println("Pre-modify Damage: " + damage);
		damage = (int) (damage * modifier(p1, p2, m));
		pkmn1.getTypes().resetDamage();
		pkmn2.getTypes().resetDamage();
		return damage;
	}
	
	public double modifier(Pkmn p1, Pkmn p2, Move m) {
		double modifier = 1;
		String[] types1 = p1.getTypes().getTypes();
		String[] types2 = p2.getTypes().getTypes();
		if (m.getType() == types1[0] || m.getType() == types1[1]) {
			modifier *= 1.5;
		}
		
		p2.getTypes().setAttackingType(m.getType());
		modifier *= p2.getTypes().getWeaknessModifier();
//		System.out.println(modifier);
		return modifier;
	}
	
	public boolean checkFaint(Pkmn p) {
		return p.getFaint();
	}
	
}