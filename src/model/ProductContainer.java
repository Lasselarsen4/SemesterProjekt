package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductContainer
{

	private static ProductContainer instance;
	private List<Product> products;
	private Comparator<Product> productComparator;


	/**
	 * Opretter en privat constructor for at sikre,
	 * at der kun kan oprettes én instans af ProductContainer.
	 * Constructor kan kun kaldes via getInstance-metoden.
	 */
	private ProductContainer()
	{
		products = new ArrayList<>();
		productComparator = ((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
	}

	public static ProductContainer getInstance()
	{
		if (instance == null)
		{
			instance = new ProductContainer();
		}
		return instance;
	}

	public void addProduct(Product product)
	{
		if (product != null)
		{
			products.add(product);
			sort();
		}

	}

	public Product findProductByItemNumber(int itemNumber)
	{
		Product result = null;
		boolean found = false;
		for (int i = 0; i < products.size() && !found; i++)
		{
			if (itemNumber == (products.get(i).getItemNumber()))
			{
				result = products.get(i);
			}

		}
		return result;
	}

	public List<Product> getAllProducts()
	{
		ArrayList<Product> temp = new ArrayList<>();
		temp = (ArrayList<Product>) products;
		return temp;
	}

	private void sort() 
	{
		Collections.sort(products, productComparator);
	}

}