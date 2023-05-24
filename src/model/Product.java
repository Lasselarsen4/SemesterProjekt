package model;

public abstract class Product {
	private String name;
	private int barCode;
	private static int barCodeCount = 0;
	private String category;

	/**
	 * Constructor
	 * @param name
	 * @param category
	 */
	public Product(String name, String category)
	{
		this.name = name;
		this.category = category;
		barCodeCount++;
		barCode = barCodeCount;
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
	public static int getBarCodeCount()
	{
		return barCodeCount;
	}
	/**
	 * @return itemNumber
	 */
	public int getBarCode()
	{
		return barCode;
	}
	/**
	 * @return price
	 */
	public abstract double getPrice();

}
