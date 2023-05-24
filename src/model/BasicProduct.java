package model;

public class BasicProduct extends Product
{
	private double cost;
	private SalesLine s;
	
	/**
	 * Constructor
	 * @param name
	 * @param category
	 */
	public BasicProduct(String name, String category)
	{
		super(name, category);
	}
	/**
	 * @param price
	 * @param currentStock
	 * @param minStock
	 * @param maxStock
	 * @param location
	 * Tilføjer alt information til det specifikke produkt
	 */
	public void addInfo(double cost, int currentStock, int minStock, int maxStock, String location) {
		this.cost = cost;
		s = new SalesLine(currentStock, minStock, maxStock, location);
	}
	/**
	 * @return price
	 */
	public double getCost()
	{
		return cost;
	}
	/**
	 * @param set cost
	 */
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	/**
	 * @return location
	 */
	public String getLocation()
	{
		return s.getLocation();
	}
	/**
	 * @param set location
	 */
	public void setLocation(String location)
	{
		s.setLocation(location);
	}
	public SalesLine getSalesLine()
	{
		return s;
	}

}
