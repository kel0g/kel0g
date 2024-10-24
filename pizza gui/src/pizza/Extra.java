package pizza;

public class Extra
{
	private String extra;
	private double preis;
	
	public Extra(String extra, double preis)
	{
		super();
		this.extra = extra;
		this.preis = preis;
	}
	
	public String getExtra()
	{
		return extra;
	}
	public void setGrose(String extra)
	{
		this.extra = extra;
	}
	public double getPreis()
	{
		return preis;
	}
	public void setPreis(double preis)
	{
		this.preis = preis;
	}
	

	@Override
	public String toString()
	{
		return extra ;
	}

}
