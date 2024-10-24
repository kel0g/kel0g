package pizza;

public class Grose
{
	private String grose;
	private double preis;
	
		public Grose(String grose, double preis)
	{
		super();
		this.grose = grose;
		this.preis = preis;
	}

	
	
	public String getGrose()
	{
		return grose;
	}
	public void setGrose(String grose)
	{
		this.grose = grose;
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
		return grose;
	}
}
