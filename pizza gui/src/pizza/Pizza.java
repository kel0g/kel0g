package pizza;

import java.util.ArrayList;

public class Pizza
{
	private String name;
	private ArrayList<Extra> extras;
	private ArrayList<Grose> groesse;
	
	
	public Pizza(String name)
	{
		super();
		this.name = name;
		
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}



	@Override
	public String toString()
	{
		return name ;
	}
}
