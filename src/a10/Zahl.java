package a10;

/**
 * @author Ruben Christian Buhl
 */

public class Zahl
{
	private int[] ziffern = new int[4];

	public Zahl()
	{
		ziffernGenerieren();
	}

	public Zahl(char[] zahl)
	{
		setZiffern(zahl);
	}

	private void ziffernGenerieren()
	{
		int ziffer;

		for(int i = 0; i < ziffern.length; i++)
		{
			do
			{
				ziffer = (int) (Math.random() * 10);
			}
			while(contains(ziffer) != 0);

			ziffern[i] = ziffer;
		}
	}

	public int direkteTreffer(Zahl zahl)
	{
		int direkteTreffer = 0;

		int[] ziffern = zahl.getZiffern();

		for(int i = 0; i < this.ziffern.length; i++)
		{
			if(this.ziffern[i] == ziffern[i])
			{
				direkteTreffer++;
			}
		}

		return direkteTreffer;
	}

	public int indirekteTreffer(Zahl zahl)
	{
		int indirekteTreffer = 0;

		int[] ziffern = zahl.getZiffern();

		for(int i = 0; i < this.ziffern.length; i++)
		{
			for(int j = 0; j < ziffern.length; j++)
			{
				if(this.ziffern[i] == ziffern[j] && i != j)
				{
					indirekteTreffer++;
				}
			}
		}

		return indirekteTreffer;
	}

	public int treffer(Zahl zahl)
	{
		return direkteTreffer(zahl) + indirekteTreffer(zahl);
	}

	public void inkrementieren()
	{
		Zahl zahl;

		int i = Integer.parseInt(this.toString());

		boolean b;

		do
		{
			i++;

			if(i > 9999)
			{
				i = 0;
			}

			b = false;

			zahl = new Zahl(Integer.toString(i).toCharArray());

			for(int ziffer : zahl.getZiffern())
			{
				if(zahl.contains(ziffer) > 1)
				{
					b = true;

					break;
				}
			}
		}
		while(b);

		setZiffern(Integer.toString(i).toCharArray());
	}

	public void setZiffern(int[] ziffern)
	{
		this.ziffern = ziffern;
	}

	public void setZiffern(char[] ziffern)
	{
		int j = 0;

		for(int i = 0; i < this.ziffern.length; i++)
		{
			if(this.ziffern.length - i <= ziffern.length)
			{
				this.ziffern[i] = ziffern[j] - '0';

				j++;
			}
			else
			{
				this.ziffern[i] = 0;
			}
		}
	}

	public int[] getZiffern()
	{
		return ziffern;
	}

	public int contains(int i)
	{
		int contains = 0;

		for(int ziffer : ziffern)
		{
			if(ziffer == i)
			{
				contains++;
			}
		}

		return contains;
	}

	@Override
	public String toString()
	{
		String zahl = "";

		for(int ziffer : ziffern)
		{
			zahl += ziffer;
		}

		return zahl;
	}
}