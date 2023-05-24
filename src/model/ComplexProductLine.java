package model;

public class ComplexProductLine 
{
	private int quantity;
	private Product product;
	
	public ComplexProductLine(int quantity)
	{
		this.quantity = quantity;
	}
	
	/**
	 * @param Product
	 * Tilføjer et produkt til linjen
	 */
	public void addProduct(Product p)
	{
		if (p != null) {
			this.product = p; 
		} else {
				System.out.println("Produkt findes ikke");
			}
	}
	
	/**
	 * @return quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}
	/**
	 * @return product
	 */
	public Product getProduct()
	{
		return product;
	}
	/**
	 * @return returnerer prisen for det specifikke produkt
	 */
	public double getCost()
	{
		return product.getPrice();
	}
	/**
	 * @return den totale pris af linjen
	 */
	public double getTotalCost()
	{
		return (product.getPrice() * quantity);
	}
}

	
