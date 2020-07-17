package a10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ruben Christian Buhl
 */

public class Mensch extends Spieler
{
	private ArrayList<Versuch> versuche;

	private Scanner scanner;

	public Mensch()
	{
		versuche = new ArrayList<Versuch>();

		scanner = new Scanner(System.in);
	}

	@Override
	public Versuch versuchGenerieren()
	{
		return new Versuch(new Zahl(scanner.nextLine().toCharArray()));
	}

	@Override
	public String text(boolean gewonnen)
	{
		return (gewonnen) ? "\nHerzlichen Glückwunsch!\nSie haben gewonnen!\n" : "\nSie haben verloren!\n";
	}

	@Override
	public void addVersuch(Versuch versuch)
	{
		versuche.add(versuch);
	}
}