package pizza;

public class Wahrenkorb
{
	private Pizza pizza;
	private Grose grose;
	private Extra extra;
	public Wahrenkorb(Pizza pizza, Grose grose, Extra extra)
	{
		super();
		this.pizza = pizza;
		this.grose = grose;
		this.extra = extra;
	}
	public Pizza getPizza()
	{
		return pizza;
	}
	public void setPizza(Pizza pizza)
	{
		this.pizza = pizza;
	}
	public Grose getGrose()
	{
		return grose;
	}
	public void setGrose(Grose grose)
	{
		this.grose = grose;
	}
	public Extra getExtra()
	{
		return extra;
	}
	public void setExtra(Extra extra)
	{
		this.extra = extra;
	}
	@Override
	public String toString()
	{
		return  pizza + " " + grose + " mit "+extra ;
	}

	
	
	
}
