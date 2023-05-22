package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderContainer 
{
	private List<Order> orders;
	private static OrderContainer instance;
	private Comparator<Order> orderComparator;

	/**
	 * Privat constructor, som kun tilgås via getInstance()
	 */
	private OrderContainer()
	{
		orders = new ArrayList<>();
		orderComparator = (o1, o2) -> o1.getOrderNumber() - o2.getOrderNumber();
	}

	/**
	 * Metoden garanterer, at der kun eksisterer én instans af containeren og er derfor den eneste adgangspunkt til containeren.
	 * 
	 * @return containerobjektet
	 */
	public static OrderContainer getInstance()
	{
		if (instance == null)
		{
			instance = new OrderContainer();
		}
		return instance;
	}

	/**
	 * Denne metode bruges til at tilføje nye Order-objekter til containeren til senere brug. Efter objektet er tilføjet til ArrayList, køres en sortering for at sikre, at søgemetoden fungerer korrekt.
	 * 
	 * @param o den order, du vil tilføje til containeren
	 */
	public void addOrder(Order o)
	{
		if (o != null)
		{
			orders.add(o);
			sort();
		}
	}

	/**
	 * Denne metode søger efter ordrer i containeren.
	 * 
	 * @param orderNumber 
	 * @return Order-objektet med tilsvarende ordrenummer eller null, hvis intet match findes
	 */
	public Order findOrder(int orderNumber)
	{
		Order searchOrder = new Order();
		searchOrder.setOrderNumber(orderNumber);
		Order result = null;
		try
		{
			int index = Collections.binarySearch(orders, searchOrder, orderComparator);
			result = orders.get(index);
		} catch (NullPointerException npe)
		{
			return result;
		}
		return result;
	}

	/**
	 * En metode til at sortere containeren
	 */
	private void sort()
	{
		Collections.sort(orders, orderComparator);
	}
	
	/**
	 * @return en liste med alle ordrer i containeren
	 */
	public List<Order> getAllOrders()
	{
		List<Order> tempList = new ArrayList<>(orders);
		return tempList;
	}

}


