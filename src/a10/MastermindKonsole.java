package a10;

import java.util.Scanner;

/**
 * @author Ruben Christian Buhl
 */

public class MastermindKonsole
{
	private char eingabe;

	private Scanner scanner;

	public MastermindKonsole()
	{
		scanner = new Scanner(System.in);
	}

	public void starten()
	{
		while(eingabe != 'x')
		{
			System.out.println("m - Mastermind spielen (Mensch)\nc - Mastermind spielen (Computer)\nx - Programm beenden");

			eingabe = scanner.nextLine().charAt(0);

			switch(eingabe)
			{
				case 'm':
					spielen(new Mensch(), new Zahl());
					break;
				case 'c':
					spielen(new Computer(), new Zahl(scanner.nextLine().toCharArray()));
					break;
				case 'x':
					System.out.println("Das Programm wird beendet.");
					break;
				default:
					System.out.println("Die Eingabe ist ungültig. Bitte versuchen Sie es erneut.\n");
			}
		}
	}

	private void spielen(Spieler spieler, Zahl zahl)
	{
		Versuch versuch = null;

		for(int i = 1; i <= 10; i++)
		{
			System.out.println("\n" + i + ". Versuch:");

			versuch = spieler.versuchGenerieren();

			versuch.setDirekteTreffer(zahl.direkteTreffer(versuch.getZahl()));
			versuch.setIndirekteTreffer(zahl.indirekteTreffer(versuch.getZahl()));

			spieler.addVersuch(versuch);

			System.out.println("Direkte Treffer: " + versuch.getDirekteTreffer() + "\nIndirekte Treffer: " + versuch.getIndirekteTreffer());

			if(versuch.getDirekteTreffer() == 4)
			{
				break;
			}
		}

		System.out.println(spieler.text(versuch.getDirekteTreffer() == 4));
	}
}