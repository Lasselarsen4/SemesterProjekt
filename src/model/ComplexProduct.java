package model;

import java.util.List;
import java.util.ArrayList;

public class ComplexProduct extends Product
{
	private List<ComplexProductLine> complexProductLines;
	
	/**
	 * Constructor
	 * @param name
	 * @param category
	 */
	public ComplexProduct(String name, String category)
	{
		super(name, category);
		this.complexProductLines = new ArrayList<>();
	}
	
	/**
	 * @param p
	 * @param quantity
	 * @return
	 * Tjekker om produktet eksisterer og tilføjer det.
	 */
	public ComplexProductLine addProduct(Product p, int quantity)
	{
		ComplexProductLine line = null;
		if (p != null) {
			line = new ComplexProductLine(quantity);
			line.addProduct(p);
			complexProductLines.add(line);
		}
		return line;
	}
	/**
	 * @return prisen for hele linjen
	 */
	public double getPrice()
	{
		double result = 0;
		for (ComplexProductLine list : complexProductLines) {
			result += list.getTotalCost();
		}
		return result;
	}
	
	/**
	 * @param i
	 * @return linjen
	 */
	public ComplexProductLine getProduct(int i)
	{
		return complexProductLines.get(i);
	}
	/**
	 * @return kopi af listen
	 */
	public List<ComplexProductLine> getProductLines()
	{
		return new ArrayList<ComplexProductLine>(complexProductLines);
	}
	/**
	 * @param i
	 * @return mængden af produkter
	 */
	public int getQuantity(int i)
	{
		return complexProductLines.get(i).getQuantity();
	}
	public void removeProduct(ComplexProductLine line)
	{
		complexProductLines.remove(line);
	}
}