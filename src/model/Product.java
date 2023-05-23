package model;

public abstract class Product {
	private String name;
	private int itemNumber;
	private static int itemNumberCount = 0;
	private String category;
	private double price;

	/**
	 * Constructor
	 * @param name
	 * @param category
	 */
	public Product(String name, String category)
	{
		this.name = name;
		this.category = category;
		itemNumberCount++;
		itemNumber = itemNumberCount;
	}
	/**
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param set name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return category
	 */
	public String getCategory()
	{
		return category;
	}
	/**
	 * @param set category
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}
	/**
	 * @return itemNumberCount
	 */
	public static int getItemNumberCount()
	{
		return itemNumberCount;
	}
	/**
	 * @return itemNumber
	 */
	public int getItemNumber()
	{
		return itemNumber;
	}
	/**
	 * @return price
	 */
	public double getPrice()
	{
		return price;
		
	}
}
