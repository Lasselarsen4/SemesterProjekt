package model;

public class OrderLine 
{
	private Product product;
	private int quantity;
	
	/**
	 * @param p
	 * @param quantity
	 */
	public OrderLine(Product p, int quantity)
	{
		this.product = p;
		this.quantity = quantity;
	}
	/**
	 * @return product
	 */
	public Product getProduct()
	{
		return product;
	}
	/**
	 * @return quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * @param Set quantity
	 */
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	/**
	 * @return 
	 * Returnerer den fulde pris for produktet alt efter hvor mange der købes.
	 */
	public double getPrice()
	{
		if (product != null) //Tjekker om produktet er tilknyttet
		{
			return quantity * product.getPrice(); //Beregner den fulde pris og returnere denne
		}
		else
		{
			// Hvis product = null, printer vi en fejlmeddelelse
			throw new NullPointerException("Der er intet produkt tilknyttet");
		}
	}

}
