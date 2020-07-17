package a10;

/**
 * @author Ruben Christian Buhl
 */

public class Versuch
{
	private Zahl zahl;

	private int direkteTreffer;
	private int indirekteTreffer;

	public Versuch(Zahl zahl)
	{
		this.zahl = zahl;
	}

	public Zahl getZahl()
	{
		return zahl;
	}

	public int getDirekteTreffer()
	{
		return direkteTreffer;
	}

	public void setDirekteTreffer(int direkteTreffer)
	{
		this.direkteTreffer = direkteTreffer;
	}

	public int getIndirekteTreffer()
	{
		return indirekteTreffer;
	}

	public void setIndirekteTreffer(int indirekteTreffer)
	{
		this.indirekteTreffer = indirekteTreffer;
	}

	public int getTreffer()
	{
		return direkteTreffer + indirekteTreffer;
	}
}