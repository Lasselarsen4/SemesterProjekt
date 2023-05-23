package model;

public class SalesLine 
{

	private int currentStock;
	private int minStock;
	private int maxStock;
	private Location location;

	/**
	 * Constructor
	 * @param currentStock
	 * @param minStock
	 * @param maxStock
	 * @param location
	 */
	public SalesLine(int currentStock, int minStock, int maxStock, String location) 
	{
		this.currentStock = currentStock;
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.location = new Location(location);
	}

	/**
	 * @return Tjekker om produkt er på lager eller ej
	 */
	public boolean checkInventory() 
	{
		boolean isStockAvailable = false;
		if (currentStock <= minStock) 
		{
			placeOrder();
			isStockAvailable = true;
		}
		return isStockAvailable;
	}

	/**
	 * Metode til at bestille varer hvis lagerbeholdning er lav
	 */
	private void placeOrder() 
	{
		setStock(maxStock);
	}

	/**
	 * @return nuværende mængde på lager
	 */
	public int getStock() 
	{
		return currentStock;
	}

	/**
	 * @param set currentStock
	 * 
	 */
	public void setStock(int currentStock) 
	{
		this.currentStock = currentStock;
	}

	/**
	 * @return Minimum mængde på lager.
	 */
	public int getMinStock()
	{
		return minStock;
	}

	/**
	 * @param set minStock
	 */
	public void setMinStock(int minStock) 
	{
		this.minStock = minStock;
	}

	/**
	 * @return maxStock
	 */
	public int getMaxStock() 
	{
		return maxStock;
	}

	/**
	 * @param set maxStock
	 */
	public void setMaxStock(int maxStock) 
	{
		this.maxStock = maxStock;
	}

	/**
	 * @param location
	 */
	public void setLocation(String loc1) 
	{
		location.setLocation(loc1);
	}

	/**
	 * @return location
	 */
	public String getLocation() 
	{
		return location.getLocation();
	}
	
}