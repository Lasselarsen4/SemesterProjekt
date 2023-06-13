package model;

public class BasicProduct extends Product
{
	private SalesLine s;
	private double price;
	
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
	public void addInfo(double price, int currentStock, int minStock, int maxStock, String location) {
		this.price = price;
		s = new SalesLine(currentStock, minStock, maxStock, location);
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
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public void setSalesLine(SalesLine salesLine) {
		// TODO Auto-generated method stub
		
	}

}
