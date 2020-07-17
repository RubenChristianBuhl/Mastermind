package a10;

/**
 * @author Ruben Christian Buhl
 */

public abstract class Spieler
{
	public abstract Versuch versuchGenerieren();

	public abstract String text(boolean gewonnen);

	public abstract void addVersuch(Versuch versuch);
}