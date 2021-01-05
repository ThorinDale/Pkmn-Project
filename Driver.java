import java.util.*;
import java.lang.Math;

class Driver {
	public static void main(String[] args) {
		PkmnMaker pkmnMaker = new PkmnMaker();
		
		BattleField bt = new BattleField("Lugia", "Ho-Oh");
		Pkmn p1 = bt.getPkmn1();
		Pkmn p2 = bt.getPkmn2();
		
		Scanner scanner = new Scanner (System.in);
		
		while (!p1.getFaint() && !p2.getFaint()) {
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tOpponent-\n " + p2.consoleDisplayOpponent());
			System.out.println("\nYou-\n" + p1.consoleDisplay());
			
			System.out.println("\nSelect a move by pressing either 1, 2, 3, or 4");
			int playerNumber = scanner.nextInt();
			int opponentNumber = (int) (Math.random() * (4 - 1 + 1) + 1);
			p1.setDecision(playerNumber);
			p2.setDecision(opponentNumber);
			
			Pkmn faster = bt.speedCompare();
			Pkmn slower;
			if (faster == bt.getPkmn1()) {
				slower = bt.getPkmn2();
				
			} else {
				slower = bt.getPkmn1();
			}
			
			switch (faster.getDecision()) {
				case 2:
					bt.executeTurn(faster, slower, faster.getMove2());
					break;
				case 3:
					bt.executeTurn(faster, slower, faster.getMove3());
					break;
				case 4:
					bt.executeTurn(faster, slower, faster.getMove4());
					break;
				default:
					bt.executeTurn(faster, slower, faster.getMove1());
					break;
			}
			if (faster.getFaint() || slower.getFaint()) {
				break;
			}
			switch (slower.getDecision()) {
				case 2:
					bt.executeTurn(slower, faster, slower.getMove2());
					break;
				case 3:
					bt.executeTurn(slower, faster, slower.getMove3());
					break;
				case 4:
					bt.executeTurn(slower, faster, slower.getMove4());
					break;
				default:
					bt.executeTurn(slower, faster, slower.getMove1());
					break;
			}
			bt.endOfTurnChecks(p1, p2);
			System.out.println("**********************************");
		}
		if (p1.getFaint()) {
			System.out.println(p1.getName() + " is unable to battle. " + p2.getName() + " wins!");
		} else if (p2.getFaint()) {
			System.out.println(p2.getName() + " is unable to battle. " + p1.getName() + " wins!");
		} else {
			System.out.println("Draw?");
		}
	}
}