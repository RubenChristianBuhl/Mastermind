package a10;

import java.util.ArrayList;

/**
 * @author Ruben Christian Buhl
 */

public class Computer extends Spieler
{
	private ArrayList<Versuch> versuche;

	public Computer()
	{
		versuche = new ArrayList<Versuch>();
	}

	@Override
	public Versuch versuchGenerieren()
	{
		Zahl zahl = new Zahl();

		boolean b;

		do
		{
			zahl.inkrementieren();

			b = false;

			for(Versuch versuch : versuche)
			{
				if(zahl.direkteTreffer(versuch.getZahl()) != versuch.getDirekteTreffer() || zahl.indirekteTreffer(versuch.getZahl()) != versuch.getIndirekteTreffer())
				{
					b = true;
				}
			}
		}
		while(b);

		System.out.println(zahl);

		return new Versuch(zahl);
	}

	@Override
	public String text(boolean gewonnen)
	{
		return (gewonnen) ? "\nDer Computer hat gewonnen!\n" : "\nDer Computer hat verloren!\n";
	}

	@Override
	public void addVersuch(Versuch versuch)
	{
		versuche.add(versuch);
	}
}