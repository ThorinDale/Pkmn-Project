import java.lang.Math;

public class Status {
	
	private String status;
	private boolean confused;
	private int badlyPoisonCounter;
	private int sleepCounter;
	private int confuseCounter;
	
	public Status() {
		status = null;
		confused = false;
		badlyPoisonCounter = 0;
		sleepCounter = 0;
		confuseCounter = 0;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void decrementConfuseCounter() {
		confuseCounter--;
	}
	
	public boolean getConfuse() {
		return confused;
	}
	
	public int getConfuseCounter() {
		return confuseCounter;
	}
	
	public void setConfused(Pkmn p) {
		if (p.getStatus().getConfuse()) {
			System.out.println("Already confused!");
			return;
		}
		p.getStatus().confused = true;
		p.getStatus().confuseCounter = generateRandomInt(1, 4);
		System.out.println("Is confused");
	}
	
	public void removeConfused() {
		this.confused = false;
		System.out.println("Snapped out of confusion!");
	}
	
	public void setStatus(String s, Pkmn p) {
		if (p.getStatus().status != null) {
			System.out.println("Only one status ailment can be afflicted at a time.");
			return;
		}
		String[] types = p.getTypes().getTypes();
		for (int i = 0; i < types.length; i++) {
			if (s == "burn" && types[i] == "Fire") {
				System.out.println("Fire types cannot be burned.");
				return;
			} else if (s == "freeze" && types[i] == "Ice") {
				System.out.println("Ice types cannot be frozen.");
				return;
			} else if (s == "paralysis" && types[i] == "Electric") {
				System.out.println("Electric types cannot be paralyzed.");
				return;
			} else if ((s == "poison" || s == "badlyPoison") && (types[i] == "Poison" || types[i] == "Steel")) {
				System.out.println("Poison and Steel types cannot be poisoned.");
				return;
			}
		}
		status = s;
		System.out.println("Status Affliction: " + status);
		p.getStatus().implementStatus(p);
	}

	public void implementStatus(Pkmn p) {
		if (p.getStatus().status == "burn") {
//			p.getAtk().modifyValueByStatus(0.5);
			System.out.println("Burned, attack has been halved");
		} else if (p.getStatus().status == "paralysis") {
			p.getSpe().modifyValueByStatus(0.5);
			System.out.println("Paralyzed, speed has been halved");
		} else if (p.getStatus().status == "sleep") {
			p.getStatus().sleepCounter = generateRandomInt(1, 7);
			System.out.println(p.getStatus().sleepCounter);
			System.out.println("Fell asleep");
		} 
	}
	
	public void cureStatus(Pkmn p) {
		if (p.getStatus().status == "burn") {
			p.getAtk().setStatusModifiedValue(0);
		} else if (p.getStatus().status == "paralysis") {
			p.getSpe().setStatusModifiedValue(0);
		}
		p.getStatus().status = null;
	}
	
	public boolean executeMoveStatus(Pkmn p) {
//		System.out.println("Confusion counter: " + p.getStatus().confuseCounter);
		if (p.getStatus().status == "freeze") {
			if (generateRandomInt(1, 100) < 20) {
				p.getStatus().cureStatus(p);
				System.out.println("Thawed out!");
			} else {
				System.out.println("Frozen solid!");
				return false;
			}
		} else if (p.getStatus().status == "paralysis") {
			if (generateRandomInt(1, 100) < 25) {
				System.out.println("Paralyzed and cannot move!");
				return false;
			}
		} else if (p.getStatus().status == "sleep") {
			sleepCounter--;
			if (sleepCounter > 0) {
				System.out.println("Fast asleep.");
				return false;
			} else {
				p.getStatus().cureStatus(p);
			}
		}
		
		if (p.getStatus().getConfuse()) {
			System.out.println("Is still confused");
//			System.out.println("Before decrement: " + p.getStatus().getConfuseCounter());
			p.getStatus().decrementConfuseCounter();
//			System.out.println("After decrement: " + p.getStatus().getConfuseCounter());
			if (p.getStatus().getConfuseCounter() > 0) {
				if (generateRandomInt(1, 100) <= 33) {
					System.out.println("Hurt itself from confusion!");
					return false;
				}
			} else {
				p.getStatus().removeConfused();
			}
		}
		return true;
	}
	
	public void endOfTurnStatus(Pkmn p) {
		String s = p.getStatus().getStatus();
//		System.out.println("end of turn status check: " + s);
		switch (s) {
			case "burn":
				p.getHP().modifyValue(-(int)(p.getHP().getfValue()*(1/16.0)));
				break;
			case "poison":
				p.getHP().modifyValue(-(int)(p.getHP().getfValue()*(1/8.0)));
				break;
			case "badlyPoison":
				badlyPoisonCounter++;
				p.getHP().modifyValue(-(int)(p.getHP().getfValue()*(p.getStatus().badlyPoisonCounter/16.0)));
			default:
				break;
		}
	}
	
	public void resetCounters() {
		this.confused = false;
		this.confuseCounter = 0;
		this.badlyPoisonCounter = 0;
	}
	
	public int generateRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
}